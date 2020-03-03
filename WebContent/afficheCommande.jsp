<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Affichage d'une commande</title>
 <link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
<c:import url="/inc/menu.jsp"></c:import>
<p class="info">${resultat }</p>
<p>Client</p>
<p>Nom :<c:out value="${commande.client.nom}"/></p>
<p>Prénom: <c:out value="${commande.client.prenom }"/></p>
<p>Adresse: <c:out value="${commande.client.adresse_livraison }"/></p>
<p>Tel: <c:out value="${commande.client.num_tel }"/></p>
<p>Email: <c:out value="${commande.client.email}"/></p>
<p>Commande </p>
<p>Date: <c:out value="${commande.date}"/></p>
<p>Montant: <c:out value="${commande.montant}"/></p>
<p>Mode de paiment: <c:out value="${commande.mode_paiment }"/></p>
<p>Statut de paiment: <c:out value="${commande.statut_paiment }"/></p>
<p>Mode de livraison: <c:out value="${commande.mode_livraison }"/></p>
<p>Statut de livraison: <c:out value="${commande.statut_livraison}"/></p>
</body>
</html>