package at.htlleonding.watch.controller;

import at.htlleonding.watch.model.DayOfWeek;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.shape.Line;

import java.time.LocalTime;

public class FastWatchController {
    @FXML
    private Line linHandHours;

    @FXML
    private Line linHandMinutes;

    @FXML
    private Label lblDayOfWeek;

    @FXML
    private Label lblHours;

    @FXML
    private Label lblMinutes;

    @FXML
    private TextField txtTime;

    @FXML
    private ComboBox<DayOfWeek> cmbDayOfWeek;

    @FXML
    private Slider sldTickDelay;

    @FXML
    private Label lblTickDelay;

    @FXML
    private void initialize() {
        //TODO: Fill ComboBox from enum.


        //TODO: Bind labels of digital watch (one-way). Use StringBinding for the minutes to format them (leading 0s).


        //TODO: Bind slider (bidirectionally!) and slider label (one-way).


        //TODO: Add listener to redraw analog hands.


        demonstrateSettingHands();
    }

    private void demonstrateSettingHands() {
        double length = 140; //Approx. half the container size.

        this.linHandHours.setStartX(0);
        this.linHandHours.setStartY(0);
        this.linHandHours.setEndX(-0.866 * length * 0.6);
        this.linHandHours.setEndY(0.49 * length * 0.6);

        this.linHandMinutes.setStartX(0);
        this.linHandMinutes.setStartY(0);
        this.linHandMinutes.setEndX(0);
        this.linHandMinutes.setEndY(-1.0 * length * 0.8);

        //Hint: Use Point2D for storing coordinates - this makes using helper functions easier.
    }

    //TODO: Listen to the action event of the button.
}
