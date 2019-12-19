package main.java.com.TheLine;

import java.awt.*;
import java.util.Scanner;

public class ConsoleRunner {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void run() {
        System.out.println("Welcome to TheLine game!");
        System.out.print("What size of board (int)? ");
        int size = INPUT.nextInt();
        Board board = createBoard(size);
        System.out.println("Here you go! Good Luck!");
        System.out.println(board);

        int moveCount = 1; // TODO: allow quick reuse of last point
        while(!board.solved()) {
            System.out.println("MOVE " + moveCount);
            System.out.println("Which square would you like to rotate?");
            Point p = getPointFromUser(size);
            board.rotate(p.y, p.x);
            System.out.println("\n" + board);
            moveCount++;
        }

        System.out.println("You solved the board!");
        System.out.print("Would you like to play again (y,n)? ");
        INPUT.nextLine(); // used to fix leftover newline from nextInt
        String playAgain = INPUT.nextLine();
        if (playAgain.equalsIgnoreCase("y")) {
            System.out.println();
            run();
        } else {
            System.out.println("Goodbye!");
        }
    }

    /**
     * Creates a new unsolved board of size
     *
     * @param size the size of the board which is number of squares across and down
     */
    private static Board createBoard(int size) {
        Board b = new Board(size);
        // make sure board is not already solved
        while (b.solved()) {
            b = new Board(size);
        }
        return b;
    }

    /**
     * Prompts user for a point. Uses the size to make sure the user stays within the board
     *
     * @param size size of the board
     */
    private static Point getPointFromUser(int size) {
        System.out.print("x=? ");
        int x = INPUT.nextInt();
        while (x < 1 || size < x) {
            System.out.println("x must be 1-" + size);
            System.out.print("x=? ");
            x = INPUT.nextInt();
        }
        System.out.print("y=? ");
        int y = INPUT.nextInt();
        while (y < 1 || size < y) {
            System.out.println("y must be 1-" + size);
            System.out.print("y=? ");
            y = INPUT.nextInt();
        }
        return new Point(x - 1, y - 1);
    }
}
