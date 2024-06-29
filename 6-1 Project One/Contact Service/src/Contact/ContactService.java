/*************************
 * Name: 	Kendall Ferebee
 * Course: 	CS-320 
 * Date: 	May 26, 2024
 *************************/

package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts using contactId as key
    private final Map<String, Contact> contacts;

    // Constructor to initialize the contact service
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Method to add a contact ensuring unique contact ID
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Method to delete a contact by contact ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Helper method to get a contact by contact ID or throw an exception if it doesn't exist
    private Contact getContactOrThrow(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        return contact;
    }

    // Method to update first name of a contact by contact ID
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContactOrThrow(contactId);
        contact.setFirstName(firstName);
    }

    // Method to update last name of a contact by contact ID
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContactOrThrow(contactId);
        contact.setLastName(lastName);
    }

    // Method to update phone number of a contact by contact ID
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContactOrThrow(contactId);
        contact.setPhone(phone);
    }

    // Method to update address of a contact by contact ID
    public void updateAddress(String contactId, String address) {
        Contact contact = getContactOrThrow(contactId);
        contact.setAddress(address);
    }

    // Method to retrieve a contact by contact ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
