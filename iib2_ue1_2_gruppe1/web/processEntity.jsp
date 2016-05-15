<%-- 
    Document   : processEnity
    Created on : 15.05.2016, 00:31:37
    Author     : Florian
--%>

<%@page import="miscellaneous.Misc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String comparingString = request.getParameter("entity") != null ? request.getParameter("entity").toLowerCase() : "";
    if (comparingString.equals("adresse")) {
        bean.Adresse element = new bean.Adresse();
        element.setAdrId(Integer.parseInt((String) session.getAttribute("modifyId")));
        element.setAdrStrasse(request.getParameter("strasse"));
        element.setAdrHausnummer(request.getParameter("hausnummer"));
        element.setAdrPlz(request.getParameter("plz"));
        element.setAdrOrt(request.getParameter("ort"));
        element.setAdrLand(request.getParameter("land"));;
        beanDao.AdresseDao elementDao = new beanDao.AdresseDao();
        int result = elementDao.update(element);
        session.removeValue("modifyId");
        session.setAttribute("return", result);
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./modifyEntity.jsp?entity=adresse&id=" + element.getAdrId());
    }
%>