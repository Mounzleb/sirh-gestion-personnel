package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	List<Departement> listeDepartements = new ArrayList<>();

	public DepartementService() {
		super();

	}

	public List<Departement> listerDepartements() {

		TypedQuery<Departement> query = em.createQuery("Select depart from Departement depart", Departement.class);

		return query.getResultList();

	}

	public void sauvegarderDepartement(Departement departement) {

		em.persist(departement);
	}

	public Departement getDepartement(Integer id) {
		
		// avec depart.id=:id je crée une variable id
		TypedQuery<Departement> query = em.createQuery("Select depart from Departement depart where depart.id=:id",
				Departement.class);
		// la variable que j'ai créé je lui assinue ma variable id que j'ai en
		// parametre de ma fonction getDepartement
		query.setParameter("id", id);
		
		return query.getResultList().get(0);
	}

}