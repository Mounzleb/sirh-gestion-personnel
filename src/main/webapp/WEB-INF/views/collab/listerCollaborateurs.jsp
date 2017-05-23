<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.js">
<title>SGP - liste collaborateur</title>
</head>

<body class="container">

	<h2>Les collaborateurs :</h2>

	<br>
	<br>
	<br>

	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Recherche</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="searchNomPrenom">Rechercher
					un nom ou un prénom qui commence par: </label>
				<div class="col-md-2">
					<input id="searchNomPrenom" name="searchNomPrenom" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="depSearch">Filtrer
					par département :</label>
				<div class="col-md-2">
					<select id="depSearch" name="depSearch" class="form-control">
					
					<option value="0">Tous</option>
					
					
						<%						
						List<Departement> departements = (List<Departement>) request.getAttribute("departements");
						
						for (Departement dept : departements) {
						
						%>
			
						<option value="2"><%=dept.getNom()%></option>
						
						
						<%
							}
						%>
						
					</select>
				</div>
			</div>

			<!-- Multiple Checkboxes (inline) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="checkboxes">Voir
					les collaborateurs désactivé :</label>
				<div class="col-md-4">
					<label class="checkbox-inline" for="checkboxes-0"> <input
						type="checkbox" name="checkboxes" id="checkboxes-0" value="1">

					</label>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="search"></label>
				<div class="col-md-4">
					<button id="search" name="search" class="btn btn-primary">Rechercher</button>
				</div>
			</div>

		</fieldset>
	</form>

	<br>
	<br>
	<br>

<!-- Buttons Pour aller sur la pager nouveau collaborateur -->
	<a href="<%=request.getContextPath()%>/collaborateurs/nouveau" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span>nouveau</a>
	<br>
	<br>
	<h3>Liste des collaborateur :</h3>
	<br>
	<div class="jumbotron row ">

		<%
			
		List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
			for (Collaborateur collab : collaborateurs) {
		%>

		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">

			<ul>
				<li>Matricule : <%=collab.getMatricule()%> <br> Nom : <%=collab.getNom()%><br>
					Prenom : <%=collab.getPrenom()%><br> Date de Naissance : <%=collab.getDateDeNaissance()%><br>
					Adresse : <%=collab.getAdresse()%><br>Email professionel : <%=collab.getEmailPro()%><br> actif ? : <%=collab.isActif()%><br>
					<br> <br>
				</li>
				<a href="" class="btn btn-xs btn-warning pull-right"><span
					class="glyphicon glyphicon-pencil"></span> Modifier</a>
			</ul>

		</div>

		<%
			}
		%>

	</div>

</body>

</html>