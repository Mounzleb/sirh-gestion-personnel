package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/collaborateurs/editer")
public class EditerCollaborateursController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String matriculeParam = request.getParameter("matricule");

		if (matriculeParam == null || "".equals(matriculeParam.trim())) {
			response.setStatus(400);
			response.getWriter().write("Un matricule est attendu");
		} else {
			response.setContentType("text/html");
			response.getWriter().write("<h1>Edition de collaborateur</h1> Matricule : " + matriculeParam);
		}

		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Boolean, List<String>> validationParams = validerParametres(request, "matricule","titre", "nom", "prenom");
		
		response.setCharacterEncoding("utf-8");
		
		if (validationParams.get(false) != null) {
			response.setStatus(400);
			
			response.getWriter().write("Les paramètres suivants sont incorrects : " + validationParams.get(false).stream().collect(joining(",")));
		} else {
			response.setStatus(201);
			
			response.getWriter().write("Création d'un collaborateur avec les informations suivantes : " 
				+ validationParams.get(true).stream().map(p -> p + "=" + request.getParameter(p)).collect(joining(",")));
		}
		
	}
	
	private Map<Boolean, List<String>> validerParametres(HttpServletRequest request, String... params) {
		return Stream.of(params).collect(
				groupingBy(
						param -> request.getParameter(param) != null && !"".equals(request.getParameter(param)
				)));
	}
}
