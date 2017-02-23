package com.xebia.service;

import com.xebia.entity.Game;
import com.xebia.entity.Player;
import com.xebia.request.SpaceShipProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
