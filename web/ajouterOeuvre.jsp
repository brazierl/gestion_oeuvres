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
    <H1> Ajouter une oeuvre </H1>
    <form name='identification' method="post" action="ControleurOeuvres?action=insererOeuvre">
        <div class="form-group">
            <label for="titre" class="control-label">
               Titre :
            </label>
            <input type="text" name="txtTitre" value="${monOeuvre.titreOeuvrevente}" id="titre" class="form-control">
        </div>
        <div id="sandbox-container" class="form-group">
            <label for="etat" class="control-label">
                Etat :
            </label>
            <input type="text" name="txtEtat" value="${monOeuvre.etatOeuvrevente}" id="etat" class="form-control" maxlength="1" >
        </div>
        <div class="form-group">
            <label for="prix" class="control-label">
                Prix :
            </label>
            <input type="text" name="txtPrix" value="${monOeuvre.prixOeuvrevente}" id="prix" class="form-control" >
        </div>
        <div class="form-group">
            <label for="proprietaire" class="control-label">
                Propriétaire :
            </label>
            <select name="txtIDProprietaire" id="proprietaire" class="form-control">
                <c:forEach items="${mesProprietaires}" var="item">
                    <c:choose>
                        <c:when test="${item.idProprietaire == monOeuvre.proprietaire.idProprietaire}">
                            <option value="${item.idProprietaire}" selected> ${item.prenomProprietaire} ${item.nomProprietaire}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.idProprietaire}"> ${item.prenomProprietaire} ${item.nomProprietaire}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" name="bt" value="Ajouter" class="form-control">
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"/>