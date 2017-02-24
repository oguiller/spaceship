package com.xebia.entity;

import com.xebia.entity.spaceship.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    String userId;

    String fullName;

    Grid grid;

    public Player(String userId, String fullName){
        this.userId = userId;
        this.fullName = fullName;
        this.grid = new Grid();
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
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

    /**
     * Creates the spaceship fleet and adds it to the board
     */

    // TODO Refactor method
    public void createFleet(){
        log.info("CREATING PLAYER: {} FLEET", this.userId);

        AngleSpaceShip angleSpaceShip = new AngleSpaceShip();
        this.grid.placeSpaceShip(angleSpaceShip);

        ASpaceShip aSpaceShip = new ASpaceShip();
        this.grid.placeSpaceShip(aSpaceShip);

        BSpaceShip bSpaceShip = new BSpaceShip();
        this.grid.placeSpaceShip(bSpaceShip);

        SSpaceShip sSpaceShip = new SSpaceShip();
        this.grid.placeSpaceShip(sSpaceShip);

        WingerSpaceShip wingerSpaceShip = new WingerSpaceShip();
        this.grid.placeSpaceShip(wingerSpaceShip);
    }
}
