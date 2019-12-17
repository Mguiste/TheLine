package main.java.com.TheLine.Shapes;

import main.java.com.TheLine.BoardUtil;

public class Line implements Shape {
    private static final String[] ORIENTATIONS = {" - ", " | ", " - ", " | "};

    @Override
    public int[] sidesReached(int orientation) {
        return new int[] {orientation, (orientation + 2) % BoardUtil.TOTAL_DIRECTIONS};
    }

    @Override
    public String toString(int orientation) {
        return ORIENTATIONS[orientation];
    }
}
