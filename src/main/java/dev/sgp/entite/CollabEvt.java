package dev.sgp.entite;

import java.time.ZonedDateTime;



public class CollabEvt {

	TypeCollabEvt type;
	ZonedDateTime dateHeure;
	String matricule;

	// on ne fait pas de getter setter pour les enumérations
	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public TypeCollabEvt getType() {
		return type;
	}

	public void setType(TypeCollabEvt type) {
		this.type = type;
	}

}
