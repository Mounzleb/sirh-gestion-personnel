package dev.sgp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Collaborateur> listCollabByDepartementId(
			@QueryParam("departement") @DefaultValue("0") Integer departementId) {

		List<Collaborateur> collaborateurs;

		if (departementId != 0) {
			collaborateurs = collabService.collabByDepartementId(departementId);
		} else {
			collaborateurs = collabService.listerCollaborateurs();
		}
		return collaborateurs;
	}

	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur listCollabByMatricule(@PathParam("matricule") String matricule) {

		Collaborateur collaborateur = collabService.collabByMatricule(matricule);

		return collaborateur;
	}

}
