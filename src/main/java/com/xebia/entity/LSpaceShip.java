package com.xebia.entity;

import com.xebia.Utils;

import java.util.ArrayList;

public class LSpaceShip extends SpaceShip {

    public LSpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(3);
        this.setHeight(4);
        this.setInitialCoordinate();
    }

    private ArrayList<Coordinate> createCoordinates() {
        return null;
    }

    @Override
    public void setInitialCoordinate() {
        Coordinate initialCoordinate = new Coordinate();

        int row = Utils.getRandomInt(0, getGrid().getHeight() - this.getHeight());
        int column = Utils.getRandomInt(0, getGrid().getWidth() - this.getWidth());

        initialCoordinate.setRow(row);
        initialCoordinate.setColumn(column);

        this.initialCoordinate = initialCoordinate;
    }

    public ArrayList<Coordinate> placeSpaceShip() {
        ArrayList<Coordinate> coordinates = new ArrayList<>(7);

        Coordinate secondPoint = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn());
        Coordinate thirdPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn());
        Coordinate fourthPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn());
        Coordinate fifthPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 1);
        Coordinate sixthPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 2);

        coordinates.add(initialCoordinate);
        coordinates.add(secondPoint);
        coordinates.add(thirdPoint);
        coordinates.add(fourthPoint);
        coordinates.add(fifthPoint);
        coordinates.add(sixthPoint);

        return coordinates;
    }
}
