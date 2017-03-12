<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Ajout d'un adhérent </H1>
    <DIV>
        <FORM name='identification' method="post" action="ControleurAdherents?action=insererAdherent" onsubmit="return teste()">
            <div class="form-group">
                <label for="nom" class="control-label">
                    Nom de l'adherent :
                </label>
                <input type="text" name="txtnom" value="" id="nom" class="form-control" placeholder="Nom">
            </div>
            <div class="form-group">
                <label for="prenom" class="control-label">
                    Prenom de l'adherent :
                </label>
                <input type="text" name="txtprenom" id="prenom" class="form-control" placeholder="Prénom">
            </div>
            <div class="form-group">
                <label for="ville" class="control-label">
                    Ville de l'adherent :
                </label>
                <input type="text" name="txtville" id="ville" class="form-control" placeholder="Ville">
            </div>
            <!-- Boutons Ajouter -->
            <div class="form-group">
                <input type="submit" name="bt" value="Ajouter" class="form-control">
            </div>
        </FORM>
    </DIV>
</div>
<jsp:include page="footer.jsp"/>
