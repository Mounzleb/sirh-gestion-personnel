package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class VisiteWebController
 */
@WebServlet("/VisiteWebController")
public class VisiteWebController extends HttpServlet {
	public static final String visiteurJs = "/WEB-INF/views/collab/visteWeb.jsp";
	private static final long serialVersionUID = 1L;
	private VisiteWebService visiteWebService = Constantes.VISITE_WEB_SERVICE;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisiteWebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VisiteWeb> visiteurWeb = visiteWebService.listerVisiteurWeb();
	
			
		request.setAttribute("visiteurs", visiteurWeb);

		request.getRequestDispatcher(visiteurJs).forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
