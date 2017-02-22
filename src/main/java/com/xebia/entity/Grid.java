package com.xebia.entity;

import com.xebia.entity.spaceship.SpaceShip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class is responsible for displaying the board game
 */
public class Grid {

    private static final Logger LOGGER = LoggerFactory.getLogger(Grid.class);

    private int width = 16;

    private int height = 16;

    private String[][] board;

    private List<Coordinate> taken = new ArrayList<>();

    private List<Coordinate> free = new ArrayList<>();

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

    private List<SpaceShip> spaceShips = new ArrayList<>(5);

    public List<SpaceShip> getSpaceShips() {
        return spaceShips;
    }

    public void setSpaceShips(List<SpaceShip> spaceShips) {
        this.spaceShips = spaceShips;
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
            board[coord.getRow()][coord.getColumn()] = "*";
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
     * @param coordinates
     * @return
     */

    public boolean areGridCoordinatesAvailableForSpaceShip(Set<Coordinate> coordinates) {

        for (Coordinate coordinate : coordinates) {
            if (taken.contains(coordinate)) {
                LOGGER.info("Conflicts: {} at position {}", coordinate, taken.indexOf(coordinate));
                return false;
            }
        }

        return true;
    }

    /**
     * The grid knows where to place the spaceship.
     * @param spaceShip
     */
    public void placeSpaceShip(SpaceShip spaceShip) {

        boolean found = false;
        LOGGER.info("PLACING SHIP ON GRID (FREE {}, TAKEN {})", free.size(), taken.size());

        for (Coordinate coord : free) {
            Set<Coordinate> coordinateSet = spaceShip.build(coord);
            if (coordinateSet.size() != 0) {
                LOGGER.debug("SPACESHIP HAS BEEN BUILT");
                if (areGridCoordinatesAvailableForSpaceShip(coordinateSet)) {
                    LOGGER.info("**** FOUND *******");
                    found = true;
                    spaceShip.setCoordinates(coordinateSet);
                    taken.addAll(spaceShip.getCoordinates());
                    break;
                }
            }
        }

        if(found){
            free.removeAll(spaceShip.getCoordinates());
        } else {
            LOGGER.info("NO FREE SPOT AVAILABLE");
        }

        this.update();
    }
    
}
