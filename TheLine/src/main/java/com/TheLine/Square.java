package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Shape;
import main.java.com.TheLine.Shapes.ShapeUtil;

import java.awt.*;
import java.util.List;

/**
 * Mutable
 */
public class Square {

    private int orientation;
    private Shape shape;

    public Square(Shape shape) {
        orientation = BoardUtil.getRandomDirection();
        this.shape = shape;
    }

    public void rotate() {
        orientation += 1;
        orientation %= BoardUtil.TOTAL_DIRECTIONS;
    }

//    public List<Point> pointsReached(Point currentPoint) {
//        int[] sides = shape.sides(orientation);
//        for (int side : sides) {
//
//        }
//    }

    @Override
    public String toString() {
        return shape.toString(orientation);
    }
}
