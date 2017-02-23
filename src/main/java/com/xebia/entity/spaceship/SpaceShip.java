package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

//   static factory methods
public abstract class SpaceShip {

    private final Logger Logger = LoggerFactory.getLogger(SpaceShip.class);

    private String type;

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

    public boolean isInitialCoordinateValid(Coordinate initialCoordinate) {
        if ((initialCoordinate.getRow() + this.height > this.grid.getHeight()) || (initialCoordinate.getColumn() + this.width > this.grid.getWidth())) {
            Logger.debug("COORD NON VALID: {}", initialCoordinate);
            return false;
        }

        if ((initialCoordinate.getRow() - this.height < 0) || (initialCoordinate.getColumn() - this.width < 0)) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void rotate(Coordinate initialCoordinate);

}
