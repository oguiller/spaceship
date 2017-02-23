package com.xebia.entity.spaceship;

import com.xebia.Utils;
import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;

import java.util.HashSet;
import java.util.Set;

/**
 *     * *
 *     * *
 *      *
 *     * *
 *     * *
 */
public class WingerSpaceShip extends SpaceShip {

    public WingerSpaceShip(Grid grid) {
        super();
        this.setGrid(grid);
        this.setWidth(2);
        this.setHeight(5);
        this.setType("Winger SpaceShip");
    }


    @Override
    public Set<Coordinate> build(Coordinate initialCoordinate) {

        Set<Coordinate> coordinates = new HashSet<>();

        if(!isInitialCoordinateValid(initialCoordinate)){
            return coordinates;
        }

        // Row 1
        Coordinate point2 = new Coordinate(initialCoordinate.getRow(), initialCoordinate.getColumn() + 2);
        // Row 2
        Coordinate point3 = new Coordinate(initialCoordinate.getRow() + 1 , initialCoordinate.getColumn());
        Coordinate point4 = new Coordinate(initialCoordinate.getRow() + 1, initialCoordinate.getColumn() + 2);
        // Row 3
        Coordinate point5 = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() + 1);
        //Row 4
        Coordinate point6 = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn());
        Coordinate point7 = new Coordinate(initialCoordinate.getRow() + 3, initialCoordinate.getColumn() + 2);
        // Row 5
        Coordinate point8 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn());
        Coordinate point9 = new Coordinate(initialCoordinate.getRow() + 4, initialCoordinate.getColumn() + 2);

        coordinates.add(initialCoordinate);
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.add(point4);
        coordinates.add(point5);
        coordinates.add(point6);
        coordinates.add(point7);
        coordinates.add(point8);
        coordinates.add(point9);

        return coordinates;
    }

    public void rotate(Coordinate initialCoordinate){

        Coordinate centralPoint = new Coordinate(initialCoordinate.getRow() + 2, initialCoordinate.getColumn() +1);
        Set<Coordinate> newCoordinateSet = new HashSet<>();

        for (Coordinate coordinate : coordinates) {
            Coordinate rotatedCoordinate = Utils.rotate(centralPoint, coordinate, 90);
            newCoordinateSet.add(rotatedCoordinate);
        }

        coordinates = newCoordinateSet;
    }

}
