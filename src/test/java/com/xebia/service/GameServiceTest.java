package com.xebia.service;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;
import com.xebia.entity.Game;
import com.xebia.entity.Grid;
import com.xebia.entity.StrikeType;
import com.xebia.entity.spaceship.AngleSpaceShip;
import com.xebia.entity.spaceship.SpaceShip;
import com.xebia.request.SpaceShipProtocol;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameServiceTest {

    private static final String OPPONENT_USER_ID = "test-1";
    private static final String OPPONENT_FULL_NAME = "test test";

    SpaceShipProtocol spaceShipProtocol;

    GameService gameService;

    @Before
    public void setup() {
        spaceShipProtocol = new SpaceShipProtocol();
        spaceShipProtocol.setHostName("127.0.0.1");
        spaceShipProtocol.setPort(9001);
    }

    @Test
    public void testCreateGame() {
        gameService = new GameService();

        Game game = gameService.createNewGame(OPPONENT_USER_ID, OPPONENT_FULL_NAME, spaceShipProtocol);

        Assert.assertTrue(game.getOpponent().getUserId().equals(OPPONENT_USER_ID));
        Assert.assertTrue(game.getOpponent().getFullName().equals(OPPONENT_FULL_NAME));
        Assert.assertNotNull(game.getSelf());
    }

    @Test
    public void testGettingFiredHitAll() {
        gameService = new GameService();

        Game game = gameService.createNewGame(OPPONENT_USER_ID, OPPONENT_FULL_NAME, spaceShipProtocol);

        Grid myGrid = game.getSelf()
                .getGrid();

        List<String> salvo = new ArrayList<>();

        for (int i = 0; i < myGrid.getSpaceShips().size(); i++) {
            salvo.add(generateHit(myGrid));
        }

        Map<String, String> salvoResult = gameService.gettingFired(salvo, game.getGameId());

        for (String result : salvoResult.values()) {
            Assert.assertTrue(result.equals(StrikeType.HIT.getDesc()));
        }
    }

    @Test
    public void testGettingFiredMissOne() {
        gameService = new GameService();

        Game game = gameService.createNewGame(OPPONENT_USER_ID, OPPONENT_FULL_NAME, spaceShipProtocol);

        Grid myGrid = game.getSelf()
                .getGrid();

        List<String> salvo = new ArrayList<>();

        String positionIsAMiss = generateMiss(myGrid);
        List<String> positionsAreHits = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            positionsAreHits.add(generateHit(myGrid));
        }

        salvo.add(positionIsAMiss);
        salvo.addAll(positionsAreHits);

        Map<String, String> salvoResult = gameService.gettingFired(salvo, game.getGameId());

        Assert.assertTrue(salvoResult.get(positionIsAMiss).equals(StrikeType.MISS.getDesc()));

        for (String position : positionsAreHits) {
            Assert.assertTrue(salvoResult.get(position).equals(StrikeType.HIT.getDesc()));
        }

    }


    @Test
    public void testGettingFiredKill() {
        gameService = new GameService();
        String opponentUserId = "test-1";
        String opponentFullName = "test test";

        Game game = gameService.createNewGame(opponentUserId, opponentFullName, spaceShipProtocol);

        Grid myGrid = game.getSelf()
                .getGrid();

        Optional<SpaceShip> optionalSpaceShip = myGrid
                .getSpaceShips()
                .stream().filter(spaceShip1 -> spaceShip1.getType() == AngleSpaceShip.ANGLE_SPACE_SHIP).findFirst();

        List<String> salvo = new ArrayList<>();

        optionalSpaceShip.ifPresent(spaceShip -> {
            for (Coordinate coordinate : spaceShip.getCoordinates()){
                salvo.add(coordinate.toHexDec());
            }
        });

        Map<String, String> salvoResult = gameService.gettingFired(salvo, game.getGameId());
        System.out.println(salvoResult);
        Assert.assertTrue(salvoResult.containsValue(StrikeType.KILL.getDesc()));
    }

    @Test
    public void updatingTurnAfterGettingFired(){

        gameService = new GameService();
        Game game = gameService.createNewGame(OPPONENT_USER_ID, OPPONENT_FULL_NAME, spaceShipProtocol);
        Assert.assertTrue(game.getPlayerTurn().getUserId()== OPPONENT_USER_ID);

        Grid myGrid = game.getSelf()
                .getGrid();

        List<String> salvo = new ArrayList<>();

        String positionIsAMiss = generateMiss(myGrid);
        List<String> positionsAreHits = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            positionsAreHits.add(generateHit(myGrid));
        }

        Map<String, String> salvoResult = gameService.gettingFired(salvo, game.getGameId());
        Assert.assertTrue(game.getPlayerTurn().getUserId()== game.getSelf().getUserId());

    }

    private String generateMiss(Grid myGrid) {
        int position = Utils.getRandomInt(0, myGrid.getFree().size());
        return myGrid.getFree().get(position).toHexDec();
    }

    private String generateHit(Grid myGrid) {
        int position = Utils.getRandomInt(0, myGrid.getTaken().size());
        return myGrid.getTaken().get(position).toHexDec();
    }


}
