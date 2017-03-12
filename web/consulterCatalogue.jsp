<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Consulter le catalogue </H1>
    <div>
        <table class="table table-striped">
            <tr>
                <th>Titre</th>
                <th>Prix</th>
                <th>Propriétaire</th>
                <th>Réserver/Modifier</th>
            </tr>
            <c:forEach items="${mesOeuvres}" var="item">
                <tr>
                    <td>${item.titreOeuvrevente}</td>
                    <td>${item.prixOeuvrevente}</td>
                    <td>${item.proprietaire.prenomProprietaire} ${item.proprietaire.nomProprietaire}</td>
                    <td>
                        <a class="btn btn-primary btn-sm" type="button" href="ControleurReservations?action=reserverOeuvre&idOeuvre=${item.idOeuvrevente}"><span class="glyphicon glyphicon-ok"></span></a>
                        <a class="btn btn-success btn-sm" type="button" href="ControleurOeuvres?action=modifierOeuvre&idOeuvre=${item.idOeuvrevente}"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
