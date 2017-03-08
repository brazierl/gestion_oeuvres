<%--
  Created by IntelliJ IDEA.
  User: Louis
  Date: 26/02/2017
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Réserver une Oeuvre</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Réserver une oeuvre </H1>
    <form name='identification' method="post" action="Controleur?action=insererAdherent">
        <div class="form-group">
            <label for="titre" class="control-label">
               Titre de l'oeuvre :
            </label>
            <input type="text" name="txttitre" value="${monOeuvre.titreOeuvrevente}" id="titre" class="form-control" readonly></inupt>
            <inupt type="hidden" id="idOeuvre" value="${monOeuvre.idOeuvrevente}"></inupt>
        </div>
        <div class="form-group">
            <label for="prix" class="control-label">
                Prix :
            </label>
            <input type="text" name="txtprix" value="${monOeuvre.prixOeuvrevente}" id="prix" class="form-control" readonly></inupt>
        </div>
        <div class="form-group">
            <label for="date" class="control-label">
                Date :
            </label>
            <input type="text" name="txtdate" id="date" class="form-control" placeholder="yyyy-mm-jj"></inupt>
        </div>
        <div class="form-group">
            <input type="submit" name="bt" value="Réserver" class="form-control"></inupt>
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>