<%-- 
    Document   : newjsp
    Created on : 13.05.2016, 01:00:12
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("loginEmail") == null
            && request.getParameter("submit") != null) {
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./loginprocess.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./standardMetadata.jsp" />
        <title>iib2_ue1_2_gruppe1: Dashboard</title>
    </head>
    <body>
        <jsp:include page="./menueHeader.jsp" />
        <% if (session.getAttribute("loginEmail") == null) {
                out.println(miscellaneous.MsgHandling.printMsg(403));
                out.println("</body></html>");
                return;
            }
        %>
        <h1>Anlegen</h1>
        <ul>
            <li><a href="./newEntity.jsp?entity=adresse" title="Adresse anlegen">Adresse</a></li>
            <li><a href="./newEntity.jsp?entity=eigentuemer" title="Eigent&uuml;mer anlegen">Eigent&uuml;mer</a></li>
            <li><a href="./newEntity.jsp?entity=beruf" title="Beruf anlegen">Beruf</a></li>
            <li><a href="./newEntity.jsp?entity=handwerker" title="Handwerker anlegen">Handwerker</a></li>
            <li><a href="./newEntity.jsp?entity=gutachter" title="Gutachter anlegen">Gutachter</a></li>
            <li><a href="./newEntity.jsp?entity=schaden" title="Schaden anlegen">Schaden</a></li>
            <li><a href="./newEntity.jsp?entity=gebaeude" title="Geb&auml;ubde anlegen">Geb&auml;ude</a></li>
            <li><a href="./newEntity.jsp?entity=schadenslage" title="Schadenslage anlegen">Schadenslage</a></li>
            <li><a href="./newEntity.jsp?entity=multimedia" title="Multimedia anlegen">Multimedia</a></li>
            <li><a href="./newEntity.jsp?entity=schadensart" title="Schadensart anlegen">Schadensart</a></li>
        </ul>
        <h1>Einsehen</h1>
        <ul>
            <li><a href="./seeEntity.jsp?entity=adresse" title="Adresse(n) einsehen">Adresse(n)</a></li>
            <li><a href="./seeEntity.jsp?entity=eigentuemer" title="Eigent&uuml;mer einsehen">Eigent&uuml;mer</a></li>
            <li><a href="./seeEntity.jsp?entity=beruf" title="Beruf(e) einsehen">Beruf(e)</a></li>
            <li><a href="./seeEntity.jsp?entity=handwerker" title="Handwerker einsehen">Handwerker</a></li>
            <li><a href="./seeEntity.jsp?entity=gutachter" title="Gutachter einsehen">Gutachter</a></li>
            <li><a href="./seeEntity.jsp?entity=schaden" title="Schaden/ Schäden einsehen">Schaden/ Sch&auml;den</a></li>
            <li><a href="./seeEntity.jsp?entity=gebaeude" title="Geb&auml;bde einsehen">Geb&auml;de</a></li>
            <li><a href="./seeEntity.jsp?entity=schadenslage" title="Schadenslage(n) einsehen">Schadenslage(n)</a></li>
            <li><a href="./seeEntity.jsp?entity=multimedia" title="Multimedia einsehen">Multimedia</a></li>
            <li><a href="./seeEntity.jsp?entity=schadensart" title="Schadensart(en) einsehen">Schadensart(en)</a></li>
        </ul>
        <h1>Bearbeiten</h1>
        <ul>
            <li><a href="./modifyEntity.jsp?entity=adresse" title="Adresse bearbeiten">Adresse</a></li>
            <li><a href="./modifyEntity.jsp?entity=eigentuemer" title="Eigent&uuml;mer bearbeiten">Eigent&uuml;mer</a></li>
            <li><a href="./modifyEntity.jsp?entity=beruf" title="Beruf bearbeiten">Beruf</a></li>
            <li><a href="./modifyEntity.jsp?entity=handwerker" title="Handwerker bearbeiten">Handwerker</a></li>
            <li><a href="./modifyEntity.jsp?entity=gutachter" title="Gutachter bearbeiten">Gutachter</a></li>
            <li><a href="./modifyEntity.jsp?entity=schaden" title="Schaden bearbeiten">Schaden</a></li>
            <li><a href="./modifyEntity.jsp?entity=gebaeude" title="Geb&auml;bde bearbeiten">Geb&auml;de</a></li>
            <li><a href="./modifyEntity.jsp?entity=schadenslage" title="Schadenslage bearbeiten">Schadenslage)</a></li>
            <li><a href="./modifyEntity.jsp?entity=multimedia" title="Multimedia bearbeiten">Multimedia</a></li>
            <li><a href="./modifyEntity.jsp?entity=schadensart" title="Schadensart bearbeiten">Schadensart</a></li>
        </ul>
    </body>
</html>
