package Test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Appointment.Appointment; 
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

// Define the test class
public class AppointmentTest {

    private Date futureDate; // Declare a variable to hold a future date
    
    // Method to run before each test method
    @BeforeEach
    public void setUp() {
        futureDate = new Date(System.currentTimeMillis() + 100000); 
    }

    // Test for creating a valid appointment
    @Test
    public void testAppointmentCreationSuccess() {
        // Create an appointment instance with valid data
        Appointment appointment = new Appointment("12345", futureDate, "Doctor appointment");

        // Assert that appointment ID, date, and description match expected values
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    // Test for invalid appointment ID (null or too long)
    @Test
    public void testInvalidAppointmentId() {
        // Assert that creating an appointment with a null or too long ID throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Doctor appointment");
        });
    }

    // Test for invalid appointment date (past or null)
    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        
        // Assert that creating an appointment with a past or null date throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Doctor appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Doctor appointment");
        });
    }

    // Test for invalid description (null or too long)
    @Test
    public void testInvalidDescription() {
        // Assert that creating an appointment with a null or too long description throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is way too long and exceeds fifty characters limit");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "");
        });
    }
}
