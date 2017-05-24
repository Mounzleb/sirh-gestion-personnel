package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.service.ActiveService;

/**
 * Servlet implementation class ActiviteController
 */
@WebServlet("/ActiviteController/activite")
public class ActiviteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Inject private ActiveService activite;
     @Inject private CollabEvt evt;
	
     
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<CollabEvt> evenementActivite =  activite.listerActiviterCollab();
		
		request.setAttribute("activites", evenementActivite);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
