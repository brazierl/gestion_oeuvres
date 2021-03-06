<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="0;URL=javascript:fermer();">
    <title>Expo : Médiathèque De POLYTECH</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="css/bootstrap-datepicker3.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>

<body>
<div class="container header">
    <h1 class="bold">
        Gestion des Oeuvres
    </h1>
</div>
<div class="container">
    <ul class="nav nav-tabs nav-justified">
        <li role="presentation">
            <a href="/">Accueil</a>
        </li>
        <li role="presentation">
            <a href="ControleurOeuvres?action=ajouterOeuvre">Ajouter une Oeuvre</a>
        </li>
        <li role="presentation">
            <a href="ControleurOeuvres?action=consulterCatalogue">Consulter le catalogue</a>
        </li>
        <li role="presentation">
            <a href="ControleurReservations?action=confirmerReservations">Confirmer les réservations</a>
        </li>
        <li role="presentation">
            <a href="">Connexion</a>
        </li>
    </ul>
</div>
<div id="messages" class="container">
    <c:forEach items="${mesInfos}" var="item">
        <div class="alert alert-success message" role="alert">
            ${item}
        </div>
    </c:forEach>
    <c:forEach items="${mesErreurs}" var="item">
        <div class="alert alert-danger message" role="alert">
            ${item}
        </div>
    </c:forEach>
</div>
