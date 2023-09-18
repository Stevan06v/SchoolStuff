package at.htlleonding.health.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patient implements Comparable<Patient>{
    private String name;
    private LocalDateTime appointment;
    private boolean isEmergency;

    public String getName() {
        return name;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public Patient(String name, LocalDateTime appointment, boolean isEmergency) {
        this.name = name;
        this.appointment = appointment;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        //14.3.22 12:30 John Doe
        if(this.isEmergency){
            return String.format("EMERGENCY %s",this.getName());
        }
        return String.format("%s %s", this.appointment.format(DateTimeFormatter.ofPattern("dd.M.yy HH:mm")),this.getName());
    }

    @Override
    public int compareTo(Patient o) {
            if (o.isEmergency == this.isEmergency) {
                return this.appointment.compareTo(o.appointment);
            } else if (o.isEmergency == true) {
                return 1;
            } else {
                return -1;
            }
        }
}
