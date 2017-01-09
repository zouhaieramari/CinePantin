<%

String nom = (String)request.getAttribute("nom");
String prenom = (String)request.getAttribute("prenom");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
vous ete l utilisateur numero ${compteurutilisateur.valeur}</br>
vous avez connecte: ${compteur.valeur} fois


<h3> Formulair rempli avec succès: <% out.print(nom);  %> <% out.print(prenom);  %></h3>

vous venez de crees le compte de  ${clientAttr.prenom } ${clientAttr.nom }

</body>
</html>