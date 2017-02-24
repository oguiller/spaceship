package com.xebia.entity.spaceship;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;

import java.util.HashSet;
import java.util.Set;

/**
 *          *
 *          *
 *          *
 *          * *
 */
public class AngleSpaceShip extends SpaceShip {

    public static final String ANGLE_SPACE_SHIP = "Angle SpaceShip";

    public AngleSpaceShip() {
        super();
        this.setWidth(3);
        this.setHeight(4);
        this.setType(ANGLE_SPACE_SHIP);
    }

    public void build(Coordinate initialCoordinate) {

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

        this.coordinates = coordinates;
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
