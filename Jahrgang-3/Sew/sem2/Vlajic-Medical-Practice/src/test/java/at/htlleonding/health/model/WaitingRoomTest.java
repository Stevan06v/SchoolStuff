package at.htlleonding.health.model;

import at.htlleonding.observer.ChangeObserver;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitingRoomTest {
    private List<Patient> createPatients() {
        Patient patientOtto = new at.htlleonding.health.model.Patient("Otto Normalverbraucher", LocalDateTime.of(2022, 3, 14, 12, 00), true);
        Patient patientTom = new at.htlleonding.health.model.Patient("Tom Taxpayer", LocalDateTime.of(2022, 3, 14, 12, 20), true);
        Patient patientRichard = new at.htlleonding.health.model.Patient("Richard Roe", LocalDateTime.of(2022, 3, 14, 13, 00), true);
        Patient patientLieschen = new at.htlleonding.health.model.Patient("Lieschen Müller", LocalDateTime.of(2023, 3, 14, 12, 00), true);
        Patient patientJan = new at.htlleonding.health.model.Patient("Jan Kowalski", LocalDateTime.of(2022, 3, 14, 12, 15), false);
        Patient patientJohn = new at.htlleonding.health.model.Patient("John Doe", LocalDateTime.of(2022, 3, 14, 12, 30), false);
        Patient patientMax = new at.htlleonding.health.model.Patient("Max Mustermann", LocalDateTime.of(2022, 3, 14, 13, 00), false);
        Patient patientSally = new at.htlleonding.health.model.Patient("Sally Sixpack", LocalDateTime.of(2022, 3, 15, 12, 00), false);

        List<at.htlleonding.health.model.Patient> result = new LinkedList<>();
        result.add(patientOtto);
        result.add(patientTom);
        result.add(patientRichard);
        result.add(patientLieschen);
        result.add(patientJan);
        result.add(patientJohn);
        result.add(patientMax);
        result.add(patientSally);

        Collections.shuffle(result);

        return result;
    }

    @Test
    void testAddTreatOnePatient() {
        WaitingRoom waitingRoom = new WaitingRoom();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals(null, waitingRoom.getPatientInPreparation());

        waitingRoom.addPatient("John Doe", LocalDateTime.of(2022, 3, 14, 12, 30), false);

        assertEquals(1, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals("14.3.22 12:30 John Doe", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals("14.3.22 12:30 John Doe", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals(null, waitingRoom.getPatientInPreparation());

        waitingRoom.treatNextPatient();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals(null, waitingRoom.getPatientInPreparation());
    }

    @Test
    void testQueue() {
        List<Patient> patients = createPatients();

        WaitingRoom waitingRoom = new WaitingRoom();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals(null, waitingRoom.getPatientInPreparation());

        for(Patient currPatient : patients) {
            waitingRoom.addPatient(currPatient.getName(), currPatient.getAppointment(), currPatient.isEmergency());
        }

        assertEquals(8, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals("EMERGENCY Otto Normalverbraucher", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(7, waitingRoom.getPatientCount());
        assertEquals("EMERGENCY Otto Normalverbraucher", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("EMERGENCY Tom Taxpayer", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(6, waitingRoom.getPatientCount());
        assertEquals("EMERGENCY Tom Taxpayer", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("EMERGENCY Richard Roe", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(5, waitingRoom.getPatientCount());
        assertEquals("EMERGENCY Richard Roe", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("EMERGENCY Lieschen Müller", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(4, waitingRoom.getPatientCount());
        assertEquals("EMERGENCY Lieschen Müller", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("14.3.22 12:15 Jan Kowalski", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(3, waitingRoom.getPatientCount());
        assertEquals("14.3.22 12:15 Jan Kowalski", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("14.3.22 12:30 John Doe", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(2, waitingRoom.getPatientCount());
        assertEquals("14.3.22 12:30 John Doe", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("14.3.22 13:00 Max Mustermann", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(1, waitingRoom.getPatientCount());
        assertEquals("14.3.22 13:00 Max Mustermann", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals("15.3.22 12:00 Sally Sixpack", waitingRoom.getPatientInPreparation().toString());

        waitingRoom.treatNextPatient();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals("15.3.22 12:00 Sally Sixpack", waitingRoom.getPatientUndergoingTreatment().toString());
        assertEquals(null, waitingRoom.getPatientInPreparation());

        waitingRoom.treatNextPatient();

        assertEquals(0, waitingRoom.getPatientCount());
        assertEquals(null, waitingRoom.getPatientUndergoingTreatment());
        assertEquals(null, waitingRoom.getPatientInPreparation());
    }

    @Test
    void testObserversReceiveUpdates() {
        List<Patient> patients = createPatients();

        UpdateObserver observerFirstHalf = new UpdateObserver();
        UpdateObserver observerSecondHalf = new UpdateObserver();

     /*
        waitingRoom.addObserver(observerFirstHalf);
        //Dirty hack for changing variable inside inner class below:
        int[] counter = {0};
        waitingRoom.addObserver(new ChangeObserver<WaitingRoom>() {
            @Override
            public void update(WaitingRoom subject) {
                counter[0]++;
            }
        });

        for(Patient currPatient : patients) {
            waitingRoom.addPatient(currPatient.getName(), currPatient.getAppointment(), currPatient.isEmergency());
        }

        assertEquals(9, counter[0]);
        assertEquals(9, observerFirstHalf.getUpdateCount());
        assertEquals(0, observerSecondHalf.getUpdateCount());

        waitingRoom.removeObserver(observerFirstHalf);
        waitingRoom.addObserver(observerSecondHalf);

        while(waitingRoom.getPatientUndergoingTreatment() != null || waitingRoom.getPatientInPreparation() != null) {
            waitingRoom.treatNextPatient();
        }

        assertEquals(18, counter[0]);
        assertEquals(9, observerFirstHalf.getUpdateCount());
        assertEquals(10, observerSecondHalf.getUpdateCount());
        */
    }

}

