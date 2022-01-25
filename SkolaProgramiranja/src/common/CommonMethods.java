package common;

import model.Address;
import model.Contact;
import model.User;
import model.UserDetails;
import model.UserType;

public class CommonMethods {

	public User popuniUsera(String userName, String password, UserType userType) {
	
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setUserType(userType);
		return user;
	}

	public UserDetails popuniUserDetails(String firstName, String lastName, String email, String mobilePhone,
			String country, String city, String street, User user) {
		
		UserDetails details = new UserDetails();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		details.setFirstName(firstName);
		details.setLastName(lastName);
		details.setUser(user);
		details.setAddress(adresa);
		details.setContact(contact);
		
		return details;
	}

}
