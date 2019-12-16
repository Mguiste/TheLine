package main.java.com.TheLine.Shapes;

public class ShapesUtility {
    public static final int TOTAL_ORIENTATIONS = 4;
    public static final int RIGHT_ORIENTATION = 0;
    public static final int DOWN_ORIENTATION = 1;
    public static final int LEFT_ORIENTATION = 2;
    public static final int UP_ORIENTATION = 3;

    private static final Shape[] SHAPES = {new Arrow(), new Circle(), new Corner(), new Line(), new Plus()};

    public static Shape getRandomShape() {
        int shape = (int) (Math.random() * SHAPES.length);
        return SHAPES[shape];
    }
}
