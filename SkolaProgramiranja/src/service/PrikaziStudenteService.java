package service;

import java.util.List;

import dao.PredmetSmerDao;
import dao.PrikaziStudenteDao;
import model.Smer;
import model.Student;

public class PrikaziStudenteService {

	PrikaziStudenteDao dao = new PrikaziStudenteDao();
	PredmetSmerDao psDao = new PredmetSmerDao();
	
	public List<Student> vratiSveStudente() {
		
		return dao.vratiSveStudente();
	}

	public List<Smer> vratiSveSmerove() {
		return psDao.vratiSveSmerove();
	}

	public void dodajStudentaNaSmer(String idStudent, String idSmer) {
		dao.dodajStudentaNaSmer(idStudent, idSmer);
	}
}
