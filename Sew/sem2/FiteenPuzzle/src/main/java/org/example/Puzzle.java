package org.example;
import java.util.Random;

public class Puzzle {

    private int[][] board;
    private int size = 0;

    public Puzzle(int size) {
        board = new int[size][size];
        this.insert(board);
    }

    private void insert(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = i * board.length + j;
                }
            }
        }

        private void shuffle(){


        }
    public boolean isSolved(){
        return false;
    }
    public int getMoves() {
        return 0;
    }

    public void reset() {
    }

    public void move(Direction direction) {
                switch (direction){
                    case DOWN:
                        System.out.println("DOWN");
                        for (int i = 0; i < this.board.length; i++) {
                            for (int j = 0; j < this.board[i].length; j++) {
                                if(this.board[i][j] == 0) {
                                    int cache = this.board[i+1][j];
                                    this.board[i+1][j] = this.board[i][j];
                                    this.board[i][j] = cache;
                                    break;
                                }
                            }
                        }
                        break;
                    case UP:
                        System.out.println("UP");
                        for (int i = 0; i < this.board.length; i++) {
                            for (int j = 0; j < this.board[i].length; j++) {
                                if(this.board[i][j] == 0) {
                                    int cache = this.board[i-1][j];
                                    this.board[i-1][j] = this.board[i][j];
                                    this.board[i][j] = cache;
                                    break;
                                }
                            }
                        }
                        break;
                    case LEFT :
                        System.out.println("LEFT");
                        for (int i = 0; i < this.board.length; i++) {
                            for (int j = 0; j < this.board[i].length; j++) {
                                if(this.board[i][j] == 0) {
                                    int cache = this.board[i][j-1];
                                    this.board[i][j-1] = this.board[i][j];
                                    this.board[i][j] = cache;
                                    break;
                                }
                            }
                        }
                        break;
                    case RIGHT:
                        System.out.println("RIGHT");
                        for (int i = 0; i < this.board.length; i++) {
                            for (int j = 0; j < this.board[i].length; j++) {
                                if(this.board[i][j] == 0) {
                                    int cache = this.board[i][j+1];
                                    this.board[i][j+1] = this.board[i][j];
                                    this.board[i][j] = cache;
                                    break;
                                }
                            }
                        }
                        break;
                }
            }


    public int[][] getBoard() {
        return this.board;
    }
}
