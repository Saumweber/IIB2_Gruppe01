<%-- 
    Document   : seeEntity
    Created on : 14.05.2016, 15:14:23
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String title = "iib2_ue1_2_gruppe1: Einsehen";
    if (!request.getParameter("entity").isEmpty()) {
        String tmp = request.getParameter("entity").toLowerCase();
        title = title + " - " + tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./standardMetadata.jsp" />
        <title><% out.print(title); %></title>
    </head>
    <body>
        <jsp:include page="./menueHeader.jsp" />
        <% if (session.getAttribute("loginEmail") == null) {
                out.println(miscellaneous.MsgHandling.printMsg(403));
                out.println("</body></html>");
                return;
            }
        %>
        <h1><% out.print(title); %></h1>
        <table>
            <%
                String comparingString = request.getParameter("entity").toLowerCase();
                if (comparingString.equals("adresse")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("eigentuemer")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>E-Mail</th>
                    <th>Vorname</th>
                    <th>Nachname</th>
                    <th>Kunde</th>                        
                    <th>Adresse</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Eigentuemer> liste = new beanDao.EigentuemerDao().select();
                    for (bean.Eigentuemer element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getEigEmail() + "</td>"
                                + "<td>" + element.getEigVorname() + "</td>"
                                + "<td>" + element.getEigNachname() + "</td>"
                                + "<td>" + element.getEigKunde() + "</td>"
                                + "<td>" + element.getAdresse().toHTMLString() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=eigentuemer&amp;id=" + element.getEigEmail() + "\" title=\"Eigent&uuml;mer " + element.getEigEmail() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Eigent&uuml;mer " + element.getEigEmail() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=eigentuemer&amp;id=" + element.getEigEmail() + "\" title=\"Eigent&uuml;mer " + element.getEigEmail() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Eigent&uuml;mer " + element.getEigEmail() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("beruf")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Name</th>
                    <th>Spezialisierung</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Beruf> liste = new beanDao.BerufDao().select();
                    for (bean.Beruf element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getBerName() + "</td>"
                                + "<td>" + element.getBerSpezialisierung() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getBerId() + "\" title=\"Adresse " + element.getBerId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getBerId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getBerId() + "\" title=\"Adresse " + element.getBerId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getBerId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("handwerker")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("gutachter")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("schaden")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("gebaeude")) {
            %>
            <%
            } else if (comparingString.equals("schadenslage")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("multimedia")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("schadensart")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
            } else if (comparingString.equals("auftrag")) {
            %>
            <thead>
                <tr>
                    <th>Laufnummer</th>
                    <th>Id</th>
                    <th>Stra&szlig;e</th>
                    <th>Hausnummer</th>
                    <th>PLZ</th>
                    <th>Ort</th>                        
                    <th>Land</th>
                    <th>bearbeiten</th>
                    <th>l&ouml;schen</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int i = 0;
                    java.util.List<bean.Adresse> liste = new beanDao.AdresseDao().select();
                    for (bean.Adresse element : liste) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + element.getAdrId() + "</td>"
                                + "<td>" + element.getAdrStrasse() + "</td>"
                                + "<td>" + element.getAdrHausnummer() + "</td>"
                                + "<td>" + element.getAdrPlz() + "</td>"
                                + "<td>" + element.getAdrOrt() + "</td>"
                                + "<td>" + element.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&amp;id=" + element.getAdrId() + "\" title=\"Adresse " + element.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + element.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
            <%
                }
            %>

        </table>
    </body>
</html>
