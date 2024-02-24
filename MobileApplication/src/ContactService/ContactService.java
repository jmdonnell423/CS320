package ContactService;


import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if(contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is null.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = getContact(contactID);
        if(contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setFirstName(newFirstName); // This will throw an exception if invalid
    }

    public void updateLastName(String contactID, String newLastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(newLastName); // This will throw an exception if invalid
    }

    public void updatePhone(String contactID, String newPhone) {
        Contact contact = getContact(contactID);
        contact.setPhone(newPhone); // This will throw an exception if invalid
    }

    public void updateAddress(String contactID, String newAddress) {
        Contact contact = getContact(contactID);
        contact.setAddress(newAddress); // This will throw an exception if invalid
    }
}



