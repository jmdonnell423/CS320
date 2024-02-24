package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {

	private ContactService service;
    private Contact contact;
	    
	    @BeforeEach
	    void setUp() {
	        service = new ContactService();
	        contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
	    }

	    @Test
	    public void testAddValidContact() {
	        service.addContact(contact);
	        assertEquals(contact, service.getContact("ID12345678"));
	    }

	    @Test
	    public void testAddDuplicateContact() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
	    }

	    @Test
	    public void testAddNullContact() {
	        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	    }

	    @Test
	    public void testDeleteContact() {
	        service.addContact(contact);
	        service.deleteContact("ID12345678");
	        assertNull(service.getContact("ID12345678"));
	    }
	    
	    @Test
	    public void testUpdateFirstName() {
	        service.addContact(contact);
	        service.updateFirstName("ID12345678", "Jane");
	        assertEquals("Jane", service.getContact("ID12345678").getFirstName());
	    }

	    @Test
	    public void testUpdateInvalidFirstName() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("ID12345678", "SuperLongFirstName"));
	    }

	    @Test
	    public void testUpdateNonExistentContactFirstName() {
	        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("InvalidID", "Jane"));
	    }

	    @Test
	    public void testUpdateLastName() {
	        service.addContact(contact);
	        service.updateLastName("ID12345678", "Smith");
	        assertEquals("Smith", service.getContact("ID12345678").getLastName());
	    }

	    @Test
	    public void testUpdateInvalidLastName() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("ID12345678", "SuperLongLastName"));
	    }

	    @Test
	    public void testUpdatePhone() {
	        service.addContact(contact);
	        service.updatePhone("ID12345678", "9876543210");
	        assertEquals("9876543210", service.getContact("ID12345678").getPhone());
	    }

	    @Test
	    public void testUpdateInvalidPhoneShort() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ID12345678", "1234"));
	    }

	    @Test
	    public void testUpdateInvalidPhoneNonNumeric() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ID12345678", "123456789a"));
	    }

	    @Test
	    public void testUpdateAddress() {
	        service.addContact(contact);
	        service.updateAddress("ID12345678", "456 High St");
	        assertEquals("456 High St", service.getContact("ID12345678").getAddress());
	    }

	    @Test
	    public void testUpdateInvalidAddress() {
	        service.addContact(contact);
	        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("ID12345678", "This address is way too long and should not be valid"));
	    }
}

