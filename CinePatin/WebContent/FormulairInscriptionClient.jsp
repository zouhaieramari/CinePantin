<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="FormulairStyle.css" />
    </head>
    <body>
     vous avez connecter: ${compteur.valeur} fois
        <form method="post" action="ClientController">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

 				<label for="nom">Nom <span >*</span></label>
                <input type="text" id="nom" name="nom" value="${param.nom}" size="20" maxlength="60" />${erreurnom}
                <br />
                <label for="prenom">Prenom <span >*</span></label>
                <input type="text" id="prenom" name="prenom" value="${param.prenom}" size="20" maxlength="60" />${erreurprenom}
                <br />
                <label for="adresse">Adresse Postale<span>*</span></label>
                <input type="text" id="adresse" name="adresse" value="${param.adresse}" size="20" maxlength="60" />${erreuradresse}
                <br />
                <label for="age">Age<span>*</span></label>
                <input type="date"  name="age" value="${param.age }"/><br/>${erreurage}
                <br />
                <label for="email">Adresse email <span>*</span></label>
                <input type="email" id="email" name="email" value="${param.email}" size="20" maxlength="60" />${erreuremail}
                <br />
                <label for="motdepasse">Mot de passe <span>*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value=""  />${erreurmotdepasse}
                <br />

                <label for="confirmation">Confirmation du mot de passe <span>*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" />${erreurconfirmation}
                <br />
                <input type="submit" value="Inscription" name="boutonaction" />
                <br />
            </fieldset>
        </form>
    </body>
</html>