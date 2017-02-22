package com.xebia.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for displaying the board game
 */
public class Grid {

    private int width = 16;

    private int height = 16;

    private String[][] board;

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
        for (int i=0; i < this.width; i++) {
            for (int j=0; j < this.height; j++) {
                this.board[i][j] = ".";
            }
        }
    }

    public String render(){
        StringBuilder board = new StringBuilder();

        for (int i=0; i < this.width; i++) {
            for (int j=0; j < this.height; j++) {
                board.append(this.board[i][j]);
                if(j == (this.width -1)){
                   board.append("\n");
                   continue;
               }
            }
        }

        return board.toString();
    }
}
