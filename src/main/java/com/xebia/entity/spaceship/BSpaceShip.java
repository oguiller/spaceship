package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.ArrayList;
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

    public BSpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(3);
        this.setHeight(5);
    }

    private ArrayList<Coordinate> createCoordinates() {
        return null;
    }

    @Override
    public Set<Coordinate> build(Coordinate initialCoordinate) {
        Set<Coordinate> coordinates = new HashSet<>();

        if(!validateInitialCoordinate(initialCoordinate)){
            return coordinates;
        }
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

        return coordinates;
    }

    public ArrayList<Coordinate> placeSpaceShip() {
        ArrayList<Coordinate> coordinates = new ArrayList<>(7);

        Coordinate secondPoint = new Coordinate(initialCoordinate.getRow(), initialCoordinate.getColumn() +1);
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
