package com.xebia.entity;

import com.xebia.entity.spaceship.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    String userId;

    String fullName;

    Grid grid;

    List<SpaceShip> spaceShips = new ArrayList<>(5);

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

    /**
     * Creates the spaceship fleet and adds it to the board
     */

    // TODO Refactor method
    public void createFleet(){
        log.info("CREATING PLAYER: {} FLEET", this.userId);

        AngleSpaceShip angleSpaceShip = new AngleSpaceShip(this.grid);
        this.grid.placeSpaceShip(angleSpaceShip);
        this.spaceShips.add(angleSpaceShip);

        ASpaceShip aSpaceShip = new ASpaceShip(this.grid);
        this.grid.placeSpaceShip(aSpaceShip);
        this.spaceShips.add(aSpaceShip);

        BSpaceShip bSpaceShip = new BSpaceShip(this.grid);
        this.grid.placeSpaceShip(bSpaceShip);
        this.spaceShips.add(bSpaceShip);

        SSpaceShip sSpaceShip = new SSpaceShip(this.grid);
        this.grid.placeSpaceShip(sSpaceShip);
        this.spaceShips.add(sSpaceShip);

        WingerSpaceShip wingerSpaceShip = new WingerSpaceShip(this.grid);
        this.grid.placeSpaceShip(wingerSpaceShip);
        this.spaceShips.add(wingerSpaceShip);
    }
}
