package main.java.com.TheLine.Shapes;

public class Corner implements Shape {
    private static final String[] ORIENTATIONS = {" |¨", "¨| ", "_| ", " |_"};

    @Override
    public int[] sides(int orientation) {
        return new int[] {orientation, (orientation + 1) % ShapesUtility.TOTAL_ORIENTATIONS};
    }

    @Override
    public String toString(int orientation) {
        return ORIENTATIONS[orientation];
    }
}
