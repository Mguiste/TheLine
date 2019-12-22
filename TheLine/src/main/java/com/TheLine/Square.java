package com.TheLine;

import com.TheLine.Shapes.Shape;
import com.TheLine.Shapes.ShapeUtil;

/**
 * Mutable
 */
public class Square extends Object {

    private Shape shape;
    private Direction direction;

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

    /**
     * Picks a random direction for the square
     */
    public void shuffle() {
        direction = ShapeUtil.getRandomDirection();
    }

    @Override
    public String toString() {
        return shape.toString(direction);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Square)) {
            return false;
        }

        Square square = (Square) obj;
        return shape.equals(square.shape) && direction == square.direction;
    }
}
