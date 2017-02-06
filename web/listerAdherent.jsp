<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Affichage de tous les adhérents</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <p>
        <A class="btn btn-secondary" href="index.jsp" role="button">
            <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span> Retour Accueil
        </A>
    </p>

    <h1>Listing des Adhérents</h1>

    <TABLE class="table table-striped">
        <h3>Tableau des Adhérents</h3>
        <TR>
            <TH>Numero</TH>
            <TH>Nom</TH>
            <TH>Prénom</TH>
            <TH>Ville</TH>
        </TR>
        <c:forEach items="${mesAdherents}" var="item">
            <tr>
                <td>${item.idAdherent}</td>
                <td>${item.nomAdherent}</td>
                <td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
            </tr>
        </c:forEach>
    </TABLE>
</div>
<jsp:include page="footer.jsp"/>
</body>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
</html>