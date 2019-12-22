package com.Shapes;

import com.Shapes.ShapeUtil;
import com.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
