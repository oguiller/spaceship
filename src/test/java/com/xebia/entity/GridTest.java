package com.xebia.entity;

import com.xebia.entity.spaceship.AngleSpaceShip;
import com.xebia.entity.spaceship.SpaceShip;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class GridTest {

    @Test
    public void testRender(){
        Grid grid = new Grid();
        System.out.print(grid.render());
    }

    @Test
    public void testAreGridCoordinatesAvailableForSpaceShip(){
        Grid grid = new Grid();
        SpaceShip angleSpaceShip = new AngleSpaceShip(grid);
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = angleSpaceShip.build(initialCoordinate);
        angleSpaceShip.setCoordinates(coordinateSet);
        grid.placeSpaceShip(angleSpaceShip);

        Assert.assertTrue(grid.getFree().size() == (grid.getSize() - angleSpaceShip.getCoordinates().size()));
        Assert.assertTrue(grid.getTaken().size() ==  angleSpaceShip.getCoordinates().size());
    }

}
