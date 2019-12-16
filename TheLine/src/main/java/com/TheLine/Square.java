package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Shape;
import main.java.com.TheLine.Shapes.ShapesUtility;

/**
 * Mutable
 */
public class Square {

    private int orientation;
    private Shape shape;

    public Square(Shape shape) {
        this.shape = shape;
        orientation = (int) (Math.random() * ShapesUtility.TOTAL_ORIENTATIONS);
    }

    public void rotate() {
        orientation += 1;
        orientation %= ShapesUtility.TOTAL_ORIENTATIONS;
    }

    @Override
    public String toString() {
        return shape.toString(orientation);
    }
}
