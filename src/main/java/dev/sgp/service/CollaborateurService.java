
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

	// le unit name est le nom de la <persistence-unit name="sgp-pu"> dans le
	// persistance.xml
	@PersistenceContext(unitName = "sgp-pu") private EntityManager em;

	public List<Collaborateur> listerCollaborateurs() {
		
	

		TypedQuery<Collaborateur> query = em.createQuery("Select collabo from Collaborateur collabo",
				Collaborateur.class);
		
		// ici le query.getResultList() recupére nos collaborateur créer et les met dans une liste
		// on remplace ainsi l'utilisation des listes avec List<> (Voir version précédente)
		return query.getResultList();
	}

	// sauvegarder la liste
	public void sauvegarderCollaborateur(Collaborateur collab) {

		em.persist(collab);

		// ****************Création évenement*******************

		// On crée un objet qui est l'evenement qu'on va envoyé dans le bus
		// d'evenement
		CollabEvt evenementCreer = new CollabEvt();

		// on stoque recupére le matricule créer lors de la création d'un
		// collaborateur (de la classe Collaborateur)
		// puis on l'assinue à setMatricule pour changer la valeur du matricule
		// dans CollabEvt
		// et enfin on stock tous ça dans notre évenement evenementCréer
		evenementCreer.setMatricule(collab.getMatricule());
		evenementCreer.setDateHeure(collab.getDateHeureCreation());
		evenementCreer.setType(TypeCollabEvt.CREATION_COLLAB);

		// pour envoyer l'evenement dans le bus

		emetteurEvenementCollab.fire(evenementCreer);
	}

}
