package main.java.com.TheLine;

import main.java.com.TheLine.Shapes.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Mutable
 * Represents a board object in the game of creating a line from the top left to the bottom right.
 */
public class Board {
    private static final Point START_POINT = new Point(0, 0);

    private Square[][] board;

    /**
     * Creates a board with size n.
     *
     * @param n the number of squares in the width and length of the board
     */
    public Board(int n) { // TODO: board reattempt to created board if slow
        // initializes board
        board = new Square[n][n]; // TODO: can shape class be static

        // creates a line in the board
        createLine(START_POINT, new Stack<>());

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
     * Creates board based on a toString of a board
     *
     * @param str
     */
    public Board(String str) {
        String[] lines = str.split("\n");
        board = new Square[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            List<String> squares = split(lines[i], 3);
            board[i] = new Square[squares.size()];
            for (int j = 0; j < squares.size(); j++) {
                board[i][j] = ShapeUtil.parseSquare(squares.get(j));
            }
        }
    }

    private List<String> split(String str, int length) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i += length) {
            strings.add(str.substring(i, i + length));
        }
        return strings;
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
        return solved(START_POINT, new Stack<>());
    }

    // private recursive backtracking method for solved
    private boolean solved(Point currentPoint, Stack<Point> pointsVisited) {
        if (currentPoint.equals(getEndPoint())) {
            // found a solution
            return true;
        }

        // points that this point reaches
        List<Point> nextPoints = getNextPointsFromPoint(currentPoint);

        for (Point nextPoint : nextPoints) {

            // checks if next point is on the board and unvisited
            if (isPointOnBoard(nextPoint) && !pointsVisited.contains(nextPoint)) {

                // used to double check next point also reaches current point
                List<Point> nextNextPoints = getNextPointsFromPoint(nextPoint);
                if (nextNextPoints.contains(currentPoint)) {
                    pointsVisited.push(currentPoint);

                    // continues to next solve point
                    if (solved(nextPoint, pointsVisited)) {
                        return true;
                    }
                    pointsVisited.pop();
                }
            }
        }

        return false;
    }

    private List<Point> getNextPointsFromPoint(Point p) {
        Square currentSquare = board[p.y][p.x];
        Direction[] directions = currentSquare.directionsReached();
        return new ArrayList<>(BoardUtil.getDirectionPoints(p, directions));
    }

    /**
     * Will create a line from current point to the end point in getEndPoint. If successful returns true o.w. returns
     * false;
     *
     * @param currentPoint the point the line is starting from
     * @param pointsVisited a stack of all points already in the line if any
     */
    private boolean createLine(Point currentPoint, Stack<Point> pointsVisited) {
        // the line has reached the end point, a solution has been found
        if (currentPoint.equals(getEndPoint())) {
            board[currentPoint.y][currentPoint.x] = createSquare(pointsVisited.peek(), null);
            return true;
        }

        // gets all adjacent points
        List<Point> pointOptions = new ArrayList<>(BoardUtil.getAdjacentPoints(currentPoint));

        while (pointOptions.size() != 0) {
            // selects a random adjacent points
            int index = (int) (Math.random() * pointOptions.size());
            Point nextPoint = pointOptions.get(index);

            if (isPointOnBoard(nextPoint) && !pointsVisited.contains(nextPoint)) {
                // saves the last point visited so create square knows what shape to use
                Point lastPoint = pointsVisited.empty() ? null : pointsVisited.peek();
                pointsVisited.push(currentPoint);

                if (createLine(nextPoint, pointsVisited)) {
                    // found a solution mark board and return true
                    board[currentPoint.x][currentPoint.y] = createSquare(lastPoint, nextPoint);
                    return true;
                }
                // unable to find solution remove this point from visited list
                pointsVisited.pop();
            }
            // unable to find solution remove this point as an option
            pointOptions.remove(index);
        }

        return false;
    }

    private boolean isPointOnBoard(Point p) {
        if (0 <= p.y && p.y < board.length && 0 <= p.x && p.x < board[0].length) {
            return true;
        }
        return false;
    }

    private Square createSquare(Point lastPoint, Point nextPoint) {
        if (lastPoint == null || nextPoint == null) {
            // first or last point
            return new Square(ShapeUtil.ARROW);
        }

        if (lastPoint.x == nextPoint.x || lastPoint.y == nextPoint.y) {
            return new Square(ShapeUtil.LINE);
        }

        return new Square(ShapeUtil.CORNER);
    }

    private Point getEndPoint() {
        return new Point(board[0].length - 1, board.length - 1);
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
