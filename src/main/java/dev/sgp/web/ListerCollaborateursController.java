package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListerCollaborateursController
 */

public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ListerCollaborateursController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// récupère la valeur d'un paramètre dont le nom est avecPhoto
		String avecPhtoParam = request.getParameter("avecPhoto");
		
		// récupère la valeur d'un paramètre dont le nom est departement
		String departementParam = request.getParameter("departement");
		
		response.setContentType("text/html");
		
		response.getWriter().write("<h1>Hello les amis, c'est partie pour JEE</h1>"
				+ "<ul>"
				+"<li>avecPhoto = " + avecPhtoParam + "</li>"
				+ "<li>departement = "+ departementParam + "</li>"
				+ "</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
