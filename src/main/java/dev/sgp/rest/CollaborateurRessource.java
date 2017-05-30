package dev.sgp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurRessource {

	@Inject
	private CollaborateurService collabService;

	// *******************************************************************************
	// GET /api/collaborateurs : retourne la liste des collaborateurs au format
	// JSON.
	// *******************************************************************************
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list() {
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		return collaborateurs;
	}

	// ***************************************************************************
	// GET /api/collaborateurs?departement=[ID_DEPARTEMENT] : retourne la liste
	// descollaborateurs au format JSON dont le département a l’identifiant
	// ID_DEPARTEMENT.
	// QueryParam(?parametre=valeur)******************************
	// ***************************************************************************
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Collaborateur> listCollabByDepartementId(
			@QueryParam("departement") @DefaultValue("0") Integer departementId) {

		List<Collaborateur> collaborateurs;

		// *****Si le departementId est différent de 0 appliqué le filtre
		if (departementId != 0) {
			collaborateurs = collabService.collabByDepartementId(departementId);
		}
		// ****sinon afficher la liste des collaborateurs compléte
		else {
			collaborateurs = collabService.listerCollaborateurs();
		}
		return collaborateurs;
	}

	// ***************************************************************************
	// GET /api/collaborateurs/[MATRICULE] : retourne les informations d’un
	// collaborateur.
	// ***************************************************************************
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur leCollabByMatricule(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.collabByMatricule(matricule);

		return collaborateur;
	}

	// ******************************************//***************************************************************************
	// PUT /api/collaborateurs/[MATRICULE] : modifie un collaborateur (données
	// envoyées au format JSON). Les données
	// nom,prenom,adresse,numeroSecuriteSociale ne sont pas modifiables.
	// **********************************************************************************************************************
	@PUT
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur modifierCollaborateur(@PathParam("matricule") String matricule, Collaborateur collab) {

		Collaborateur collaborateur = collabService.changeCollabByMatricule(matricule, collab);
		return collaborateur;
	}

	// *****************************************//***************************************************************************
	// GET /api/collaborateurs/[MATRICULE]/banque : récupère les coordonnées
	// bancaires d’un collaborateur.
	// **********************************************************************************************************************
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> coordonneeBanquair(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.collabByMatricule(matricule);

		Map<String, String> result = new HashMap<>();

		result.put("banque", collaborateur.getBanque());
		result.put("bic", collaborateur.getBic());
		result.put("iban", collaborateur.getIban());

		return result;
	}

	// ***************************************************************************************************************************
	// PUT /api/collaborateurs/[MATRICULE]/banque : modifie uniquement les
	// coordonnées bancaires d’un collaborateur. //
	// **************************************************************************************************************************
	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur modifierInfosBanquaireCollaborateur(@PathParam("matricule") String matricule,
			Collaborateur collab) {

		Collaborateur collaborateur = collabService.changeInfosBanquaireCollab(matricule, collab);
		return collaborateur;
	}

	// *************************************************************************************************
	// Si l’une des données obligatoires (nom,prénom,date de naissance, adresse,
	// numéro de sécurité sociale) est manquante alors un code 400 est retournée
	// avec la liste des champs
	// *************************************************************************************************

	public Response verifierInfosCollaborateur(String matricule, Collaborateur collab) {

		List<String> champsNonRenseigne = new ArrayList<>();

		if (collab.getAdresse().equals(null)) {

			champsNonRenseigne.add("Adresse");
		}

		if (collab.getNom().equals(null)) {

			champsNonRenseigne.add("Nom");
		}

		if (collab.getPrenom().equals(null)) {

			champsNonRenseigne.add("Prenom");
		}
		if (collab.getDateDeNaissance().equals(null)) {

			champsNonRenseigne.add("Date de Naissance");
		}

		if (collab.getNumeroDeSecuSociale().equals(null)) {

			champsNonRenseigne.add("Numéro de Secu");
		}

		if (champsNonRenseigne.isEmpty()) {
			Collaborateur collaborateur = collabService.changeInfosBanquaireCollab(matricule, collab);
			// ici on a la même chose qu'en bas, sauf qu'on a un ok (pour dire
			// un succes donc 200) en valorisant mon objet collaborateur et
			// ensuite on crée l'objet de type response grâce au build()
			return Response.ok().entity(collaborateur).build();
		} else {

			Map<String, List<String>> errors = new HashMap<>();

			errors.put("non_renseigne", champsNonRenseigne);

			// Je m'aapréte à créer un objet de type Response ou je dit que pour
			// ce type de réponse je veux une réponse de type BAD_REQUEST ( donc
			// affiche une erreur 400).
			// Je valorise grpâce à entity(objet) l'objet qu'on veux créer et
			// par la suite je le crée avec build
			// c'est une convention d'ecriture
			return Response.status(Status.BAD_REQUEST).entity(errors).build();
		}

	}
}
