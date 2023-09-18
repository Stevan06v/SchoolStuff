package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class PuzzleController {
    private static HashMap<Character, Direction> directions;

    static {
        directions = new HashMap<>();
        directions.put('W', Direction.UP);
        directions.put('S', Direction.DOWN);
        directions.put('A', Direction.LEFT);
        directions.put('D', Direction.RIGHT);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Puzzle puzzle = new Puzzle(4);

        while(!puzzle.isSolved()) {
            PuzzleView.drawBoard(puzzle);
            System.out.println("Number of moves: " + puzzle.getMoves());

            System.out.print("Please enter a direction (WASD), R to reset or Q to quit: ");
            try {
                char userInput = scanner.nextLine().toUpperCase().charAt(0);

                if (userInput == 'Q') {
                    break;
                } else if (userInput == 'R') {
                    puzzle.reset();
                } else {
                    Direction direction = directions.get(userInput);
                    puzzle.move(direction);
                }
            }
            catch(Exception ex) {
                System.out.println("Illegal input! Please try again.");
            }
        }

        if(puzzle.isSolved()) {
            PuzzleView.drawBoard(puzzle);
            System.out.printf("Congratulations! You solved the puzzle in %d moves!%n", puzzle.getMoves());
        }
        System.out.println("Thanks for playing! :)");
    }
}
