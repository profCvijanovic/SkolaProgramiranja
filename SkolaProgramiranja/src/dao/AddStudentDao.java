package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;
import model.User;
import model.UserDetails;

public class AddStudentDao {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public boolean ubaciStudenta(User user, UserDetails details, Student student) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.save(details);
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Uspesno upisan student");
			return true;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("NIJE upisan student! " + e);	
			return false;
		}finally {
			session.close();
		}
		
	}
	
	
	

}
