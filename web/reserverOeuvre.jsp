<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<script>
    $(function(){
        $('#sandbox-container input').datepicker({
            format: "yyyy-mm-dd"
        });
    });
</script>
<div class="container">
    <H1> Réserver une oeuvre </H1>
    <form name='identification' method="post" action="ControleurReservations?action=insererReservation">
        <div class="form-group">
            <label for="titre" class="control-label">
               Titre de l'oeuvre :
            </label>
            <input type="text" name="txttitre" value="${monOeuvre.titreOeuvrevente}" id="titre" class="form-control" readonly>
            <input type="hidden" name="txtIDOeuvre" id="idOeuvre" value="${monOeuvre.idOeuvrevente}">
        </div>
        <div class="form-group">
            <label for="prix" class="control-label">
                Prix :
            </label>
            <input type="text" name="txtPrix" value="${monOeuvre.prixOeuvrevente}" id="prix" class="form-control" readonly>
        </div>
        <div id="sandbox-container" class="form-group">
            <label for="date" class="control-label">
                Date :
            </label>
            <input type="text" name="txtDate" id="date" class="form-control" placeholder="yyyy-mm-jj">
        </div>
        <div class="form-group">
            <label for="adherent" class="control-label">
                Adhérent :
            </label>
            <select name="txtIDAdherent" id="adherent" class="form-control">
                <c:forEach items="${mesAdherents}" var="item">
                    <option value="${item.idAdherent}">${item.prenomAdherent} ${item.nomAdherent}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" name="bt" value="Réserver" class="form-control">
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"/>