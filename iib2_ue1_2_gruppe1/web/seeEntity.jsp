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
        <%@page import="bean.Auftrag" %>
        <table>
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
                    java.util.List<bean.Adresse> adresseList = new beanDao.AdresseDao().select();
                    for (bean.Adresse oneAdresse : adresseList) {
                        out.println("<tr>"
                                + "<td>" + ++i + "</td>"
                                + "<td>" + oneAdresse.getAdrId() + "</td>"
                                + "<td>" + oneAdresse.getAdrStrasse() + "</td>"
                                + "<td>" + oneAdresse.getAdrHausnummer() + "</td>"
                                + "<td>" + oneAdresse.getAdrPlz() + "</td>"
                                + "<td>" + oneAdresse.getAdrOrt() + "</td>"
                                + "<td>" + oneAdresse.getAdrLand() + "</td>"
                                + "<td>" + "<a href=\"./modifyEntity.jsp?entity=adresse&id=" + oneAdresse.getAdrId() + "\" title=\"Adresse " + oneAdresse.getAdrId() + " bearbeiten\" class=\"img\"><img src=\"./pictures/edit.png\" alt=\"Bild, um Adresse " + oneAdresse.getAdrId() + " zu bearbeiten\" class=\"icon\" /></a>" + "</td>"
                                + "<td>" + "<a href=\"./deleteEntity.jsp?entity=adresse&id=" + oneAdresse.getAdrId() + "\" title=\"Adresse " + oneAdresse.getAdrId() + " l&ouml;schen\" class=\"img\"><img src=\"./pictures/delete.png\" alt=\"Bild, um Adresse " + oneAdresse.getAdrId() + " zu l&ouml;schen\" class=\"icon\" /></a>" + "</td>"
                                + "</tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
