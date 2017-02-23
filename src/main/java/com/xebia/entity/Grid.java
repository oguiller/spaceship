package com.xebia.entity;

import com.xebia.Utils;
import com.xebia.entity.spaceship.SpaceShip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
     * @param coordinates
     * @return
     */

    private boolean areGridCoordinatesAvailableForSpaceShip(Set<Coordinate> coordinates) {

        for (Coordinate coordinate : coordinates) {
            if (taken.contains(coordinate)) {
                log.info("Conflicts: {} at position {}", coordinate, taken.indexOf(coordinate));
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
        log.debug("PLACING SHIP ON GRID (FREE {}, TAKEN {})", free.size(), taken.size());
        Random random = new Random();
        boolean rotate;

        while(!found) {
            Coordinate initialCoordinate = free.get(Utils.getRandomInt(0, free.size()));
            Set<Coordinate> coordinateSet = spaceShip.build(initialCoordinate);
            if (coordinateSet.size() != 0) {
                rotate = random.nextBoolean();

                if(rotate){
                    spaceShip.rotate(initialCoordinate);
                }

                if (areGridCoordinatesAvailableForSpaceShip(coordinateSet)) {
                    found = true;
                    spaceShip.setCoordinates(coordinateSet);
                    taken.addAll(spaceShip.getCoordinates());
                    break;
                }
            }
        }

        if(found){
            free.removeAll(spaceShip.getCoordinates());
        }

        this.update();
    }
}
