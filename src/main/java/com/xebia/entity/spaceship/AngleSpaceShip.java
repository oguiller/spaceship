package com.xebia.entity.spaceship;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.HashSet;
import java.util.Set;

/**
 *          *
 *          *
 *          *
 *          * *
 */
public class AngleSpaceShip extends SpaceShip {

    public AngleSpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(3);
        this.setHeight(4);
        this.setType("Angle SpaceShip");
    }

    public Set<Coordinate> build(Coordinate initialCoordinate) {

        if(!isInitialCoordinateValid(initialCoordinate)){
            return new HashSet<>();
        }

        Set<Coordinate> coordinates = new HashSet<>();

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

    public void rotate(Coordinate initialCoordinate){

        Coordinate centralPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn());
        Set<Coordinate> newCoordinateSet = new HashSet<>();

        for (Coordinate coordinate : coordinates) {
            Coordinate rotatedCoordinate = Utils.rotate(centralPoint, coordinate, 90);
            newCoordinateSet.add(rotatedCoordinate);
        }

        coordinates = newCoordinateSet;
    }
}
