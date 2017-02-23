package com.xebia.entity.spaceship;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.HashSet;
import java.util.Set;

/**
 *    *
 *   * *
 *   ***
 *   * *
 */
public class ASpaceShip extends SpaceShip {

    public ASpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(3);
        this.setHeight(4);
        this.setType("A SpaceShip");
    }

    @Override
    public Set<Coordinate> build(Coordinate initialCoordinate) {

        Set<Coordinate> coordinates = new HashSet<>();

        if(!isInitialCoordinateValid(initialCoordinate)){
            return coordinates;
        }

        Coordinate secondPoint = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn() - 1);
        Coordinate thirdPoint = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn() + 1);

        Coordinate fourthPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() - 1);
        Coordinate fifthPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn());
        Coordinate sixthPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() + 1);

        Coordinate eightPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() - 1);
        Coordinate sevenPoint = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 1);

        coordinates.add(initialCoordinate);
        coordinates.add(secondPoint);
        coordinates.add(thirdPoint);
        coordinates.add(fourthPoint);
        coordinates.add(fifthPoint);
        coordinates.add(sixthPoint);
        coordinates.add(sevenPoint);
        coordinates.add(eightPoint);

        return coordinates;
    }

    @Override
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
