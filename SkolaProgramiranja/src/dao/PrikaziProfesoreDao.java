package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import wrapper.ProfesorWrapper;

public class PrikaziProfesoreDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public List<ProfesorWrapper> vratiSveProfesore() {
		
		List<ProfesorWrapper> listaProfesora = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String sql = "select ud.idUserDetails,\r\n" + 
					"       u.userName,\r\n" + 
					"       u.password,\r\n" + 
					"       ud.firstName,\r\n" + 
					"       ud.lastName,\r\n" + 
					"       ud.email,\r\n" + 
					"       ud.mobilePhone,\r\n" + 
					"       ud.country,\r\n" + 
					"       ud.city,\r\n" + 
					"       ud.street,\r\n" + 
					"       p.identificationNo\r\n" + 
					"from user u\r\n" + 
					"inner join userdetails ud on ud.user_idUser = u.idUser\r\n" + 
					"inner join profesor p on p.idUserDetails = ud.idUserDetails";
			
			Query query = session.createNativeQuery(sql);
			List<Object[]> resultList = query.getResultList();
			
			for(Object[] o: resultList) {
				
				ProfesorWrapper profesor = new ProfesorWrapper();
				
				if(o[0] != null) {profesor.setIdProfesor((int)o[0]);}
				if(o[1] != null) {profesor.setUserName((String)o[1]);}
				if(o[2] != null) {profesor.setPassword((String)o[2]);}
				if(o[3] != null) {profesor.setFirstName((String)o[3]);}
				if(o[4] != null) {profesor.setLastName((String)o[4]);}
				if(o[5] != null) {profesor.setEmail((String)o[5]);}
				if(o[6] != null) {profesor.setMobilePhone((String)o[6]);}
				if(o[7] != null) {profesor.setCountry((String)o[7]);}
				if(o[8] != null) {profesor.setCity((String)o[8]);}
				if(o[9] != null) {profesor.setStreet((String)o[9]);}
				if(o[10] != null) {profesor.setIdentificationNo((String)o[10]);}
				
				listaProfesora.add(profesor);
			}
			
			session.getTransaction().commit();
			System.out.println("Uspesno vracena lista profesora");
			return listaProfesora;
		} catch (Exception e) {		
			session.getTransaction().rollback();
			System.out.println("Nesto nije u redu u vratiSveProfesore! " + e);
			return null;
		}finally {
			session.close();
		}
		
	}

}
