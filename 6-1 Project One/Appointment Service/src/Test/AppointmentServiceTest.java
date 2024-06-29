package Test;

import Appointment.Appointment;
import Appointment.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    // Test adding a new appointment
    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); 
        Appointment appointment = new Appointment("12345", futureDate, "Doctor appointment");

        assertTrue(appointmentService.addAppointment(appointment));
        assertNotNull(appointmentService.getAppointment("12345"));
    }

    // Test adding a duplicate appointment
    @Test
    public void testAddDuplicateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); 
        Appointment appointment1 = new Appointment("12345", futureDate, "Doctor appointment");
        Appointment appointment2 = new Appointment("12345", futureDate, "Dentist appointment");

        assertTrue(appointmentService.addAppointment(appointment1));
        assertFalse(appointmentService.addAppointment(appointment2));
    }

    // Test deleting an existing appointment
    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); 
        Appointment appointment = new Appointment("12345", futureDate, "Doctor appointment");
        appointmentService.addAppointment(appointment);

        assertTrue(appointmentService.deleteAppointment("12345"));
        assertNull(appointmentService.getAppointment("12345"));
    }

    // Test deleting a non-existent appointment
    @Test
    public void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("54321"));
    }
}
