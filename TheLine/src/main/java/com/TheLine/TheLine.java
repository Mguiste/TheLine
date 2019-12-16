package main.java.com.TheLine;

import java.util.Scanner;

public class TheLine {
    public static void main(String[] args) {
        Board board = new Board(5);
        System.out.println(board);
        Scanner input = new Scanner(System.in);
        while(true) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            board.rotate(y, x);
            System.out.println(board);
        }
    }
}
