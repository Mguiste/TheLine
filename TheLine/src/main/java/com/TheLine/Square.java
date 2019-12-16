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
        this(shape, ShapesUtility.getRandomOrientation());
    }

    public Square(Shape shape, int orientation) {
        this.shape = shape;
        this.orientation = orientation;
    }

    public void rotate() {
        orientation += 1;
        orientation %= ShapesUtility.TOTAL_ORIENTATIONS;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return shape.toString(orientation);
    }
}
