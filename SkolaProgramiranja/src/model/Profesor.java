package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends UserDetails {

	private String identificationNo;
	@OneToMany
	private List<Predmet> predmentiKojePredaje = new ArrayList<Predmet>();
	
	public String getIdentificationNo() {
		return identificationNo;
	}
	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}
	public List<Predmet> getPredmentiKojePredaje() {
		return predmentiKojePredaje;
	}
	public void setPredmentiKojePredaje(List<Predmet> predmentiKojePredaje) {
		this.predmentiKojePredaje = predmentiKojePredaje;
	}
	
	
}
