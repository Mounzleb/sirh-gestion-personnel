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
	public static final String listerJs = "/WEB-INF/views/collab/listerCollaborateurs.jsp";
	private static final long serialVersionUID = 1L;
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	public ListerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

				// je sauvegarde mon nouveau collaborateur qu'on a créer
			
		request.setAttribute("collaborateur", collabService.listerCollaborateurs());

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
