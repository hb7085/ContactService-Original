package contactapp;

//This class represents a single contact in the system.
//It stores basic information and enforces validation rules.
public class Contact {
	
    private final String contactId;
    
    public String firstName;
    public String lastName;
    public String phone;
    public String address;

    // Constructor creates a new Contact and validates all fields.
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        // Phone must be exactly 10 digits.
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        // Assign values after validation passes.
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods return the values of each field.
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setter methods update fields but still enforce validation.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
    
}
