package org.example;

public class PuzzleView {
    public static void drawBoard(Puzzle puzzle) {
        int[][] board = puzzle.getBoard();

        System.out.println();

        printLine(board[0].length);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print("|");

                if(board[i][j] > 0) {
                    System.out.print(String.format(" %2d ", board[i][j]));
                }
                else {
                    System.out.print("    ");
                }
            }
            System.out.println("|");

            printLine(board[i].length);
        }

        System.out.println("");
    }

    private static void printLine(int length) {
        for(int i = 0; i < length; i++) {
            System.out.print("+----");
        }
        System.out.println("+");
    }
}
