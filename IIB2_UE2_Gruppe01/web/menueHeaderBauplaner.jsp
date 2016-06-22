<%-- 
    Document   : menueHeaderBauplaner
    Created on : 22.06.2016, 19:26:06
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>
    <a href="./dashboardBauplaner.jsp" title="Dashboard">Dashboard</a> |
    <% if (session.getAttribute("loginEmail") != null) {
            out.println("<a href=\"./loginprocess.jsp?logout=1\" title=\"Logout\">Logout</a>");
        } else {
            out.println("<a href=\"./index.html\" title=\"Anmelden\">Anmelden</a>");
        }
    %>
</p>
<hr />
