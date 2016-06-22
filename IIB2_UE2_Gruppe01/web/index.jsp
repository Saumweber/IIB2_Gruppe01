<%-- 
    Document   : index
    Created on : 21.06.2016, 12:03:24
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IIB2_UE2_Gruppe01</title>
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
