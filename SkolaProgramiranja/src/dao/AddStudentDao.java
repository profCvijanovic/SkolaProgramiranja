package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Administrator;
import model.Profesor;
import model.Student;
import model.User;

public class AddStudentDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public boolean ubaciStudenta(User user, Student student) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(user);
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

	public boolean ubaciProfesora(User user, Profesor profesor) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.save(profesor);
			session.getTransaction().commit();
			System.out.println("Uspesno upisan profesor");
			return true;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("NIJE upisan profesor! " + e);	
			return false;
		}finally {
			session.close();
		}
	}

	public boolean ubaciAdministrator(User user, Administrator administrator) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.save(administrator);
			session.getTransaction().commit();
			System.out.println("Uspesno upisan administrator");
			return true;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("NIJE upisan administrator! " + e);	
			return false;
		}finally {
			session.close();
		}
	}
	
	
	

}
