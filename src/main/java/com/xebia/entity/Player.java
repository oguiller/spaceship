package com.xebia.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);

    String userId;

    String fullName;

    Grid grid;

    List<SpaceShip> spaceShips = new ArrayList<>(5);

    public Player(String userId, String fullName, Grid grid){
        this.userId = userId;
        this.fullName = fullName;
        this.grid = grid;
        this.createFleet();
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<SpaceShip> getSpaceShips() {
        return spaceShips;
    }

    public void setSpaceShips(List<SpaceShip> spaceShips) {
        this.spaceShips = spaceShips;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private void createFleet(){
        LOGGER.info("CREATING PLAYER: {} FLEET", this.userId);
        this.spaceShips.add(new LSpaceShip(this.grid));
        this.grid.setSpaceShips(this.spaceShips);
    }
}
