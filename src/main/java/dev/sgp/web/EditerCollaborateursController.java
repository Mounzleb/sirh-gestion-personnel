package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EditerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String matricule = request.getParameter("matricule");

		
//		response.getWriter().write("<h1>Edite des collaborateurs</h1>"
//
//				+ "<h2> Créer la liste des collaborateurs avec les infos suivantes</h2>"
//				);
		if (matricule == null){
			response.setStatus(400);
			response.getWriter().write("ERROR : un matricule est attendu");
		}else{
			response.getWriter().write("<h1> Edition de collaborateurs </h1>"
             

				+ "<ul>"

				+ "<li>matricule = " + matricule + "</li>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String matricule = request.getParameter("matricule");
		String titre = request.getParameter("titre");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		response.setContentType("text/html");
		
		if (matricule == null || titre == null || nom == null ||prenom == null){
			response.setStatus(400);
		}else{
			response.setStatus(201);
		}

		response.getWriter().write("<h1>Edite des collaborateurs</h1>"

				+ "<h2> Créer la liste des collaborateurs avec les infos suivantes</h2>"              

				+ "<ul>"

				+ "<li>matricule = " + matricule + "</li>"

				+ "<li>titre = " + titre + "</li>"

				+ "<li>nom = " + nom + "</li>"

				+ "<li>prenom = " + prenom + "</li>"

				+ "</ul>");

	}

}
