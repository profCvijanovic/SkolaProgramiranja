package service;

import dao.ProfileDao;
import model.UserDetails;

public class ProfileService {
	
	ProfileDao dao = new ProfileDao();

	public UserDetails vratiUserDetailsZaUsera(String idUser) {
		return dao.vratiUserDetailsZaUsera(idUser);
	}

}
