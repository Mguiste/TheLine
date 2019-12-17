package main.java.com.TheLine.Shapes;

public class Arrow implements Shape {
    private static final String[] ORIENTATIONS = {" › ", " ˘ ", " ‹ ", " ^ "};

    @Override
    public int[] sidesReached(int orientation) {
        return new int[] {orientation};
    }

    @Override
    public String toString(int orientation) {
        return ORIENTATIONS[orientation];
    }
}
