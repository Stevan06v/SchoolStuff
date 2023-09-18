package at.htlleonding.health.controller;

import at.htlleonding.health.model.Patient;
import at.htlleonding.health.model.WaitingRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;

public class HelloApplication {

    private WaitingRoom waitingRoom;
    @FXML
    private TextArea waitingValues;
    @FXML
    private CheckBox boxCheck;
    @FXML
    private Button btnAddPatient;
    @FXML
    private Button btnNextPlease;
    @FXML
    private Label lblPatient;
    @FXML
    private Label lblPreperation;
    @FXML
    private Label lblUnderGoingTreatment;
    @FXML
    private DatePicker ttpDate;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTime;

    private Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private void btnAddPatientOnAction(ActionEvent event) {

        try{
            String name = txtName.getText();
            String timeArr[] = txtTime.getText().split(":");
            LocalTime time = LocalTime.of(Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1]));
            LocalDateTime appointment = LocalDateTime.of(ttpDate.getValue(), time);
            boolean isEmergency = boxCheck.isSelected();
            waitingRoom.addPatient(name, appointment, isEmergency);
        }catch (Exception e){
            System.out.println(e);
            alert.show();
        }
    }
    @FXML
    private void btnNextPleaseOnAction(ActionEvent event) {
        waitingRoom.treatNextPatient();
    }
    @FXML
    private void initialize(){
        waitingRoom = new WaitingRoom();
        waitingRoom.addObserver(subject -> {
            // update WaitingRoom
            StringBuilder patientStringList = new StringBuilder();
            for (Patient p : subject.getPatients()) {
                patientStringList.append(p.toString()).append("\n");
            }
            waitingValues.setText(patientStringList.toString());
            // prep treat left
            if(subject.getPatientInPreparation() != null) lblPreperation.setText(subject.getPatientInPreparation().toString());
            else lblPreperation.setText("");
            if(subject.getPatientUndergoingTreatment() != null) lblUnderGoingTreatment.setText(subject.getPatientUndergoingTreatment().toString());
            else lblUnderGoingTreatment.setText("");
            lblPatient.setText(String.valueOf(subject.getPatientCount()));
        });
    }
}
