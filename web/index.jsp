<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="0;URL=javascript:fermer();">
    <title>Expo : Médiathèque De POLYTECH</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>


<script language="JavaScript">
    function fermer() {

    }
</script>

<body>
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
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>