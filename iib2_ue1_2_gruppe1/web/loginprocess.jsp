<%-- 
    Document   : loginprocess
    Created on : 15.05.2016, 01:03:46
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("logout") != null) {
        session.removeAttribute("loginEmail");
        session.setAttribute("loginError", "Sie wurden erfolgreich ausgeloggt.");
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./index.jsp");
    } else {
        if (session.getAttribute("loginEmail") == null) {
            // search for user und dann 
            session.setAttribute("loginEmail", "email");
        }

        if (session.getAttribute("loginEmail") != null) {
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", "./dashboard.jsp");
        } else {
            session.removeAttribute("loginEmail");
            session.setAttribute("loginError", "E-Mail oder Passwort stimmt nicht.");
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", "./index.jsp");
        }
    }
%>