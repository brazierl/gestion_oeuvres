<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Confirmer les réservations </H1>
    <div>
        <table class="table table-striped">
            <tr>
                <th>Titre</th>
                <th>Prix</th>
                <th>Adhérent</th>
                <th>Date</th>
                <th>Statut</th>
                <th>Confirmation</th>
            </tr>
            <c:forEach items="${mesReservations}" var="item">
                <tr>
                    <td>${item.oeuvrevente.titreOeuvrevente}</td>
                    <td>${item.oeuvrevente.prixOeuvrevente}</td>
                    <td>${item.adherent.prenomAdherent} ${item.adherent.nomAdherent}</td>
                    <td><fmt:formatDate value="${item.date}" pattern="yyyy-mm-dd"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${item.statut == 'confirmee'}">
                                Confirmée
                            </c:when>
                            <c:otherwise>
                                En attente...
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${item.statut == 'en attente'}">
                            <a class="btn btn-primary btn-sm" type="button" href="ControleurReservations?action=confirmerReservations&idOeuvre=${item.oeuvrevente.idOeuvrevente}&idAdherent=${item.adherent.idAdherent}&date=<fmt:formatDate value="${item.date}" pattern="yyyy-mm-dd"/>"><span class="glyphicon glyphicon-ok"></span></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
