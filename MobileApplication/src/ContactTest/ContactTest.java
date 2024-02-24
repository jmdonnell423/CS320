package ContactTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ContactService.Contact;

	class ContactTest {

		    @Test
		    public void testContactInvalidID() {
		        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("VeryLongContactID", "John", "Doe", "1234567890", "123 Main St"));
		        
		    }

		    @Test
		    public void testContactInvalidFirstName() {
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", null, "Doe", "1234567890", "123 Main St"));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "SuperLongFirstName", "Doe", "1234567890", "123 Main St"));
		    }

		    @Test
		    public void testContactInvalidLastName() {
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", null, "1234567890", "123 Main St"));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "SuperLongLastName", "1234567890", "123 Main St"));
		    }

		    @Test
		    public void testContactInvalidPhone() {
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", null, "123 Main St"));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234", "123 Main St"));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "abcdefghij", "123 Main St"));
		    }

		    @Test
		    public void testContactInvalidAddress() {
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234567890", null));
		        assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234567890", "This address is way too long and should not be valid"));
		    }


	        @Test
	        public void testContactInvalidIDNull() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidIDLength() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("VeryLongContactID", "John", "Doe", "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidFirstNameNull() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", null, "Doe", "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidFirstNameLength() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "SuperLongFirstName", "Doe", "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidLastNameNull() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", null, "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidLastNameLength() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "SuperLongLastName", "1234567890", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidPhoneNull() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", null, "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidPhoneLength() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidPhoneNotAllDigits() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "abcdefghij", "123 Main St"));
	        }

	        @Test
	        public void testContactInvalidAddressNull() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234567890", null));
	        }

	        @Test
	        public void testContactInvalidAddressLength() {
	            assertThrows(IllegalArgumentException.class, () -> new Contact("ID12345678", "John", "Doe", "1234567890", "This address is way too long and should not be valid"));
	        }

	        @Test
	        public void testValidContact() {
	            assertDoesNotThrow(() -> new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St"));
	        }
}
