package common;

import model.Address;
import model.Contact;
import model.Profesor;
import model.Student;
import model.User;
import model.UserType;

public class CommonMethods {

	public User popuniUsera(String userName, String password, UserType userType) {
	
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setUserType(userType);
		return user;
	}

	public Student popuniStudent(String firstName, String lastName, String email, String mobilePhone,
			String country, String city, String street, User user, String indexNo) {
		
		Student student = new Student();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setUser(user);
		student.setIndexNo(indexNo);
		student.setAddress(adresa);
		student.setContact(contact);
		
		return student;
	}

	public Profesor popuniProfesor(String firstName, String lastName, String email, String mobilePhone, String country,
			String city, String street, User user, String identificationNo) {
		
		Profesor profesor = new Profesor();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		profesor.setFirstName(firstName);
		profesor.setLastName(lastName);
		profesor.setUser(user);
		profesor.setIdentificationNo(identificationNo);
		profesor.setAddress(adresa);
		profesor.setContact(contact);
		
		return profesor;
	}

}
