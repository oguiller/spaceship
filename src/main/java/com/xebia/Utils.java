package com.xebia;

import com.xebia.entity.Coordinate;
import com.xebia.entity.spaceship.SpaceShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class Utils {

    public static int getRandomInt(int low, int high) {
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result;
    }

    public static Coordinate rotate(Coordinate centralCoordinate, Coordinate coordinate, int angle) {
        double radians = (Math.PI / 180) * angle;
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        Double row = (cos * (coordinate.getRow() - centralCoordinate.getRow())) + (sin * (coordinate.getColumn() - centralCoordinate.getColumn())) + centralCoordinate.getRow();
        Double column = (cos * (coordinate.getColumn() - centralCoordinate.getColumn())) - (sin * (coordinate.getRow() - centralCoordinate.getRow())) + centralCoordinate.getColumn();
        Coordinate rotatedCoord = new Coordinate(row.intValue(), column.intValue());
        return rotatedCoord;
    }

    public static void renderSpaceShipOnBoard(SpaceShip spaceShip, int boardWidth, int boardHeight) {
        StringBuilder board = new StringBuilder();
        Set<Coordinate> spaceShipCoordinates = spaceShip.getCoordinates();

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                Coordinate coord = new Coordinate(i, j);
                if (spaceShipCoordinates.contains(coord)) {
                    board.append("*");
                } else {
                    board.append(".");
                }
                if (j == (boardWidth - 1)) {
                    board.append("\n");
                    continue;
                }
            }
        }

        System.out.println(board.toString());
    }

    public static List<Coordinate> toCoordinates(List<String> salvo){
        List<Coordinate> coordinates = new ArrayList<>();
        String pattern = "[a-f[0-9]]x[a-f[0-9]]";
        Pattern p = Pattern.compile(pattern);

        for(String position: salvo){
            if(Pattern.matches(pattern, position)){
                String[] point = position.split("x");
                coordinates.add(new Coordinate(Integer.parseInt(point[0], 16), (Integer.parseInt(point[1], 16))));
            }
        }

        return coordinates;
    }

}
