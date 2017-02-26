<%--
  Created by IntelliJ IDEA.
  User: Louis
  Date: 25/02/2017
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
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
        <table>
            <tr>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${mesAdherents}" var="item">
                <tr>
                    <td>${item.idAdherent}</td>
                    <td>${item.nomAdherent}</td>
                    <td>${item.prenomAdherent}</td>
                    <td>${item.villeAdherent}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
