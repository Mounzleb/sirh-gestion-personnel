package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departement {

	@Id
	private Integer id;
	private String nom;

	public Departement() {

	}

	public Departement(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}