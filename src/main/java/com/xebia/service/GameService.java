package com.xebia.service;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;
import com.xebia.entity.Game;
import com.xebia.entity.Player;
import com.xebia.entity.StrikeType;
import com.xebia.request.SpaceShipProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);
    public static final String MATCH_PREFIX = "match-";

    private Map<String, Game> games = new HashMap<>();

    /**
     * Creates a new Game
     * @param opponentUserId the UserId of the opponent player
     * @param opponentFullName the full name of the opponent
     * @param spaceShipProtocol the spaceShipProtocol
     * @return
     */
    public Game createNewGame(String opponentUserId, String opponentFullName, SpaceShipProtocol spaceShipProtocol){
        LOGGER.info("CREATING NEW GAME");
        Player self = new Player("player", "Assesment Player");
        self.createFleet();

        Player opponent = new Player(opponentUserId, opponentFullName);

        StringBuilder gameId = new StringBuilder();
        gameId.append(MATCH_PREFIX).append(games.size() + 1);

        Game game = new Game(gameId.toString(), self, opponent, spaceShipProtocol);
        games.put(gameId.toString(), game);

        return game;
    }

    public Map<String, String> gettingFired(List<String> salvo, String gameId){

        Map<String, String> salvoResponse = new HashMap<>();

        Game game = games.get(gameId);
        List<Coordinate> salvoCoordinates = Utils.toCoordinates(salvo);
        Map<Coordinate, StrikeType> results = game.getSelf().getGrid().gettingFired(salvoCoordinates);

        for (Coordinate coordinate : salvoCoordinates) {
            StrikeType strikeType = results.get(coordinate);
            String result = strikeType != null ? strikeType.getDesc() : StrikeType.MISS.getDesc();
            salvoResponse.put(coordinate.toHexDec(), result);
        }

        updateTurn(gameId);

        return salvoResponse;
    }

    public Player getTurn(String gameId) {
        Game game = games.get(gameId);
        return game.getPlayerTurn();
    }

    public void updateTurn(String gameId) {
        Game game = games.get(gameId);
        game.updateTurn();
    }
}
