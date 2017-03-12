<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <div>
        <h2 class="center">
            Médiathèque de POLYTECH
        </h2>
        <h3 class="center underline">
            Gestion de l'exposition 2016
        </h3>
    </div>
    <div>
        <p class="left emphasis">
            Sélectionnez la fonctionnalité voulue:
        </p>
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation">
                <a href="ControleurAdherents?action=ajouterAdherent">Ajout Adhérent</a>
            </li>
            <li role="presentation">
                <a href="ControleurAdherents?action=listerAdherent">Lister les adhérents</a>
            </li>
        </ul>
    </div>
</div>
<jsp:include page="footer.jsp"/>