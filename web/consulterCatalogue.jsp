<%--
  Created by IntelliJ IDEA.
  User: Louis
  Date: 25/02/2017
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulter le catalogue</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Consulter le catalogue </H1>
    <div>
        <table class="table table-striped">
            <tr>
                <th>Numéro de l'oeuvre</th>
                <th>Titre de l'oeuvre</th>
                <th>Propriétaire</th>
                <th>Réserver/Modifier</th>
            </tr>
            <c:forEach items="${mesOeuvres}" var="item">
                <tr>
                    <td>${item.idOeuvrepret}</td>
                    <td>${item.titreOeuvrepret}</td>
                    <td>${item.proprietaire.prenomProprietaire} ${item.proprietaire.nomProprietaire}</td>
                    <td>
                        <a class="btn btn-primary btn-sm" type="button" href="ControleurOeuvres?reserverOeuvre"><span class="glyphicon glyphicon-ok"></span></a>
                        <a class="btn btn-success btn-sm" type="button" href="ControleurOeuvres?modifierOeuvre"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
