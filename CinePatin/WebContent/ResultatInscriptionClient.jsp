<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="FormulairStyle.css" />
</head>
<body>
<fieldset >
       <legend >Modifier Client </legend>
<table class="tabcenter" >
<tr><th> nom </th><th>prenom</th><th>email</th><th>date de naissance </th><th>Ajouter</th>
<c:forEach var= "client" items= "${listeClients}">
<tr>
<td>${client.nom}</td><td>${client.prenom}</td><td>${client.email}</td><td>${client.age}</td><td>
<form action="" method= "post">
<input type="hidden" name="nom" value="${client.nom}"/>
<input type="submit" value ="modifier" name="modifier">
</form>
</td>
</tr>

</c:forEach>
</table>
	</fieldset>
	<br><a href="ClientController"> retour</a>
</body>
</html>