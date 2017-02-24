package com.xebia.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CoordinateTest {

    @Test
    public void testEquality(){
        Coordinate coordinate1 = new Coordinate(1,1);
        Coordinate coordinate2 = new Coordinate(1,1);
        Assert.assertTrue(coordinate1.equals(coordinate2));
    }

    @Test
    public void testHashCode(){
        Set<Coordinate> coordinateSet = new HashSet<>();
        Coordinate coordinate1 = new Coordinate(1,1);
        Coordinate coordinate2 = new Coordinate(1,1);
        coordinateSet.add(coordinate1);
        Assert.assertTrue(coordinateSet.contains(coordinate2));
    }

    @Test
    public void testToHexDec(){
        Set<Coordinate> coordinateSet = new HashSet<>();
        Coordinate coordinate1 = new Coordinate(10,1);
        Coordinate coordinate2 = new Coordinate(15,9);
        System.out.println(coordinate1.toHexDec());
        System.out.println(coordinate2.toHexDec());
    }
}
