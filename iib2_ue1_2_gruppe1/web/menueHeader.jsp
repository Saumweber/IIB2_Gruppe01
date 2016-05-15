<%-- 
    Document   : menueHeader
    Created on : 15.05.2016, 01:33:04
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>Navigationsleiste<br />
    Breadcrumb Navigation<br/>
    <% if (session.getAttribute("loginEmail") != null) {
            out.println("<a href=\"./loginprocess.jsp?logout=1\" title=\"Logout\">Logout</a>");
        } else {
            out.println("<a href=\"./index.html\" title=\"Anmelden\">Anmelden</a>");
        }
    %>
</p>
<hr />