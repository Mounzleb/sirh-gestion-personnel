package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class NouveauCollaborateurController extends HttpServlet {
	public static final String nouveauJs = "/WEB-INF/views/collab/nouveauCollaborateur.jsp";
	private static final long serialVersionUID = 1L;
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	public NouveauCollaborateurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("erreur", 0);
		request.getRequestDispatcher(nouveauJs).forward(request, response);
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
		String numsecu = request.getParameter("numsecu");

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String suffixe = bundle.getString("suffixe.email");

		// gérer un matricule
		String matricule = UUID.randomUUID().toString();

		String emailPro = prenom + "." + nom + suffixe;

		newCollab.setMatricule(matricule);
		newCollab.setNom(nom);
		newCollab.setPrenom(prenom);
		newCollab.setDateDeNaissance(dateDeNaissance);
		newCollab.setAdresse(adresse);
		newCollab.setNumeroDeSecuSociale(numsecu);
		newCollab.setEmailPro(emailPro);
		newCollab.setActif(true);
		// newCollab.setDateHeureCreation(dateHeureCreation);

		Map<Boolean, List<String>> validationParams = validerParametres(request, "nom", "prenom", "adresse", "numsecu");

		if (validationParams.get(false) != null || numsecu.length() < 15) {
			response.setStatus(400);

			request.setAttribute("erreur", 1);

			// response.getWriter().append("<p class=\"alert alert-danger\">Les
			// champs suivants sont manquants : " +
			// validationParams.get(false).stream().collect(Collectors.joining(","))
			// + " </p>");

			String errorMessage = "";

			if (validationParams.get(false) != null) {
				errorMessage = "Les champs suivants sont menquants : "
						+ validationParams.get(false).stream().collect(Collectors.joining(","));
			}

			if (numsecu.length() < 15) {
				errorMessage += " Et numero de sécu incorrect (15 charac) !";
			}

			request.setAttribute("errorMessage", errorMessage);

			request.getRequestDispatcher("/WEB-INF/views/collab/nouveau.jsp").forward(request, response);
		} else {
			response.setStatus(201);

			response.getWriter()
					.write("Création d'un collaborateur avec les informations suivantes : " + validationParams.get(true)
							.stream().map(p -> p + "=" + request.getParameter(p)).collect(Collectors.joining(",")));

			collabService.sauvegarderCollaborateur(newCollab);

			response.sendRedirect(request.getContextPath() + "/collaborateurs/lister");
		}

		// je sauvegarde mon nouveau collaborateur qu'on a créer
		collabService.sauvegarderCollaborateur(newCollab);

		request.setAttribute("collaborateurs", collabService.listerCollaborateurs());

		doGet(request, response);
	}

	private Map<Boolean, List<String>> validerParametres(HttpServletRequest req, String... params) {
		return Stream.of(params).collect(
				Collectors.groupingBy(param -> req.getParameter(param) != null && !"".equals(req.getParameter(param))));
	}
}
