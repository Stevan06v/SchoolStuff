package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;
import at.htlleonding.observer.UpdateObserver;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class WaitingRoom {

    private PriorityQueue<Patient> patients = new PriorityQueue<>();
    private List<ChangeObserver<WaitingRoom>> observers;

    private Patient patientUnderTreatment;

    public int getPatientCount(){
        return patients.size();
    }

    public Patient getPatientInPreparation(){
        return patients.peek();
    }

    public PriorityQueue<Patient> getPatients() {
        return patients;
    }

    public Patient getPatientUndergoingTreatment(){
        return patientUnderTreatment;
    }

    public void addObserver(ChangeObserver<WaitingRoom> observer){
        if(this.observers == null){
            this.observers = new LinkedList<>();
        }
        observer.update(this);
        this.observers.add(observer);
    }

    public void addPatient(String name, LocalDateTime appointment, boolean isEmergency){
        Patient toAdd = new Patient(name,appointment,isEmergency);
        patients.add(toAdd);
        updateObservers();
    }

    public void removeObserver(ChangeObserver<WaitingRoom> observer){
        this.observers.remove(observer);
    }

    public void treatNextPatient(){
        patientUnderTreatment = patients.poll();
        updateObservers();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void updateObservers(){
        if(observers!= null) {
            for (ChangeObserver<WaitingRoom> obs : observers) {
                obs.update(this);
            }
        }
    }
}