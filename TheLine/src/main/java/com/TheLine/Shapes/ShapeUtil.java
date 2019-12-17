package main.java.com.TheLine.Shapes;

import main.java.com.TheLine.BoardUtil;
import main.java.com.TheLine.Square;

public class ShapeUtil {
    private static final Shape[] SHAPES = {new Arrow(), new Circle(), new Corner(), new Line(), new Plus()};

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
            return new Square(new Arrow(), BoardUtil.RIGHT);
        } else if (str.equals(" ˘ ")) {
            return new Square(new Arrow(), BoardUtil.DOWN);
        } else if (str.equals(" ‹ ")) {
            return new Square(new Arrow(), BoardUtil.LEFT);
        } else if (str.equals(" ^ ")) {
            return new Square(new Arrow(), BoardUtil.UP);
        } else if (str.equals(" * ")) {
            return new Square(new Circle());
        } else if (str.equals(" |¨")) {
            return new Square(new Corner(), BoardUtil.RIGHT);
        } else if (str.equals("¨| ")) {
            return new Square(new Corner(), BoardUtil.DOWN);
        } else if (str.equals("_| ")) {
            return new Square(new Corner(), BoardUtil.LEFT);
        } else if (str.equals(" |_")) {
            return new Square(new Corner(), BoardUtil.UP);
        } else if (str.equals(" - ")) {
            return new Square(new Line(), BoardUtil.LEFT);
        } else if (str.equals(" | ")) {
            return new Square(new Line(), BoardUtil.DOWN);
        } else if (str.equals(" + ")) {
            return new Square(new Plus());
        } else {
            return null;
        }
    }
}
