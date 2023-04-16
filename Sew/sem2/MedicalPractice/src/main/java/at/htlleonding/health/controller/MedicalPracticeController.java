package at.htlleonding.health.controller;

import at.htlleonding.health.model.Patient;
import at.htlleonding.health.model.WaitingRoom;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedicalPracticeController {

    private WaitingRoom waitingRoom;
    @FXML
    private TextArea taPatientQueue;
    @FXML
    private Button btnNextPatient;
    @FXML
    private Label patientsLeft;
    @FXML
    private Label currentTreatedPatient;
    @FXML
    private Label preparingPatient;
    @FXML
    private Button btnAddPatient;
    @FXML
    private CheckBox cbEmergency;
    @FXML
    private TextField patientAppointmentTime;
    @FXML
    private DatePicker patientAppointmentDate;
    @FXML
    private TextField patientName;


    public void initialize() {
        waitingRoom = new WaitingRoom();
        updateButtonNextPatient();
    }

    public void addPatient(){

        LocalDateTime dateTime = null;
        try{
            String appointmentDateString = patientAppointmentDate.getValue().toString().strip();
            System.out.println(appointmentDateString);
            String appointmentTimeString = patientAppointmentTime.getText().toString().strip();
            System.out.println(appointmentTimeString);
            String appointmentDateTimeString = appointmentDateString +" "+appointmentTimeString;
            System.out.println(appointmentDateTimeString);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            dateTime = LocalDateTime.parse(appointmentDateTimeString,formatter);

            boolean isEmergency;
            if(cbEmergency.isSelected()){
                isEmergency = true;
            }else{
                isEmergency = false;
            }

            waitingRoom.addPatient(patientName.getText().strip().toString(),dateTime,isEmergency);
            update();

            //emptying the fields
            patientName.setText("");
            patientAppointmentTime.setText("");
            cbEmergency.setIndeterminate(false);
            updateButtonNextPatient();
        }catch (Exception ex){
            //TODO allert wrong date or time
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Incorrect Date entered!");
            // show the dialog
            a.show();
            patientAppointmentTime.setText("");
        }

    }

    public void nextPatient(){
            waitingRoom.treatNextPatient();
            update();
            updateButtonNextPatient();
    }

    public void update(){
        taPatientQueue.clear();
        for (Patient currPatient:waitingRoom.getPatients()) {
            taPatientQueue.appendText(currPatient.toString() + "\n");
        }
        if(waitingRoom.getPatientInPreparation()!=null) {
            preparingPatient.setText(waitingRoom.getPatientInPreparation().getName());
        }else{
            preparingPatient.setText("");
        }
        if(waitingRoom.getPatientUndergoingTreatment()!=null) {
            currentTreatedPatient.setText(waitingRoom.getPatientUndergoingTreatment().getName());
        }else{
            currentTreatedPatient.setText("");
        }
        patientsLeft.setText(Integer.toString(waitingRoom.getPatientCount()));
    }

    public void updateButtonNextPatient(){
        if(waitingRoom.getPatients().isEmpty()){
            btnNextPatient.setDisable(true);
        }else {
            btnNextPatient.setDisable(false);
        }
    }

    public void cbsetEmergencyDateTime(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime now = LocalDateTime.now();

        System.out.println(dateFormat.format(now));
        System.out.println(timeFormat.format(now));

        patientAppointmentDate.setValue(LocalDate.parse(dateFormat.format(now)));
        patientAppointmentTime.setText(timeFormat.format(now));
    }
}
