package test.java.com.TheLine;

import main.java.com.TheLine.Direction;
import main.java.com.TheLine.Shapes.ShapeUtil;
import main.java.com.TheLine.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeUtilTest {
    @Test
    public void getRandomShapeTest() {
        Assertions.assertTrue(Arrays.asList(ShapeUtil.SHAPES).contains(ShapeUtil.getRandomShape()));
    }

    @Test
    public void parseSquareStart() {
        Assertions.assertEquals(new Square(ShapeUtil.CIRCLE, Direction.RIGHT), ShapeUtil.parseSquare(" * "));
    }
}
