<%-- 
    Document   : index
    Created on : 15.05.2016, 01:28:29
    Author     : Florian
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>iib2_ue1_2_gruppe1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="./menueHeader.jsp" />
        <h1>Anmelden</h1>
        <% if (session.getAttribute("loginEmail") == null
                    && session.getAttribute("loginError") != null) {
                out.print("<p>" + session.getAttribute("loginError") + "</p>");
                session.removeAttribute("loginError");
            } else if (session.getAttribute("loginEmail") != null) {
                response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                response.setHeader("Location", "./dashboard.jsp");
            }
        %>
        <form action="./dashboard.jsp" name="form_login" method="post">
            <div>
                <label for="email">E-Mail: </label>
                <input type="email" name="email" id="email" value="" required="required" placeholder="E-Mail-Adresse"/>
                <br />
                <label for="password">Passwort: </label>
                <input type="password" name="password" id="password" value="" required="required" placeholder="Passwort"/>
                <br />
                <input type="submit" name="submit" id="submit" value="anmelden" />
                <input type="reset" name="reset" id="reset" value="zur&uuml;cksetzen" />
            </div>
        </form>
    </body>
</html>
