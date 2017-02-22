package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.ArrayList;
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
    }

    public Set<Coordinate> build(Coordinate initialCoordinate) {

        if(!validateInitialCoordinate(initialCoordinate)){
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
}
