package com.xebia;

import com.xebia.entity.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

    @Test
    public void testToCoordinates(){
        List<String> salvo = new ArrayList<>();
        salvo.add("0x0");
        salvo.add("0x1");
        salvo.add("0xa");
        salvo.add("0;a");
        salvo.add("0xl");
        salvo.add("");

        List<Coordinate> coordinates = Utils.toCoordinates(salvo);
        Assert.assertTrue(coordinates.size() == 3);
    }
}
