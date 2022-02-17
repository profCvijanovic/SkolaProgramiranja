package service;

import java.util.List;

import dao.ProfesorDao;
import dao.ProfileDao;
import model.PolozeniIspiti;
import model.Predmet;
import model.Profesor;
import model.Smer;
import model.Student;
import model.UserDetails;

public class ProfesorService {
	
	ProfesorDao dao = new ProfesorDao();
	ProfileDao pDao = new ProfileDao();

	public Profesor vratiProfesoraPoId(int idUserDeatils) {
		return dao.vratiProfesoraPoId(idUserDeatils);
	}

	public UserDetails vratiUserDetailsZaUsera(String idUser) {
		return pDao.vratiUserDetailsZaUsera(idUser);
	}

	public List<Smer> vratiSveSmerovePredmeta(String idPredmeta) {
		return dao.vratiSveSmerovePredmeta(idPredmeta);
	}

	public List<Student> vratiSveStudenteSmerova(List<Smer> smeroviPredmeta) {
		return dao.vratiSveStudenteSmerova(smeroviPredmeta);
	}

	public Predmet vratiPredmetPoId(String idPredmeta) {
		return dao.vratiPredmetPoId(idPredmeta);
	}

	public void upisiOcenu(int predmetId, int studentId, int ocena) {
		dao.upisiOcenu(predmetId, studentId, ocena);
		
	}

	public List<PolozeniIspiti> vratiPolozeneIspite() {
		return dao.vratiPolozeneIspite();
	}

}
