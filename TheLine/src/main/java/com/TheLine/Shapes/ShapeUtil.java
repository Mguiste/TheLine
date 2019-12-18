package main.java.com.TheLine.Shapes;

import main.java.com.TheLine.BoardUtil;
import main.java.com.TheLine.Direction;
import main.java.com.TheLine.Square;

import java.util.function.Function;

public class ShapeUtil {
    // arrow
    private static final String[] ARROW_STRINGS = {" › ", " ˘ ", " ‹ ", " ^ "};
    private static final Function<Direction,  String> ARROW_STRING_FUNCTION = d -> ARROW_STRINGS[directionToInt(d)];
    private static final Function<Direction, Direction[]> ARROW_DIRECTION_FUNCTION =
            d -> new Direction[]{d};
    public static final Shape ARROW = new Shape(ARROW_STRING_FUNCTION, ARROW_DIRECTION_FUNCTION);

    // circle
    private static final Function<Direction,  String> CIRCLE_STRING_FUNCTION = d -> " * ";
    private static final Function<Direction, Direction[]> CIRCLE_DIRECTION_FUNCTION =
            d -> new Direction[0];
    public static final Shape CIRCLE = new Shape(CIRCLE_STRING_FUNCTION, CIRCLE_DIRECTION_FUNCTION);

    // corner
    private static final String[] CORNER_STRINGS = {" |¨", "¨| ", "_| ", " |_"};
    private static final Function<Direction,  String> CORNER_STRING_FUNCTION = d -> CORNER_STRINGS[directionToInt(d)];
    private static final Function<Direction, Direction[]> CORNER_DIRECTION_FUNCTION =
            // corner has the direction it is facing and the next direction clockwise  +1%(total directions)
            d -> new Direction[]{d, Direction.values()[(directionToInt(d) + 1) % Direction.values().length]};
    public static final Shape CORNER = new Shape(CORNER_STRING_FUNCTION, CORNER_DIRECTION_FUNCTION);

    // line
    private static final String[] LINE_STRINGS = {" - ", " | ", " - ", " | "};
    private static final Function<Direction,  String> LINE_STRING_FUNCTION = d -> LINE_STRINGS[directionToInt(d)];
    private static final Function<Direction, Direction[]> LINE_DIRECTION_FUNCTION =
            // line has the direction it is facing and the direction two spots clock wise from it +2%(total directions)
            d -> new Direction[]{d, Direction.values()[(directionToInt(d) + 2) % Direction.values().length]};
    public static final Shape LINE = new Shape(LINE_STRING_FUNCTION, LINE_DIRECTION_FUNCTION);

    // plus
    private static final Function<Direction,  String> PLUS_STRING_FUNCTION = d -> " + ";
    private static final Function<Direction, Direction[]> PLUS_DIRECTION_FUNCTION =
            // plus has all directions
            d -> Direction.values();
    public static final Shape PLUS = new Shape(PLUS_STRING_FUNCTION, PLUS_DIRECTION_FUNCTION);

    private static final Shape[] SHAPES = {ARROW, CIRCLE, CORNER, LINE, PLUS};

    /**
     * Returns a random shape
     */
    public static Shape getRandomShape() {
        int shape = (int) (Math.random() * SHAPES.length);
        return SHAPES[shape];
    }

    /**
     * Takes in a string and returns the proper Square object
     *
     * @param str the string square
     */
    public static Square parseSquare(String str) {
        if (str.equals(" › ")) {
            return new Square(ARROW, Direction.RIGHT);
        } else if (str.equals(" ˘ ")) {
            return new Square(ARROW, Direction.DOWN);
        } else if (str.equals(" ‹ ")) {
            return new Square(ARROW, Direction.LEFT);
        } else if (str.equals(" ^ ")) {
            return new Square(ARROW, Direction.UP);
        } else if (str.equals(" * ")) {
            return new Square(CIRCLE);
        } else if (str.equals(" |¨")) {
            return new Square(CORNER, Direction.RIGHT);
        } else if (str.equals("¨| ")) {
            return new Square(CORNER, Direction.DOWN);
        } else if (str.equals("_| ")) {
            return new Square(CORNER, Direction.LEFT);
        } else if (str.equals(" |_")) {
            return new Square(CORNER, Direction.UP);
        } else if (str.equals(" - ")) {
            return new Square(LINE, Direction.LEFT);
        } else if (str.equals(" | ")) {
            return new Square(LINE, Direction.DOWN);
        } else if (str.equals(" + ")) {
            return new Square(PLUS);
        } else {
            return null;
        }
    }

    public static int directionToInt(Direction d) {
        if (d == Direction.RIGHT) {
            return 0;
        } else if (d == Direction.DOWN) {
            return 1;
        } else if (d == Direction.LEFT) {
            return 2;
        } else if (d == Direction.UP) {
            return 3;
        } else {
            throw new IllegalArgumentException("Unrecognized direction " + d);
        }
    }
}
