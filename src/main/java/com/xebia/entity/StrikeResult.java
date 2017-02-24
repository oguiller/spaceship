package com.xebia.entity;

public class StrikeResult {

    private Coordinate coordinate;

    private StrikeType type;

    public StrikeResult(Coordinate coordinate, StrikeType type) {
        this.coordinate= coordinate;
        this.type = type;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public StrikeType getType() {
        return type;
    }

    public void setType(StrikeType type) {
        this.type = type;
    }
}
