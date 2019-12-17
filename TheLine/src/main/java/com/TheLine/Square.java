package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Shape;

/**
 * Mutable
 */
public class Square {

    private Shape shape;
    private int orientation;

    public Square(Shape shape) {
        this(shape, 0);
    }

    public Square(Shape shape, int orientation) {
        this.shape = shape;
        this.orientation = orientation;
    }

    public void rotate() {
        orientation += 1;
        orientation %= BoardUtil.TOTAL_DIRECTIONS;
    }

    public int[] sidesReached() {
       return shape.sidesReached(orientation);
    }

    @Override
    public String toString() {
        return shape.toString(orientation);
    }
}
