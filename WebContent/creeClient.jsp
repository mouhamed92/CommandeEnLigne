<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    <c:import url="/inc/menu.jsp"></c:import>
        <div>
            <form method="post" action="creationClient">
                <fieldset>
                    <legend>Informations client</legend>
                     <c:import url="/inc/inc_client_form.jsp" />
                </fieldset>
                <p class="info">${resultat }</p>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>