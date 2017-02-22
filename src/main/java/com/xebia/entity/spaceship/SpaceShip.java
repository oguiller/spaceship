package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public abstract class SpaceShip {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpaceShip.class);

    protected int width;

    protected int height;

    protected Coordinate initialCoordinate;

    protected Grid grid;

    protected Set<Coordinate> coordinates = new HashSet<>();

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

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public abstract Set<Coordinate> build(Coordinate initialCoordinate);

    public boolean validateInitialCoordinate(Coordinate coordinate) {
        if ((coordinate.getRow() + this.height > this.grid.getHeight()) || (coordinate.getColumn() + this.width > this.grid.getWidth())) {
            LOGGER.debug("COORD NON VALID: {}", coordinate);
            return false;
        }

        if ((coordinate.getRow() - this.height < 0) || (coordinate.getColumn() - this.width < 0)) {
            return false;
        }

        return true;
    }

    public int getLifes(){
        return this.coordinates.size();
    }

    public void hit(Coordinate coordinate){
        this.coordinates.remove(coordinate);
    }

    public int getSpaceShipSize(){
        return this.coordinates.size();
    }
}
