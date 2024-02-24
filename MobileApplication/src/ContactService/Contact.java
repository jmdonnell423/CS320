package ContactService;



public class Contact {
	
	// contactId is not updatable
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String userId, String nameFirst, String nameLast, String phoneNumber, String newAddress) {
		if(userId == null || userId.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
		else{
			this.contactId = userId;
		}
		setFirstName(nameFirst);
		setLastName(nameLast);
		setPhone(phoneNumber);
		setAddress(newAddress);
	}
	
	public String getContactID() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if(phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid Phone");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }
}
