package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Shape;
import main.java.com.TheLine.Shapes.ShapeUtil;

/**
 * Mutable
 */
public class Square {

    private Shape shape;
    private Direction direction;

    /**
     * Create a square with the given shape and a random direction
     *
     * @param shape the shape of the square
     */
    public Square(Shape shape) {
        this(shape, Direction.values()[(int) (Math.random() * Direction.values().length)]);
    }

    /**
     * Create a square with the given shape and direction
     *
     * @param shape the shape of the square
     * @param direction the direction the shape is facing
     */
    public Square(Shape shape, Direction direction) {
        this.shape = shape;
        this.direction = direction;
    }

    public void rotate() {
        direction = Direction.values()[((ShapeUtil.directionToInt(direction) + 1) % Direction.values().length)];
    }

    public Direction[] directionsReached() {
       return shape.directionsReached(direction);
    }

    @Override
    public String toString() {
        return shape.toString(direction);
    }
}
