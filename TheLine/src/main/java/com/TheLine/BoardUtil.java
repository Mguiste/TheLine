package main.java.com.TheLine;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class BoardUtil {
    public static final int TOTAL_DIRECTIONS = 4;
    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;

    /**
     * Returns a new point translated in the direction specified.
     *
     * @param p the initial point
     * @param direction the direction to be translated
     * @return the new translated point
     */
    public static Point translatePoint(Point p, int direction) {
        if (direction == RIGHT) {
            return new Point(p.x + 1, p.y);
        } else if (direction == DOWN) {
            return new Point(p.x, p.y + 1);
        } else if (direction == LEFT) {
            return new Point(p.x - 1, p.y);
        } else if (direction == UP) {
            return new Point(p.x, p.y - 1);
        } else {
            throw new IllegalArgumentException("Invalid direction " + direction);
        }
    }

    public static Set<Point> getAllDirections(Point p) {
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < TOTAL_DIRECTIONS; i++) {
            points.add(translatePoint(p, i));
        }
        return points;
    }

    public static int getRandomDirection() {
        return (int) (Math.random() * TOTAL_DIRECTIONS);
    }
}
