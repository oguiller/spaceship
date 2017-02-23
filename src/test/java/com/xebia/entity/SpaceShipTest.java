package com.xebia.entity;

import com.xebia.Utils;
import com.xebia.entity.spaceship.*;
import org.junit.Test;

import java.util.Set;

public class SpaceShipTest {

    @Test
    public void testAngleSpaceShip(){
        AngleSpaceShip angleSpaceShip = new AngleSpaceShip(new Grid());
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = angleSpaceShip.build(initialCoordinate);
        angleSpaceShip.setCoordinates(coordinateSet);
        System.out.println("***** Before");
//        angleSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(angleSpaceShip, 16, 16);
        angleSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
//        angleSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(angleSpaceShip, 16, 16);
    }

    @Test
    public void testASpaceShip(){
        ASpaceShip aSpaceShip = new ASpaceShip(new Grid());
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = aSpaceShip.build(initialCoordinate);
        aSpaceShip.setCoordinates(coordinateSet);
        System.out.println("***** Before");
//        aSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(aSpaceShip, 16, 16);
        aSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
//        aSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(aSpaceShip, 16, 16);
    }

    @Test
    public void testBSpaceShip(){
        BSpaceShip bSpaceShip = new BSpaceShip(new Grid());
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = bSpaceShip.build(initialCoordinate);
        bSpaceShip.setCoordinates(coordinateSet);
        System.out.println("***** Before");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(bSpaceShip, 16, 16);
        bSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(bSpaceShip, 16, 16);
    }

    @Test
    public void testWingerSpaceShip(){
        WingerSpaceShip wingerSpaceShip = new WingerSpaceShip(new Grid());
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = wingerSpaceShip.build(initialCoordinate);
        wingerSpaceShip.setCoordinates(coordinateSet);
        System.out.println("***** Before");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(wingerSpaceShip, 16, 16);
        wingerSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(wingerSpaceShip, 16, 16);
    }

    @Test
    public void testSSpaceShip(){
        SSpaceShip sSpaceShip = new SSpaceShip(new Grid());
        Coordinate initialCoordinate = new Coordinate(5, 7);
        Set<Coordinate> coordinateSet = sSpaceShip.build(initialCoordinate);
        sSpaceShip.setCoordinates(coordinateSet);
        System.out.println("***** Before");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(sSpaceShip, 16, 16);
        sSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
//        bSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(sSpaceShip, 16, 16);
    }

}
