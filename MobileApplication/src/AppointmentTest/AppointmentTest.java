package AppointmentTest;
import org.junit.jupiter.api.Test;

import AppointmentService.Appointment;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void appointmentConstructorTest() {
        Date date = new Date();
        Appointment appointment = new Appointment("1234567890", date, "Test appointment");

        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(date, appointment.getAppointmentDate());
        assertEquals("Test appointment", appointment.getDescription());
    }

    @Test
    public void appointmentIdShouldNotBeNull() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, date, "Test appointment"));
    }

    @Test
    public void appointmentIdShouldNotExceedMaxLength() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", date, "Test appointment"));
    }

    @Test
    public void appointmentDateShouldNotBePast() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", pastDate, "Test appointment"));
    }

    @Test
    public void descriptionShouldNotBeNull() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", date, null));
    }

    @Test
    public void descriptionShouldNotExceedMaxLength() {
        Date date = new Date();
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", date, "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
    }

	@Test
	public void appointmentWithValidInput() {
	    // Given
	    Date futureDate = new Date(System.currentTimeMillis() + 100000);
	    
	    // When / Then
	    assertDoesNotThrow(() -> new Appointment("12345", futureDate, "Valid description"));
	}
}
