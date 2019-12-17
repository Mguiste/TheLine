package main.java.com.TheLine.Shapes;

import java.util.Map;
import com.google.common.collect.ImmutableMap;
import main.java.com.TheLine.BoardUtil;
import main.java.com.TheLine.Square;

public class ShapeUtil {
    private static final Shape[] SHAPES = {new Arrow(), new Circle(), new Corner(), new Line(), new Plus()};

    public static Shape getRandomShape() {
        int shape = (int) (Math.random() * SHAPES.length);
        return SHAPES[shape];
    }

    private static final Map<String, Square> STRING_TO_SHAPE = ImmutableMap.<String, Square>builder()
            .put(" › ", new Square(new Arrow(), BoardUtil.RIGHT))
            .put(" ˘ ", new Square(new Arrow(), BoardUtil.DOWN))
            .put(" ‹ ", new Square(new Arrow(), BoardUtil.LEFT))
            .put(" ^ ", new Square(new Arrow(), BoardUtil.UP))

            .put(" * ", new Square(new Circle()))

            .put(" |¨", new Square(new Corner(), BoardUtil.RIGHT))
            .put("¨| ", new Square(new Corner(), BoardUtil.DOWN))
            .put("_| ", new Square(new Corner(), BoardUtil.LEFT))
            .put(" |_", new Square(new Corner(), BoardUtil.UP))

            .put(" - ", new Square(new Line(), BoardUtil.RIGHT))
            .put( " | ", new Square(new Line(), BoardUtil.DOWN))

            .put(" + ", new Square(new Plus()))
            .build();

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
