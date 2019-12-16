package main.java.com.TheLine;

import java.util.Scanner;

public class TheLine {
    public static void main(String[] args) {
        Board board = new Board(5);
        System.out.println(board);
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while(true) {
            String coords = input.nextLine();
            if (!coords.isEmpty()) {
                x = Integer.parseInt(coords.split(" ")[0]) - 1;
                y = Integer.parseInt(coords.split(" ")[1]) - 1;
            }
            board.rotate(y, x);
            System.out.println(board);
            if (board.solved()) {
                System.out.println("You solved the board");
                System.exit(1);
            }
        }
    }
}
