package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.PolozeniIspiti;
import model.Predmet;
import model.Profesor;
import model.Smer;
import model.Student;
import model.User;
import model.UserDetails;

public class ProfesorDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public Profesor vratiProfesoraPoId(int idUserDetails) {
		
		Profesor p = new Profesor();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			p = session.get(Profesor.class, idUserDetails);
			Hibernate.initialize(p.getPredmentiKojePredaje());
			session.getTransaction().commit();
			System.out.println("Uspesno vracen profa...");
			return p;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi vratiProfesoraPoId()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

	public List<Smer> vratiSveSmerovePredmeta(String idPredmeta) {
		
		Predmet p = new Predmet();
		List<Smer> smerovi = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			p = session.get(Predmet.class, Integer.parseInt(idPredmeta));
			Hibernate.initialize(p.getSmeroviNaKojimaJePredmet());
			smerovi = p.getSmeroviNaKojimaJePredmet();
			session.getTransaction().commit();
			System.out.println("Uspesno vracena lista smerova...");
			return smerovi;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi vratiSveSmerovePredmeta()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

	public List<Student> vratiSveStudenteSmerova(List<Smer> smeroviPredmeta) {
		
		List<Student> studenti = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			String hql = "from Student where smer in (:listaSmerova)";
			Query query = session.createQuery(hql);
				query.setParameter("listaSmerova", smeroviPredmeta);
			studenti = query.getResultList();
			session.getTransaction().commit();
			System.out.println("Uspesno vracena lista studenata...");
			return studenti;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi vratiSveStudenteSmerova()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

	public Predmet vratiPredmetPoId(String idPredmeta) {
	
		Predmet p = new Predmet();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			p = session.get(Predmet.class, Integer.parseInt(idPredmeta));
			session.getTransaction().commit();
			System.out.println("Uspesno vracen predmet...");
			return p;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi vratiPredmetPoId()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

	public void upisiOcenu(int predmetId, int studentId, int ocena) {
		
		Predmet predmet = new Predmet();
		Student student = new Student();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			predmet = session.get(Predmet.class, predmetId);
			student = session.get(Student.class, studentId);
			
			PolozeniIspiti polozeniIspiti = new PolozeniIspiti();
				polozeniIspiti.setPredmet(predmet);
				polozeniIspiti.setStudent(student);
				polozeniIspiti.setOcena(ocena);
				polozeniIspiti.setDatumPolaganja(new Date());
			
			session.save(polozeniIspiti);
			session.getTransaction().commit();
			System.out.println("Uspesno upisana ocena...");
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi upisiOcenu()! " + e);	
		}finally {
			session.close();
		}
		
	}

	public List<PolozeniIspiti> vratiPolozeneIspite() {
		
		List<PolozeniIspiti> polozeniIspiti = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {	
			String hql = "from PolozeniIspiti";
			Query query = session.createQuery(hql);
			polozeniIspiti = query.getResultList();
			session.getTransaction().commit();
			System.out.println("Uspesno vracena lista polozenih ispita...");
			return polozeniIspiti;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Problem u metodi vratiPolozeneIspite()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}
}
