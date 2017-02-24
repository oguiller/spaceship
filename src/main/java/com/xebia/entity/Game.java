package com.xebia.entity;

import com.xebia.request.SpaceShipProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the Game.
 */
public class Game {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String gameId;

    // I think this should belong to the Opponent
    private SpaceShipProtocol spaceShipProtocol;

    private Player self;

    private Player opponent;

    private boolean turn;

    public Game(String gameId, Player self, Player opponent,  SpaceShipProtocol spaceShipProtocol){
        super();
        this.gameId = gameId;
        this.spaceShipProtocol = spaceShipProtocol;
        this.self = self;
        this.opponent = opponent;
    }

    public Player getSelf() {
        return self;
    }

    public void setSelf(Player self) {
        this.self = self;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public SpaceShipProtocol getSpaceShipProtocol() {
        return spaceShipProtocol;
    }

    public void setSpaceShipProtocol(SpaceShipProtocol spaceShipProtocol) {
        this.spaceShipProtocol = spaceShipProtocol;
    }

    public void updateTurn(){
        turn = !turn;
    }

    public Player getPlayerTurn(){
        return turn ? self : opponent;
    }
}
