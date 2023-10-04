package at.htlleonding.puzzle.controller;

import at.htlleonding.puzzle.model.Puzzle;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class PuzzleController {

    Puzzle puzzle;

    @FXML
    private FlowPane fpTiles;

    @FXML
    private void initialize() {
        this.puzzle = new Puzzle(4);

        redrawTiles();
    }

    private void redrawTiles() {
        this.fpTiles.getChildren().clear();

        int[][] board = this.puzzle.getBoard();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                StackPane tile = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(80);
                rectangle.setWidth(80);

                if(board[i][j] == 0) {
                    rectangle.setFill(Color.DARKORANGE);
                    tile.getChildren().add(rectangle);
                }
                else {
                    rectangle.setFill(Color.FIREBRICK);
                    rectangle.setStrokeType(StrokeType.INSIDE);
                    rectangle.setStroke(Color.DARKORANGE);
                    rectangle.strokeWidthProperty().setValue(2);

                    Text text = new Text();
                    text.setFill(Color.GOLD);
                    text.setStyle("-fx-font-size: 24;");
                    text.setText("" + board[i][j]);

                    tile.getChildren().addAll(rectangle, text);
                }
                this.fpTiles.getChildren().add(tile);
            }
        }
    }
}
