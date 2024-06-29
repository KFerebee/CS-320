package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Initializes ContactService and adds a sample Contact before each test.
        contactService = new ContactService();
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St, City, State");
        contactService.addContact(contact);
    }

    @Test
    public void testAddContact() {
        // Tests adding a new Contact.
        // Creates a new Contact object and adds it to the contactService.
        // Asserts that the contactService can retrieve the newly added Contact.
        Contact newContact = new Contact("0987654321", "Jane", "Smith", "0987654321", "456 Elm St, City, State");
        contactService.addContact(newContact);
        assertEquals(newContact, contactService.getContact("0987654321"));
    }

    @Test
    public void testAddDuplicateContact() {
        // Tests adding a Contact with a duplicate ID (should throw an exception).
        // Attempts to add a Contact with the same ID as an existing Contact.
        // Asserts that an IllegalArgumentException is thrown.
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St, City, State"));
        });
    }

    @Test
    public void testDeleteContact() {
        // Tests deleting an existing Contact.
        // Deletes the Contact with the specified ID from the contactService.
        // Asserts that the Contact with the specified ID no longer exists in the contactService.
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateFirstName() {
        // Tests updating the first name of an existing Contact.
        // Updates the first name of the Contact with the specified ID.
        // Asserts that the first name of the Contact is updated correctly.
        contactService.updateFirstName("1234567890", "Johnny");
        assertEquals("Johnny", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        // Tests updating the last name of an existing Contact.
        // Updates the last name of the Contact with the specified ID.
        // Asserts that the last name of the Contact is updated correctly.
        contactService.updateLastName("1234567890", "Smith");
        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        // Tests updating the phone number of an existing Contact.
        // Updates the phone number of the Contact with the specified ID.
        // Asserts that the phone number of the Contact is updated correctly.
        contactService.updatePhone("1234567890", "1111111111");
        assertEquals("1111111111", contactService.getContact("1234567890").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        // Tests updating the address of an existing Contact.
        // Updates the address of the Contact with the specified ID.
        // Asserts that the address of the Contact is updated correctly.
        contactService.updateAddress("1234567890", "789 Pine St, City, State");
        assertEquals("789 Pine St, City, State", contactService.getContact("1234567890").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        // Tests updating a non-existent Contact (should throw an exception).
        // Attempts to update the first name of a Contact with a non-existent ID.
        // Asserts that an IllegalArgumentException is thrown.
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("nonexistent", "Johnny");
        });
    }
}




