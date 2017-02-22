package com.xebia.service;

import com.xebia.entity.Game;
import com.xebia.entity.Grid;
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

    private Map<String, Game> games = new HashMap<>();

    public Game createNewGame(String opponentUserId, String opponentFullName, SpaceShipProtocol spaceShipProtocol){
        LOGGER.info("CREATING NEW GAME");
        Player self = new Player("player", "Assesment Player", new Grid());
        self.createFleet();
        Player opponent = new Player(opponentUserId, opponentFullName, new Grid());

        StringBuilder gameId = new StringBuilder();
        gameId.append("match-").append(games.size() + 1);

        Game game = new Game(gameId.toString(), self, opponent, spaceShipProtocol);
        games.put(gameId.toString(), game);

        return game;
    }
}
