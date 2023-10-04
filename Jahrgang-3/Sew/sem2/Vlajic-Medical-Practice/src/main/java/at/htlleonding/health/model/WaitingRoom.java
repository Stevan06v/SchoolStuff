package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WaitingRoom {
    private PriorityQueue<Patient> patients = new PriorityQueue<>();
    private Patient patientUndergoingTreatment;
    private List<ChangeObserver<WaitingRoom>> observers = new ArrayList<>();

    public PriorityQueue<Patient> getPatients() {
        return patients;
    }

    public List<ChangeObserver<WaitingRoom>> getObservers() {
        return observers;
    }

    public int getPatientCount() {
        return patients.size();
    }

    public Patient getPatientUndergoingTreatment() {
        return this.patientUndergoingTreatment;
    }

    public Patient getPatientInPreparation() {
        return patients.peek();
    }

    public void addPatient(String johnDoe, LocalDateTime of, boolean b) {
        Patient patient = new Patient(johnDoe, of, b);
        patients.add(patient);
        updateObservers();
    }

    public void treatNextPatient() {
        patientUndergoingTreatment = patients.poll();
        updateObservers();
    }

    public void addObserver(ChangeObserver<WaitingRoom> observer) {
        observers.add(observer);
        observer.update(this);
    }
    public void removeObserver(ChangeObserver<WaitingRoom> observer) {
        observers.remove(observer);
    }
    private void updateObservers() {
        for(ChangeObserver<WaitingRoom> currObserver : this.observers) {
            currObserver.update(this);
        }
    }

}