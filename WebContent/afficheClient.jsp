<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Affichage d'un client</title>
  <link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
<c:import url="/inc/menu.jsp"></c:import>
<p class="info">${resultat }</p>
<p>Nom: <c:out value="${client.nom}"/></p>
<p>Prénom: <c:out value="${client.prenom }"/></p>
<p>Adresse: <c:out value="${client.adresse_livraison }"/></p>
<p>Tel: <c:out value="${client.num_tel }"/></p>
<p>Email: <c:out value="${client.email}"/></p>
</body>
</html>