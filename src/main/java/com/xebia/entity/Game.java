package com.xebia.entity;

import com.xebia.request.SpaceShipProtocol;

public class Game {

    String gameId;

    SpaceShipProtocol spaceShipProtocol;

    Player self;

    Player opponent;

    public Game(){

    }

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
}
