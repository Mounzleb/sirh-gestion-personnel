package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.Departement;


@ApplicationScoped
public class DepartementService {
	
	List<Departement> listeDepartements = new ArrayList<>();
	
	public DepartementService() {
		super();
		
		Departement dpt1 = new Departement();
		Departement dpt2 = new Departement();
		Departement dpt3 = new Departement();
		Departement dpt4 = new Departement();
		
		dpt1.setId(1);
		dpt1.setNom("Comptabilité");
		
		dpt2.setId(2);
		dpt2.setNom("Ressources Humaines");
		
		dpt3.setId(3);
		dpt3.setNom("Informatique");
		
		dpt4.setId(4);
		dpt4.setNom("Administratif");
		
		listeDepartements.add(dpt1);
		listeDepartements.add(dpt2);
		listeDepartements.add(dpt3);
		listeDepartements.add(dpt4);
		
		
		
		//this.listeDepartements = listeDepartements;
	}
	
	public List<Departement> listerDepartements() {
		
		return listeDepartements;

	}
	
}