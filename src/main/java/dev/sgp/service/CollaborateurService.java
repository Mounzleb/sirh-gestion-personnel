
package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {

	@Inject
	Event<CollabEvt> emetteurEvenementCollab;

	// le unitName: nom de la <persistence-unit name="sgp-pu"> dans le
	// persistance.xml
	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	public List<Collaborateur> listerCollaborateurs() {

		TypedQuery<Collaborateur> query = em.createQuery("Select collabo from Collaborateur collabo",
				Collaborateur.class);

		return query.getResultList();
	}

	// sauvegarder la liste
	public void sauvegarderCollaborateur(Collaborateur collab) {

		em.persist(collab);

		// ****************Création évenement*******************

		// objet evenement qui va être envoyé dans le bus d'evenements
		CollabEvt evenementCreer = new CollabEvt();

		evenementCreer.setMatricule(collab.getMatricule());
		evenementCreer.setDateHeure(collab.getDateHeureCreation());
		evenementCreer.setType(TypeCollabEvt.CREATION_COLLAB);

		// Envoie de l'evenement dans le bus
		emetteurEvenementCollab.fire(evenementCreer);
	}

	// Chercher les colaborateurs par l'id de leurs departements la base de
	// donné
	public List<Collaborateur> collabByDepartementId(Integer departementId) {

		TypedQuery<Collaborateur> query = em.createQuery("Select c from Collaborateur c where c.departement.id=:id",
				Collaborateur.class);

		query.setParameter("id", departementId);

		return query.getResultList();
	}

	// Chercher le colaborateur par son matricule dans la base de donnée
	public Collaborateur collabByMatricule(String matricule) {

		return em.find(Collaborateur.class, matricule);
	}

	public Collaborateur changeCollabByMatricule(String matricule, Collaborateur collab) {
		// **** le collab sera le nouveau collaborateur aprés la modification

		// le colaborateur ici est celui qui est dans la base de donnée
		Collaborateur collaborateur = collabByMatricule(matricule);

		if (collaborateur != null) {

			collaborateur.setEmailPro(collab.getEmailPro());
			collaborateur.setDateDeNaissance(collab.getDateDeNaissance());
			collaborateur.setAdresse(collab.getAdresse());

//			CollabEvt collaboModifier = new CollabEvt();
//
//			collaboModifier.setMatricule(collab.getMatricule());
//			collaboModifier.setDateHeure(collab.getDateHeureCreation());
//			collaboModifier.setType(TypeCollabEvt.MODIFICATION_COLLAB);
		}

		return collaborateur;
	}

}
