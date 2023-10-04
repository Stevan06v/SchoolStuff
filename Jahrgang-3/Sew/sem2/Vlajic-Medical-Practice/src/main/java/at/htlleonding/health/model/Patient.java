package at.htlleonding.health.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patient implements Comparable<Patient>{

    private String name;
    private LocalDateTime appointment;
    private boolean isEmergency;

    public Patient(String name, LocalDateTime appointment, boolean isEmergency) {
        this.name = name;
        this.appointment = appointment;
        this.isEmergency = isEmergency;
    }
    @Override
    public String toString() {
        return !isEmergency ? String.format("%s %s",appointment.format(DateTimeFormatter.ofPattern("dd.M.yy HH:mm")), this.name) : String.format("EMERGENCY %s",this.name) ;
    }
    @Override
    public int compareTo(Patient o) {
        if(o.isEmergency == this.isEmergency){
            return this.appointment.compareTo(o.appointment);
        }else if(o.isEmergency == true){
            return 1;
        }else{
            return -1;
        }
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getAppointment() {
        return appointment;
    }

    public boolean isEmergency() {
        return isEmergency;
    }
}
