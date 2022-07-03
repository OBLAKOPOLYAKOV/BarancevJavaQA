package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void PositiveZeroDistanceTest(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 0);
    }

    @Test
    public void PositiveDistanceTest(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(5,0);
        Assert.assertEquals(p1.distance(p2), 5);
    }

    @Test
    public void PositiveNegativeXValuesDistanceTest(){
        Point p1 = new Point(-5,0);
        Point p2 = new Point(-1,0);
        Assert.assertEquals(p1.distance(p2), 4);
    }

    @Test
    public void PositiveNegativeYValuesDistanceTest(){
        Point p1 = new Point(0,-6);
        Point p2 = new Point(0,-9);
        Assert.assertEquals(p1.distance(p2), 3);
    }

}
