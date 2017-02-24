package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
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

    public abstract void build(Coordinate initialCoordinate);

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

    @Override
    public String toString() {
        return "SpaceShip{" +
                "type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", initialCoordinate=" + initialCoordinate +
                ", coordinates=" + coordinates +
                '}';
    }
}
