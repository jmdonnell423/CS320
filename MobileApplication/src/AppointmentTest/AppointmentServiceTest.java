package AppointmentTest;

import org.junit.jupiter.api.Test;

import AppointmentService.Appointment;
import AppointmentService.AppointmentService;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    @Test
    public void addAndGetAppointment() {
        // Given
        AppointmentService appointmentService = new AppointmentService();
        Date date = new Date();
        Appointment appointment = new Appointment("1234567890", date, "Test appointment");

        // When
        appointmentService.addAppointment(appointment);
        Appointment retrievedAppointment = appointmentService.getAppointmentById("1234567890");

        // Then
        assertEquals(appointment, retrievedAppointment);
    }

    @Test
    public void addDuplicateAppointmentIdThrowsException() {
        // Given
        AppointmentService appointmentService = new AppointmentService();
        Date date = new Date();
        Appointment appointment = new Appointment("1234567890", date, "Test appointment");
        appointmentService.addAppointment(appointment);

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment));
    }

    @Test
    public void deleteAppointment() {
        // Given
        AppointmentService appointmentService = new AppointmentService();
        Date date = new Date();
        Appointment appointment = new Appointment("1234567890", date, "Test appointment");
        appointmentService.addAppointment(appointment);

        // When
        appointmentService.deleteAppointment("1234567890");

        // Then
        assertNull(appointmentService.getAppointmentById("1234567890"));
    }

    @Test
    public void deleteNonexistentAppointment() {
        // Given
        AppointmentService appointmentService = new AppointmentService();

        // When / Then
        assertDoesNotThrow(() -> appointmentService.deleteAppointment("nonexistentId"));
    }

    @Test
    public void getNonexistentAppointmentByIdReturnsNull() {
        // Given
        AppointmentService appointmentService = new AppointmentService();

        // When
        Appointment appointment = appointmentService.getAppointmentById("nonexistentId");

        // Then
        assertNull(appointment);
    }
}

