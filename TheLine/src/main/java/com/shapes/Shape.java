package com.shapes;

import com.Direction;

import java.util.function.Function;

/**
 * Immutable
 */
public class Shape {

    // function from direction to toString for shape
    private Function<Direction, String> stringFunction;

    // function from direction the shape is facing to directions the shape can reach
    private Function<Direction, Direction[]> directionFunction;

    public Shape(Function<Direction, String> stringFunction, Function<Direction, Direction[]> directionFunction) {
        this.stringFunction = stringFunction;
        this.directionFunction = directionFunction;
    }

    /**
     * Returns the directions the shape can reach in the orientation
     *
     * @param direction the direction the shape is facing
     */
    public Direction[] directionsReached(Direction direction) {
        return directionFunction.apply(direction);
    }

    public String toString(Direction direction) {
        return stringFunction.apply(direction);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shape)) {
            return false;
        }

        Shape shape = (Shape) obj;
        return stringFunction.equals(shape.stringFunction) && directionFunction.equals(shape.directionFunction);
    }
}
