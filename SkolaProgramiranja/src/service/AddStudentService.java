package service;

import common.CommonMethods;
import dao.AddStudentDao;
import model.Profesor;
import model.Student;
import model.User;
import model.UserType;

public class AddStudentService {
	
	AddStudentDao dao = new AddStudentDao();
	CommonMethods common = new CommonMethods();
	
	public User popuniUsera(String userName, String password, UserType userType) {
		return common.popuniUsera(userName,password, userType);
	}

	public Student popuniStudent(String firstName, String lastName, String email, String mobilePhone,
			String country, String city, String street, User user,  String indexNo) {
		return common.popuniStudent(firstName, lastName, email, mobilePhone, country, city, street, user, indexNo);
	}

	public boolean ubaciStudenta(User user, Student student) {
		return dao.ubaciStudenta(user, student);
	}

	public Profesor popuniProfesor(String firstName, String lastName, String email, String mobilePhone, String country,
			String city, String street, User user, String identificationNo) {
		return common.popuniProfesor(firstName, lastName, email, mobilePhone, country, city, street, user, identificationNo);
	}

	public boolean ubaciProfesora(User user, Profesor profesor) {
		return dao.ubaciProfesora(user, profesor);
	}

}
