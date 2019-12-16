package main.java.com.TheLine.Shapes;

public class Line implements Shape {
    private static final String[] ORIENTATIONS = {" - ", " | ", " - ", " | "};

    @Override
    public int[] sides(int orientation) {
        return new int[] {orientation, (orientation + 2) % ShapesUtility.TOTAL_ORIENTATIONS};
    }

    @Override
    public String toString(int orientation) {
        return ORIENTATIONS[orientation];
    }
}
