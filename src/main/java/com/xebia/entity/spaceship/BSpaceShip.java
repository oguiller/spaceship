package com.xebia.entity.spaceship;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *    **
 *    * *
 *    **
 *    * *
 *    **
 *
 */

public class BSpaceShip extends SpaceShip {

    public static final String B_SPACE_SHIP = "B SpaceShip";

    public BSpaceShip() {
        super();
        this.setWidth(3);
        this.setHeight(5);
        this.setType(B_SPACE_SHIP);
    }

    @Override
    public void build(Coordinate initialCoordinate) {
        Set<Coordinate> coordinates = new HashSet<>();

        //First row
        Coordinate point2 = new Coordinate(initialCoordinate.getRow(), initialCoordinate.getColumn() +1);

        // Second row
        Coordinate point3 = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn());
        Coordinate point4 = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn() + 2);

        // Third row
        Coordinate point5 = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn());
        Coordinate point6 = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() + 1);

        // Fourth row
        Coordinate point7 = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn());
        Coordinate point8 = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 2);

        // Fourth row
        Coordinate point9 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn());
        Coordinate point10 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn() + 1);

        coordinates.add(initialCoordinate);
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.add(point4);
        coordinates.add(point5);
        coordinates.add(point6);
        coordinates.add(point7);
        coordinates.add(point8);
        coordinates.add(point9);
        coordinates.add(point10);

        this.coordinates = coordinates;
    }

    public void rotate(Coordinate initialCoordinate){

        Coordinate centralPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn());
        Set<Coordinate> newCoordinateSet = new HashSet<>();

        for (Coordinate coordinate : coordinates) {
            Coordinate rotatedCoordinate = Utils.rotate(centralPoint, coordinate, 90);
            newCoordinateSet.add(rotatedCoordinate);
        }

        coordinates = newCoordinateSet;
    }
}
