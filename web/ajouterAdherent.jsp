<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un adhérent</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<script type="text/javascript" src="js/foncControle.js"></script>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <H1> Ajout d'un adhérent </H1>
    <DIV>
        <FORM name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
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
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>