<%-- 
    Document   : newEntity
    Created on : 14.05.2016, 15:14:33
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String title = "iib2_ue1_2_gruppe1: Anlegen";
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
        <h1>Hello World!</h1>
    </body>
</html>
