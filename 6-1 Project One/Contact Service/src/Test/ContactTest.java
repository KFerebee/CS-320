package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {

    // Test to validate successful creation of a contact
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test to validate invalid contact ID scenarios
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test to validate invalid first name scenarios
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test to validate invalid last name scenarios
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }

    // Test to validate invalid phone number scenarios
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345", "123 Main St");
        });
    }

    // Test to validate invalid address scenarios
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St 123 Main St 123 Main St 123 Main St");
        });
    }
}