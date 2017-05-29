package dev.sgp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@Path("/collaborateurs")
public class CollaborateurRessource {

	@Inject
	private CollaborateurService collabService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list() {
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		return collaborateurs;
	}

	// *******Trouver les collaborateurs ayant le même id de departement avec Le
	// QueryParam (?parametre=valeur)
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

	// ****** Trouver un collaborateur par son matricule dans le paths
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur leCollabByMatricule(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.collabByMatricule(matricule);

		return collaborateur;
	}

	@PUT
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur modifierCollaborateur(@PathParam("matricule") String matricule, Collaborateur collab) {

		Collaborateur collaborateur = collabService.changeCollabByMatricule(matricule, collab);
		return collaborateur;
	}

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

	@PUT
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur modifierInfosBanquaireCollaborateur(@PathParam("matricule") String matricule,
			Collaborateur collab) {

		Collaborateur collaborateur = collabService.changeInfosBanquaireCollab(matricule, collab);
		return collaborateur;
	}

}
