<%-- 
    Document   : newjsp
    Created on : 13.05.2016, 01:00:12
    Author     : Florian
--%>

<%@page import="beanDao.NutzerDao"%>
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
        <title>IIB2_UE2_Gruppe1: Dashboard</title>
    </head>
    <body>
        <jsp:include page="./menueHeader.jsp" />
        <% if (session.getAttribute("loginEmail") == null) {
                out.println(miscellaneous.MsgHandling.printMsg(403));
                out.println("</body></html>");
                return;
            }
        %>
        
        
        <% 
            if(session.getAttribute("nutzerArt") == "Handwerker"){
        %>     
                  
        <h1>Einsehen</h1>
        <ul>
            
            <li><a href="./seeEntity.jsp?entity=eigeneAuftraege" title="eigene Aufträge einsehen">Eigene Aufträge</a></li>
            <li><a href="./seeEntity.jsp?entity=gebaeudeAuftaege" title="Aufträge pro Gebäude einsehen">Gebäudeaufträge</a></li>
                
        </ul> 
                
        <%   
            } 
        %>
        
        <% 
            if(session.getAttribute("nutzerArt") == "Bauplaner"){
        %>        
        
        <h1>Anlegen</h1>
        <ul>
            <%-- <li><a href="./newEntity.jsp?entity=adresse" title="Adresse anlegen">Adresse</a></li> --%>
        </ul>
        
        <h1>Einsehen</h1>
        <ul>
            <%-- <li><a href="./seeEntity.jsp?entity=adresse" title="Adresse(n) einsehen">Adresse(n)</a></li> --%>
        </ul>
        
        <p>Das Dashboard muss für den Bauplaner noch angepasst werden.</p>
        <% 
            }  
        %>
        
    </body>
</html>
