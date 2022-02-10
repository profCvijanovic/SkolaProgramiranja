package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class ProfileDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public UserDetails vratiUserDetailsZaUsera(String idUser) {
		
		UserDetails detalj = new UserDetails();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			User user = session.get(User.class, Integer.parseInt(idUser));
			String hql = "from UserDetails where user = :user";
			Query query = session.createQuery(hql);
			query.setParameter("user", user);
			
			detalj = (UserDetails)query.getSingleResult();
			
			session.getTransaction().commit();
			System.out.println("Uspesno vracen detalj");
			return detalj;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Nesto nije u redu u vratiUserDetailsZaUsera()! " + e);	
			return null;
		}finally {
			session.close();
		}
	}

}
