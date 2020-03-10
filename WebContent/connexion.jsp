<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <form method="post" action="CreationCnx">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${FormCnx.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${FormCnx.erreurs['motDePasse']}</span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty FormCnx.erreurs ? 'succes' : 'erreur'}">${FormCnx.resultat}</p>
                 <c:if test="${!empty sessionScope.sessionUtl }">
                  <p class="succes">Vous êtes connecté(e) avec l'adresse :
                    ${sessionScope.sessionUtl.email}</p>
                 </c:if>
                 <p>${id }</p>
   
            </fieldset>
        </form>
    </body>
</html>