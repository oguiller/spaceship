package com.xebia.entity;

import com.xebia.Utils;
import com.xebia.entity.spaceship.SpaceShip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is responsible for displaying the board game
 */
public class Grid {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private int width = 16;

    private int height = 16;

    private String[][] board;

    private List<Coordinate> taken = new ArrayList<>();

    private List<Coordinate> free = new ArrayList<>();

    private List<SpaceShip> spaceShips = new ArrayList<>();

    public Grid() {
        board = new String[width][height];
        this.init();
    }

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        board = new String[width][height];
        this.init();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public List<Coordinate> getTaken() {
        return taken;
    }

    public void setTaken(List<Coordinate> taken) {
        this.taken = taken;
    }

    public List<Coordinate> getFree() {
        return free;
    }

    public void setFree(List<Coordinate> free) {
        this.free = free;
    }

    public int getSize(){
        return width * height;
    }

    public List<SpaceShip> getSpaceShips() {
        return spaceShips;
    }

    public void setSpaceShips(List<SpaceShip> spaceShips) {
        this.spaceShips = spaceShips;
    }

    /**
     * This method inits the Grid
     */
    private void init() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.board[i][j] = ".";
                free.add(new Coordinate(i, j));
            }
        }
    }

    /**
     * This method updates our board
     */
    private void update(){
        for (Coordinate coord: taken){
            board[coord.getRow() - 1][coord.getColumn() - 1] = "*";
        }
    }

    public String render() {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                board.append(this.board[i][j]);
                if (j == (this.width - 1)) {
                    board.append("\n");
                    continue;
                }
            }
        }

        return board.toString();
    }

    /**
     * Checke if the coordinates are available in the Grid.
     *
     * @return
     */

    private boolean areGridCoordinatesAvailableForSpaceShip(SpaceShip spaceShip) {

        for (Coordinate coordinate : spaceShip.getCoordinates()) {
            if (taken.contains(coordinate)) {
                log.info("Conflicts: {} at position {}", coordinate, taken.indexOf(coordinate));
                return false;
            }
        }

        return true;
    }

    public boolean isInitialCoordinateValid(Coordinate initialCoordinate, SpaceShip spaceShip) {
        if ((initialCoordinate.getRow() + spaceShip.getHeight() > this.getHeight()) || (initialCoordinate.getColumn() + spaceShip.getWidth() > this.getWidth())) {
            return false;
        }

        if ((initialCoordinate.getRow() - spaceShip.getHeight() < 0) || (initialCoordinate.getColumn() - spaceShip.getWidth() < 0)) {
            return false;
        }

        return true;
    }

    /**
     * The grid knows where to place the spaceship.
     * @param spaceShip
     */
    public void placeSpaceShip(SpaceShip spaceShip) {

        boolean found = false;
        log.debug("PLACING SHIP ON GRID (FREE {}, TAKEN {})", free.size(), taken.size());
        Random random = new Random();
        boolean rotate;

        while (!found) {
            Coordinate initialCoordinate = free.get(Utils.getRandomInt(0, free.size()));

            if (!isInitialCoordinateValid(initialCoordinate, spaceShip)) {
                continue;
            }

            spaceShip.build(initialCoordinate);
            rotate = random.nextBoolean();

            if (rotate) {
                spaceShip.rotate(initialCoordinate);
            }

            if (areGridCoordinatesAvailableForSpaceShip(spaceShip)) {
                found = true;
                taken.addAll(spaceShip.getCoordinates());
                this.spaceShips.add(spaceShip);
                break;
            }
        }

        if (found) {
            free.removeAll(spaceShip.getCoordinates());
        }

        this.update();
    }

}
