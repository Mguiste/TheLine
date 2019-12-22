package com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoardTest {
    public static final Board UNSOLVED_BOARD = new Board(
            " ›  |¨ +  +  *  ›  ›  › \n" +
            " |¨ |¨ +  *  +  |¨ -  + \n" +
            " -  +  -  +  *  -  |¨ * \n" +
            " |¨ -  |¨ +  +  |¨ +  › \n" +
            " *  -  -  +  *  |¨ ›  |¨\n" +
            " ›  |¨ |¨ -  -  *  |¨ |¨\n" +
            " +  -  |¨ -  |¨ ›  -  - \n" +
            " *  |¨ |¨ -  |¨ -  |¨ › ");

    public static final Board SOLVED_BOARD = new Board(
            " ˘ ¨|  +  +  *  ›  ›  › \n" +
            " |_¨|  +  *  +  |¨ -  + \n" +
            " -  +  -  +  *  -  |¨ * \n" +
            " |¨ |  |¨ +  +  |¨ +  › \n" +
            " *  |  -  +  *  |¨ › ¨| \n" +
            " ›  |_¨|  -  -  *  |¨¨| \n" +
            " +  -  |_ - ¨|  ›  |  | \n" +
            " *  |¨ |¨ -  |_ - _|  ^ ");

    public static final Board NEARLY_SOLVED_BOARD = new Board(
            " › ¨|  +  +  *  ›  ›  › \n" +
            " |_¨|  +  *  +  |¨ -  + \n" +
            " -  +  -  +  *  -  |¨ * \n" +
            " |¨ |  |¨ +  +  |¨ +  › \n" +
            " *  |  -  +  *  |¨ › ¨| \n" +
            " ›  |_¨|  -  -  *  |¨¨| \n" +
            " +  -  |_ - ¨|  ›  |  | \n" +
            " *  |¨ |¨ -  |_ - _|  ^ ");

    @Test
    public void unsolvedBoardTest() {
        assertFalse(UNSOLVED_BOARD.solved());
    }

    @Test
    public void solvedBoardTest() {
        assertTrue(SOLVED_BOARD.solved());
    }

    @Test
    public void rotateTest() {
        NEARLY_SOLVED_BOARD.rotate(0, 0);
        assertTrue(NEARLY_SOLVED_BOARD.solved());
    }
}
