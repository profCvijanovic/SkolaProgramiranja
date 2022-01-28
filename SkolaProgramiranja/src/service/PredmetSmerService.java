package service;

import common.CommonMethods;
import dao.PredmetSmerDao;
import model.Predmet;

public class PredmetSmerService {
	
	PredmetSmerDao dao = new PredmetSmerDao();
	CommonMethods common = new CommonMethods();

	public Predmet popuniPredmet(String nazivPredmeta, String sifraPredmeta) {
		return common.popuniPredmet(nazivPredmeta,sifraPredmeta);
	}

	public boolean snimiPredmet(Predmet predmet) {
		return dao.snimiPredmet(predmet);
	}

}
