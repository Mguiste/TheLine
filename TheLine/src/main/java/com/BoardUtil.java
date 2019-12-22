package com;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardUtil {
    /**
     * Returns a new point translated in the direction specified.
     *
     * @param p the initial point
     * @param direction the direction to be translated
     * @return the new translated point
     */
    public static Point translatePoint(Point p, Direction direction) {
        if (direction == Direction.RIGHT) {
            return new Point(p.x + 1, p.y);
        } else if (direction == Direction.DOWN) {
            return new Point(p.x, p.y + 1);
        } else if (direction == Direction.LEFT) {
            return new Point(p.x - 1, p.y);
        } else if (direction == Direction.UP) {
            return new Point(p.x, p.y - 1);
        } else {
            throw new IllegalArgumentException("Invalid direction " + direction);
        }
    }

    public static Set<Point> getAdjacentPoints(Point p) {
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < Direction.values().length; i++) {
            points.add(translatePoint(p, Direction.values()[i]));
        }
        return points;
    }

    public static Set<Point> getDirectionPoints(Point p, Direction[] directions) { // TODO: why map to obj before
        return Arrays.stream(directions).map(d -> translatePoint(p, d)).collect(Collectors.toSet());
    }
}
