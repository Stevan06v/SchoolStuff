package at.htlleonding.watch.controller;

import at.htlleonding.watch.model.DayOfWeek;
import at.htlleonding.watch.model.WatchTime;
import javafx.beans.binding.StringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.util.converter.NumberStringConverter;

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

        cmbDayOfWeek.getItems().addAll(DayOfWeek.values());

        //TODO: Bind labels of digital watch (one-way). Use StringBinding for the minutes to format them (leading 0s).

        lblHours.textProperty().bindBidirectional(WatchTime.getInstance().hoursProperty(), new NumberStringConverter());
        lblMinutes.textProperty().bindBidirectional(WatchTime.getInstance().minutesProperty(), new NumberStringConverter() {
            @Override
            public String toString(Number value) {
                return String.format("%02d", value.intValue()); //leading 0s
            }
        });
        lblDayOfWeek.textProperty().bindBidirectional(WatchTime.getInstance().dayOfWeekShortProperty());


        //TODO: Bind slider (bidirectionally!) and slider label (one-way).

        sldTickDelay.valueProperty().bindBidirectional(WatchTime.getInstance().tickDelayProperty());
        lblTickDelay.textProperty().bind(
                new StringBinding() {
                    {
                        super.bind(sldTickDelay.valueProperty());
                    }

                    @Override
                    protected String computeValue() {
                        return String.format("%d ms", (int) sldTickDelay.getValue());
                    }
                }
        );

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


    public void btnAdjustOnAction(ActionEvent actionEvent) {
        String time = txtTime.getText();
        if(time.length() != 5 || time.charAt(2) != ':') {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Invalid data entered!");
            alert.showAndWait();
            return;
        }
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        WatchTime.getInstance().setTime(
                hours,
                minutes,
                cmbDayOfWeek.getValue()
        );
    }
}
