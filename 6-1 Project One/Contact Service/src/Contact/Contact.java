package Contact;

public class Contact {
  
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to initialize Contact object with validation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Validate phone number
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign values to the fields
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contact ID
    public String getContactId() {
        return contactId;
    }

    // Getter and Setter for first name with validation
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Getter and Setter for last name with validation
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Getter and Setter for phone with validation
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    // Getter and Setter for address with validation
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
