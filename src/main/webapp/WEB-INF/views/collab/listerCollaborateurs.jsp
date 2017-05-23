<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body class=""container>
<!-- ici c'est pour récupérer la liste des collaborateur qu'on a exporter avec le setAttribute dans le ListerCollaborateursController -->
	<div>
		<ul>

			<%
				List<Collaborateur> listeCollaborateurs = (List<Collaborateur>) request.getAttribute("collaborateur");

				for (Collaborateur newCollab : listeCollaborateurs) {
			%>

			<li><%=newCollab.getNom()%></li>

			<%
				}
			%>

		</ul>
	</div>


<a href="<%=request.getContextPath()%>/collaborateurs/nouveau" class="btn btn -lg btn-primary">Nouveau Collaborateur</a>

</body>
</html>