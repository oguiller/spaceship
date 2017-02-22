package com.xebia.service;

import com.xebia.entity.Game;
import com.xebia.request.SpaceShipProtocol;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.jvm.hotspot.memory.Space;

public class GameServiceTest {

    @Test
    public void testCreateGame(){

        GameService gameService = new GameService();
        SpaceShipProtocol spaceShipProtocol = new SpaceShipProtocol();
        spaceShipProtocol.setHostName("127.0.0.1");
        spaceShipProtocol.setPort(9001);
        Game game = gameService.createNewGame("whatever","ou yeah!!", spaceShipProtocol);
        System.out.println(game.getSelf().getGrid().render());
    }
}
