package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Mutable
 * Represents a board object in the game of creating a line from the top left to the bottom right.
 */
public class Board {
    private Square[][] board;

    /**
     * Creates a board with size n.
     *
     * @param n the number of squares in the width and length of the board
     */
    public Board(int n) {
        // initializes board
        board = new Square[n][n]; // TODO: can shape class be static

        // creates a line in the board
        createLine(new Point(0, 0), new Stack<>());

        // create random shapes for the rest of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new Square(ShapeUtil.getRandomShape());
                }
            }
        }
    }

    /**
     * Rotates the square at row i and column j
     *
     * @param i the square row
     * @param j the square column
     */
    public void rotate(int i, int j) {
        board[i][j].rotate();
    }

    /**
     * Returns true if a line can be made from the top left corner of the board to the bottom right.
     */
    public boolean solved() {
        return false;
    }

    // returns true if line created
    private boolean createLine(Point currentPoint, Stack<Point> pointsVisited) {
        // the line has reached the bottom right corner
        if (currentPoint.y == board.length - 1 && currentPoint.x == board[0].length - 1) {
            board[currentPoint.y][currentPoint.x] = createSquare(pointsVisited.peek(), null);
            return true;
        }

        List<Point> pointOptions = new ArrayList<>();
        pointOptions.add(new Point(currentPoint.x , currentPoint.y + 1)); // right
        pointOptions.add(new Point(currentPoint.x + 1, currentPoint.y)); // down
        pointOptions.add(new Point(currentPoint.x, currentPoint.y - 1)); // left
        pointOptions.add(new Point(currentPoint.x - 1, currentPoint.y)); // up

        while (pointOptions.size() != 0) {
            int index = (int) (Math.random() * pointOptions.size());
            Point nextPoint = pointOptions.get(index);
            if (isPointValid(nextPoint, pointsVisited)) {
                Point lastPoint = pointsVisited.empty() ? null : pointsVisited.peek();
                pointsVisited.push(currentPoint);
                if (createLine(nextPoint, pointsVisited)) {
                    board[currentPoint.x][currentPoint.y] = createSquare(lastPoint, nextPoint);
                    return true;
                }
                pointsVisited.pop();
            }
            pointOptions.remove(index);
        }

        return false;
    }

    private boolean isPointValid(Point p, List<Point> pointsVisited) {
        if (pointsVisited.contains(p)) {
            return false;
        }

        if (0 <= p.y && p.y < board.length && 0 <= p.x && p.x < board[0].length) {
            return true;
        }

        return false;
    }

    private Square createSquare(Point lastPoint, Point nextPoint) {
        if (lastPoint == null || nextPoint == null) {
            // first or last point
            return new Square(new Arrow());
        }

        if (lastPoint.x == nextPoint.x || lastPoint.y == nextPoint.y) {
            return new Square(new Line());
        }

        return new Square(new Corner());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < board.length; i++) {
            sb.append(" " + (i + 1) + " ");
        }
        sb.append("\n");

        for (int i = 0; i < board.length; i++) {
            sb.append(" " + (i + 1) + " ");
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
