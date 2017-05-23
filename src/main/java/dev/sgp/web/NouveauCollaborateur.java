package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class NouveauCollaborateur
 */
@WebServlet("/NouveauCollaborateur")
public class NouveauCollaborateur extends HttpServlet {
	public static final String nouveauJs = "/WEB-INF/views/collab/nouveauCollaborateur.jsp";
	private static final long serialVersionUID = 1L;
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	public NouveauCollaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(nouveauJs).forward(request, response);		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ici je crée un objet collaborateur
		Collaborateur newCollab = new Collaborateur();

		// ici opn Recupére les saisie des input dans le fichier.js en
		// fonctionde name de leur id
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		LocalDate dateDeNaissance = LocalDate.parse("date");
		String adresse = request.getParameter("adresse");
		String matricule = UUID.randomUUID().toString();

		newCollab.setNom(nom);
		newCollab.setPrenom(prenom);
		newCollab.setAdresse(adresse);
		newCollab.setDateDeNaissance(dateDeNaissance);
		newCollab.setMatricule(matricule);

		// je sauvegarde mon nouveau collaborateur qu'on a créer
		collabService.sauvegarderCollaborateur(newCollab);
		
		request.setAttribute("collaborateur", collabService.listerCollaborateurs());

		doGet(request, response);
	}

}
