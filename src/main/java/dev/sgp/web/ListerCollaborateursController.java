package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class ListerCollaborateursController
 */

public class ListerCollaborateursController extends HttpServlet {
	public static final String fichierJs = "/WEB-INF/views/collab/listerCollaborateurs.jsp";
	private static final long serialVersionUID = 1L;
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	public ListerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ici je crée un objet collaborateur

				// ici opn Recupére les saisie des input dans le fichier.js en
				// fonctionde name de leur id


				// je sauvegarde mon nouveau collaborateur qu'on a créer
			
		request.setAttribute("collaborateur", collabService.listerCollaborateurs());

		request.getRequestDispatcher(fichierJs).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ici je crée un objet collaborateur
		Collaborateur newCollab = new Collaborateur();

		// ici opn Recupére les saisie des input dans le fichier.js en
		// fonctionde name de leur id
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		LocalDate dateDeNaissance = LocalDate.parse("dateDeNaissance");
		String adresse = request.getParameter("adresse");
		
//		String emailPro =prenom + nom + "@societe.com";
		
		
		newCollab.setNom(nom);
		newCollab.setPrenom(prenom);
		newCollab.setAdresse(adresse);
		newCollab.setDateDeNaissance(dateDeNaissance);
	

		// je sauvegarde mon nouveau collaborateur qu'on a créer
		collabService.sauvegarderCollaborateur(newCollab);

		// j'envoi ma lise de collaborateurs à la jsp
		request.setAttribute("collaborateur", collabService.listerCollaborateurs());

		doGet(request, response);
	}

}
