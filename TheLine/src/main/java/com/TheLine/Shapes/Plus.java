package main.java.com.TheLine.Shapes;

public class Plus implements Shape {
    @Override
    public int[] sides(int orientation) {
        return new int[] {0, 1, 2, 3};
    }

    @Override
    public String toString(int orientation) {
        return " + ";
    }
}
