<%-- 
    Document   : newEntity
    Created on : 14.05.2016, 15:14:33
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
    response.setHeader("Location", "./modifyEntity.jsp?tpye=add&entity=" + request.getParameter("entity"));
%>