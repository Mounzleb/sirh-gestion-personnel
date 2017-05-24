<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/js/bootstrap.js'></c:url>">
<title>SGP - Activites</title>
</head>
<body class="container">
		
		<h1>Activités depuis le démarage de l'application</h1>
		
		<br>
		<br>
		<br>
		
		<a href="lister" class="btn btn-primary"><span
		class="glyphicon glyphicon-arrow-left"></span> retour</a>
		
		<br>
		<br>
		<br>
		
		<table class="table table-striped">
		<thead>
			<tr>
				<th>Date/Heure</th>
				<th>Type</th>
				<th>Matricule</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="activite" items="${evenementActivite}">
				<tr>
					<td>${activite.dateHeure}</td>
					<td>${activite.type}</td> 
					<td>${activite.matricule }</td> 
				</tr>
			</c:forEach>
		</tbody>


	</table>
		
	</body>
</html>