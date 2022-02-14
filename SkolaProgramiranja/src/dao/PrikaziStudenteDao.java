package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Smer;
import model.Student;

public class PrikaziStudenteDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public List<Student> vratiSveStudente() {
		
		List<Student> sviStudenti = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String hql = "from Student";
			Query query = session.createQuery(hql);
			sviStudenti = query.getResultList();
			session.getTransaction().commit();
			System.out.println("Uspesno preuzeti studenti");
			return sviStudenti;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u vratiSveStudente()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

	public void dodajStudentaNaSmer(String idStudent, String idSmer) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			Student student = session.get(Student.class, Integer.parseInt(idStudent));
			Smer smer = session.get(Smer.class, Integer.parseInt(idSmer));
			
			student.setSmer(smer);
			session.saveOrUpdate(student);
			session.getTransaction().commit();
			System.out.println("Uspesno dodat student u smer...");
			
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u dodajStudentaNaSmer()! " + e);	
		}finally {
			session.close();
		}
		
	}

}
