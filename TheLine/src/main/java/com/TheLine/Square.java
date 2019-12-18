package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Shape;

/**
 * Mutable
 */
public class Square {

    private Shape shape;
    private int orientation;

    /**
     * Create a square with the given shape and orientation of 0
     *
     * @param shape the shape of the square
     */
    public Square(Shape shape) {
        this(shape, 0);
    }

    /**
     * Create a square with the given shape and orientation
     *
     * @param shape the shape of the square
     * @param orientation the orientation of the square should be consistent with BoardUtil directions
     */
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
