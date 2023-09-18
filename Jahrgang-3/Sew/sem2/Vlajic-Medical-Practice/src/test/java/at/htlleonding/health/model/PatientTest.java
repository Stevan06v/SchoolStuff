package at.htlleonding.health.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    @Test
    void testConstructor() {
        Patient patient = new Patient("John Doe", LocalDateTime.of(2022, 3, 14, 12, 30), false);

        assertEquals("John Doe", patient.getName());
        assertEquals(LocalDateTime.of(2022, 3, 14, 12, 30), patient.getAppointment());
        assertEquals(false, patient.isEmergency());

        patient = new Patient("Jan Kowalski", LocalDateTime.of(2022, 3, 14, 12, 15), true);

        assertEquals("Jan Kowalski", patient.getName());
        assertEquals(LocalDateTime.of(2022, 3, 14, 12, 15), patient.getAppointment());
        assertEquals(true, patient.isEmergency());
    }

    @Test
    void testToString() {
        Patient patient = new Patient("John Doe", LocalDateTime.of(2022, 3, 14, 12, 30), false);

        assertEquals("14.3.22 12:30 John Doe", patient.toString());

        patient = new Patient("Jan Kowalski", LocalDateTime.of(2022, 3, 14, 12, 15), true);

        assertEquals("EMERGENCY Jan Kowalski", patient.toString());
    }

    @Test
    void testCompareToCorrectOrder() {
        LocalDateTime now = LocalDateTime.now();
        Patient patientOtto = new Patient("Otto Normalverbraucher", now, true);
        Patient patientTom = new Patient("Tom Taxpayer", now.plusMinutes(20), true);
        Patient patientRichard = new Patient("Richard Roe", now.plusHours(1), true);
        Patient patientLieschen = new Patient("Lieschen Müller", now.plusYears(1), true);
        Patient patientJan = new Patient("Jan Kowalski", LocalDateTime.of(2022, 3, 14, 12, 15), false);
        Patient patientJohn = new Patient("John Doe", LocalDateTime.of(2022, 3, 14, 12, 30), false);
        Patient patientMax = new Patient("Max Mustermann", LocalDateTime.of(2022, 3, 14, 13, 00), false);
        Patient patientSally = new Patient("Sally Sixpack", LocalDateTime.of(2022, 3, 15, 12, 00), false);

        List<Patient> patients = new LinkedList<>();
        patients.add(patientOtto);
        patients.add(patientTom);
        patients.add(patientRichard);
        patients.add(patientLieschen);
        patients.add(patientJan);
        patients.add(patientJohn);
        patients.add(patientMax);
        patients.add(patientSally);

        Collections.shuffle(patients);

        Collections.sort(patients);

        assertEquals(patientOtto, patients.get(0));
        assertEquals(patientTom, patients.get(1));
        assertEquals(patientRichard, patients.get(2));
        assertEquals(patientLieschen, patients.get(3));
        assertEquals(patientJan, patients.get(4));
        assertEquals(patientJohn, patients.get(5));
        assertEquals(patientMax, patients.get(6));
        assertEquals(patientSally, patients.get(7));
    }
}