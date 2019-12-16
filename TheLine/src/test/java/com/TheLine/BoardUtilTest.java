package test.java.com.TheLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.com.TheLine.BoardUtil;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public final class BoardUtilTest {
    @Test
    public void translatePointTest() {
        Point p = new Point(0, 0);
        Point newP = BoardUtil.translatePoint(p, 0);
        assertEquals(new Point(1, 0), newP);
    }

    @Test
    public void getPointsInAllDirectionsTest() {
        Point p = new Point(0, 0);
        Set<Point> result = BoardUtil.getAllDirections(p);
        Set<Point> expected = new HashSet<>();
        expected.add(new Point(1, 0));
        expected.add(new Point(0, 1));
        expected.add(new Point(-1, 0));
        expected.add(new Point(0, -1));
        assertEquals(expected, result);
    }
}
