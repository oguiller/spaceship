package com.xebia.entity;

import com.xebia.Utils;
import com.xebia.entity.spaceship.*;
import org.junit.Test;

public class SpaceShipTest {

    @Test
    public void testAngleSpaceShip(){
        AngleSpaceShip angleSpaceShip = new AngleSpaceShip();
        Coordinate initialCoordinate = new Coordinate(5, 7);
        angleSpaceShip.build(initialCoordinate);
        System.out.println("***** Before");
        angleSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(angleSpaceShip, 16, 16);
        angleSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
        angleSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(angleSpaceShip, 16, 16);
    }

    @Test
    public void testASpaceShip(){
        ASpaceShip aSpaceShip = new ASpaceShip();
        Coordinate initialCoordinate = new Coordinate(5, 7);
        aSpaceShip.build(initialCoordinate);
        System.out.println("***** Before");
        aSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(aSpaceShip, 16, 16);
        aSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
        aSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(aSpaceShip, 16, 16);
    }

    @Test
    public void testBSpaceShip(){
        BSpaceShip bSpaceShip = new BSpaceShip();
        Coordinate initialCoordinate = new Coordinate(5, 7);
        bSpaceShip.build(initialCoordinate);
        System.out.println("***** Before");
        bSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(bSpaceShip, 16, 16);
        bSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
        bSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(bSpaceShip, 16, 16);
    }

    @Test
    public void testWingerSpaceShip(){
        WingerSpaceShip wingerSpaceShip = new WingerSpaceShip();
        Coordinate initialCoordinate = new Coordinate(5, 7);
        wingerSpaceShip.build(initialCoordinate);
        System.out.println("***** Before");
        wingerSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(wingerSpaceShip, 16, 16);
        wingerSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
        wingerSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(wingerSpaceShip, 16, 16);
    }

    @Test
    public void testSSpaceShip(){
        SSpaceShip sSpaceShip = new SSpaceShip();
        Coordinate initialCoordinate = new Coordinate(5, 7);
        sSpaceShip.build(initialCoordinate);
        System.out.println("***** Before");
        sSpaceShip.getCoordinates().stream().forEach(System.out::println);

        Utils.renderSpaceShipOnBoard(sSpaceShip, 16, 16);
        sSpaceShip.rotate(initialCoordinate);
        System.out.println("***** After ");
        sSpaceShip.getCoordinates().stream().forEach(System.out::println);
        Utils.renderSpaceShipOnBoard(sSpaceShip, 16, 16);
    }

}
