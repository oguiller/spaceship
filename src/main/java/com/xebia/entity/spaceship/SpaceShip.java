package com.xebia.entity.spaceship;

import com.xebia.entity.Coordinate;
import com.xebia.entity.StrikeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

//   static factory methods
public abstract class SpaceShip {

    private final Logger Logger = LoggerFactory.getLogger(SpaceShip.class);

    private String type;

    protected int width;

    protected int height;

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


    //TODO Refactor
    public Map<Coordinate, StrikeType> gettingFired(List<Coordinate> salvoCoordinates){
        Set<Coordinate> coordinates = this.getCoordinates();
        Map<Coordinate, StrikeType> results = new HashMap<>();

        for(Coordinate salvoCoordinate: salvoCoordinates){
            if(coordinates.contains(salvoCoordinate)){
                if(this.getLives() == 1){
                    // kill
                    results.put(salvoCoordinate, StrikeType.KILL);
                } else {
                    // hit
                    results.put(salvoCoordinate, StrikeType.HIT);
                }
                this.coordinates.remove(salvoCoordinate);
            }
        }

        return results;
    }

    private int getLives() {
        return this.coordinates.size();
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", coordinates=" + coordinates +
                '}';
    }
}
