package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;


/**
 * Servlet implementation class ListerCollaborateursController
 */
@WebServlet("/collaborateurs/lister")
public class ListerCollaborateursController extends HttpServlet {
	public static final String listerJs = "/WEB-INF/views/collab/listerCollaborateurs.jsp";
	private static final long serialVersionUID = 1L;
	
	// ici on instancié l'objet collabService et departementService grâce à CDI
	// J'injecte une instance de ColaborateurService
	@Inject private CollaborateurService collabService;
	//J'injecte une instance de Departement Service
	@Inject private DepartementService departementService;

	public ListerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		List<Departement> departements = departementService.listerDepartements();
			
		request.setAttribute("collaborateurs", collaborateurs);
		
		request.setAttribute("departements", departements);
		

		request.getRequestDispatcher(listerJs).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
