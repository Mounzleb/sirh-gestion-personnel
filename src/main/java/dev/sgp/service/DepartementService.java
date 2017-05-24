package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {
	
	@PersistenceContext(unitName = "sgp-pu") private EntityManager em;
	
	List<Departement> listeDepartements = new ArrayList<>();
	
	public DepartementService() {
		super();
		
	}
	
	public List<Departement> listerDepartements() {
		
		
		TypedQuery<Departement> query = em.createQuery("Select depart from Departement depart",
				Departement.class);
		
		return query.getResultList();

	}
	
	
	public void sauvegarderDepartement(Departement departement) {
	
		em.persist(departement);
	}
	
}