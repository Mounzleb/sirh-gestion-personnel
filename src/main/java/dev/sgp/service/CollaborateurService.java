
package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {

	@Inject
	Event<CollabEvt> emetteurEvenementCollab;

	// création de la liste de collaborateurs
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	// lister la liste de collaborateur
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	// sauvegarder la liste
	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);

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
