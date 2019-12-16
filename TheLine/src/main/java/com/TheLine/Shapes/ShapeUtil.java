package main.java.com.TheLine.Shapes;

public class ShapeUtil {
    private static final Shape[] SHAPES = {new Arrow(), new Circle(), new Corner(), new Line(), new Plus()};

    public static Shape getRandomShape() {
        int shape = (int) (Math.random() * SHAPES.length);
        return SHAPES[shape];
    }
}
