module at.htlleonding.puzzle {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding.puzzle to javafx.fxml;
    exports at.htlleonding.puzzle;
    exports at.htlleonding.puzzle.controller;
    opens at.htlleonding.puzzle.controller to javafx.fxml;
}
