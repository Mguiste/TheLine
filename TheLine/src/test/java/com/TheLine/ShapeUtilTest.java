package com.TheLine;

import com.TheLine.Shapes.ShapeUtil;
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
