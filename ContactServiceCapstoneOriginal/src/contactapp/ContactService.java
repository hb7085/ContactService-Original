package contactapp;

import java.util.ArrayList;
import java.util.Random;

//This class manages a list of Contact objects.
//It handles adding, deleting, and updating contacts.
public class ContactService {
	// Stores all contacts in memory using an ArrayList.
    private ArrayList<Contact> contacts = new ArrayList<>();
    // Generates a unique 10-character ID for each new contact.
    private String generateUniqueId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder idBuilder = new StringBuilder();
        Random rand = new Random();
        String id;

        do {
        	// Reset the builder and create a new random ID.
            idBuilder.setLength(0);
            for (int i = 0; i < 10; i++) {
                idBuilder.append(characters.charAt(rand.nextInt(characters.length())));
            }
            id = idBuilder.toString();
         // Keep generating IDs until we find one that isn't already used.
        } while (containsId(id));

        return id;
    }
    // Checks if a given ID already exists in the contact list.
    private boolean containsId(String id) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(id)) return true;
        }
        return false;
    }
    // Creates a new Contact and adds it to the list.
    public void addContact(String firstName, String lastName, String phone, String address) {
        String id = generateUniqueId();
        Contact newContact = new Contact(id, firstName, lastName, phone, address);
        contacts.add(newContact);
    }
    // Removes a contact by matching its ID.
    public void deleteContact(String contactId) {
        contacts.removeIf(c -> c.getContactId().equals(contactId));
    }
    // Update methods search for the matching contact and update the field.
    public void updateFirstName(String contactId, String firstName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(firstName);
                break;
            }
        }
    }

    public void updateLastName(String contactId, String lastName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setLastName(lastName);
                break;
            }
        }
    }

    public void updatePhone(String contactId, String phone) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setPhone(phone);
                break;
            }
        }
    }

    public void updateAddress(String contactId, String address) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setAddress(address);
                break;
            }
        }
    }
    // Returns the full list of contacts.
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
