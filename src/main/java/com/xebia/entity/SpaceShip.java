package com.xebia.entity;

import java.util.ArrayList;

public abstract class SpaceShip {

    protected int width;

    protected int height;

    protected Coordinate initialCoordinate;

    protected Grid grid;

    protected ArrayList<Coordinate> coordinates = new ArrayList<>();

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

    public Coordinate getInitialCoordinate() {
        return initialCoordinate;
    }

    public abstract void setInitialCoordinate();

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public abstract ArrayList<Coordinate> placeSpaceShip();
}
