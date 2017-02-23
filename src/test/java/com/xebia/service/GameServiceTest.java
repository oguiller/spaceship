package com.xebia.service;

import com.xebia.entity.Game;
import com.xebia.request.SpaceShipProtocol;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameServiceTest {

    SpaceShipProtocol spaceShipProtocol;

    @Before
    public void setup(){
        spaceShipProtocol = new SpaceShipProtocol();
        spaceShipProtocol.setHostName("127.0.0.1");
        spaceShipProtocol.setPort(9001);
    }

    @Test
    public void testCreateGame(){
        GameService gameService = new GameService();
        String opponentUserId = "test-1";
        String opponentFullName = "test test";

        Game game = gameService.createNewGame(opponentUserId, opponentFullName, spaceShipProtocol);

        Assert.assertTrue(game.getOpponent().getUserId().equals(opponentUserId));
        Assert.assertTrue(game.getOpponent().getFullName().equals(opponentFullName));
        Assert.assertNotNull(game.getSelf());
    }

}
