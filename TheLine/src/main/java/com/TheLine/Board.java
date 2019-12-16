package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.Circle;
import main.java.com.TheLine.Shapes.Plus;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Mutable
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
        board = new Square[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(new Plus()); // TODO: can shape class be static
            }
        }

        // creates a line in the board
        createLine(new Point(), new Stack<>());
    }

    public void rotate(int i, int j) {
        board[i][j].rotate();
    }

    // returns true if line created
    private boolean createLine(Point currentPoint, Stack<Point> pointsVisited) {
        // the line has reached the bottom right corner
        if (currentPoint.x == board.length - 1 && currentPoint.y == board[0].length - 1) {
            board[currentPoint.x][currentPoint.y] = new Square(new Circle());
            return true;
        }

        List<Point> pointOptions = new ArrayList<>();
        pointOptions.add(new Point(currentPoint.x + 1, currentPoint.y)); // right
        pointOptions.add(new Point(currentPoint.x, currentPoint.y + 1)); // down
        pointOptions.add(new Point(currentPoint.x - 1, currentPoint.y)); // left
        pointOptions.add(new Point(currentPoint.x, currentPoint.y - 1)); // up

        while (pointOptions.size() != 0) {
            int index = (int) (Math.random() * pointOptions.size());
            Point nextPoint = pointOptions.get(index);
            if (isPointValid(nextPoint, pointsVisited)) {
                pointsVisited.push(currentPoint);
                if (createLine(nextPoint, pointsVisited)) {
                    board[currentPoint.x][currentPoint.y] = new Square(new Circle());
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

        if (0 <= p.x && p.x < board.length && 0 <= p.y && p.y < board[0].length) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
