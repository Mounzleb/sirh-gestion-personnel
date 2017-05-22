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
<body>


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


	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Nouveau collaborateur</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom</label>
				<div class="col-md-4">
					<input id="textinput" name="nom" type="text"
						placeholder="Saisir Votre Nom" class="form-control input-md"
						required="0">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">Prenom</label>
				<div class="col-md-4">
					<input id="textinput" name="prenom" type="text"
						placeholder="Saisir Votre Prenom" class="form-control input-md"
						required="0">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="dateDeNaissance">Date
					de naissance</label>
				<div class="col-md-4">
					<input type="datedenaissance" name="date">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse</label>
				<div class="col-md-4">
					<textarea class="form-control" id="adresse" name="textarea"></textarea>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numSecu">Numéro
					de sécurité sociale</label>
				<div class="col-md-4">
					<input id="numSecu" name="textinput" type="text"
						placeholder="Saisir Votre numero de securite social"
						class="form-control input-md" required="15">

				</div>
			</div>

		</fieldset>
		<button class="btn btn-primary">créer</button>
	</form>



</body>
</html>