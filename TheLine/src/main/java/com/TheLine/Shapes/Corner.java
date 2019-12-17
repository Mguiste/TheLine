package main.java.com.TheLine.Shapes;

import main.java.com.TheLine.BoardUtil;

public class Corner implements Shape {
    private static final String[] ORIENTATIONS = {" |¨", "¨| ", "_| ", " |_"};

    @Override
    public int[] sidesReached(int orientation) {
        return new int[] {orientation, (orientation + 1) % BoardUtil.TOTAL_DIRECTIONS};
    }

    @Override
    public String toString(int orientation) {
        return ORIENTATIONS[orientation];
    }
}
