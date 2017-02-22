package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.HashSet;
import java.util.Set;

/**
 *       **
 *      *
 *       **
 *         *
 *       **
 */
public class SSpaceShip extends SpaceShip {

    public SSpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(4);
        this.setHeight(5);
    }

//    private Set<Coordinate> createCoordinates() {
//        return null;
//    }

    @Override
    public Set<Coordinate> build(Coordinate initialCoordinate) {

        Set<Coordinate> coordinates = new HashSet<>();

        if(!validateInitialCoordinate(initialCoordinate)){
            return coordinates;
        }

        // Row 1
        Coordinate point2 = new Coordinate(initialCoordinate.getRow(), initialCoordinate.getColumn() + 1);
        // Row 2
        Coordinate point3 = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn() - 1);
        // Row 3
        Coordinate point4 = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn());
        Coordinate point5 = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() + 1);
        //Row 4
        Coordinate point6 = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 2);
        // Row 5
        Coordinate point7 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn());
        Coordinate point8 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn() + 1);

        coordinates.add(initialCoordinate);
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.add(point4);
        coordinates.add(point5);
        coordinates.add(point6);
        coordinates.add(point7);
        coordinates.add(point8);

        return coordinates;
    }
}
