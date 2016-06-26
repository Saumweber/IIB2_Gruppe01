<%-- 
    Document   : processEnity
    Created on : 15.05.2016, 00:31:37
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String type = "";
    if (request.getParameter("type") != null) {
        if (request.getParameter("type").toLowerCase().equals("add")) {
            type = "add";
        } else if (request.getParameter("type").toLowerCase().equals("delete")) {
            type = "delete";
        }
    }
    String comparingString = request.getParameter("entity") != null ? request.getParameter("entity") : "";
    
    //TODO Auftragsstatus bearbeiten
    if (comparingString.equals("eigeneAuftraege")) {
        bean.Sanierungsauftrag element = new bean.Sanierungsauftrag();
        beanDao.SanierungsauftragDao elementDao = new beanDao.SanierungsauftragDao();
        
        if (!type.equals("add")) {
            element.setSnrId(Integer.parseInt(session.getAttribute("modifyId").toString()));
            element = elementDao.selectById(element).get(0);
        }
        
        session.removeAttribute("modifyId");

        if (type == "delete") {
            int result = elementDao.delete(element);
            session.setAttribute("return", result);
        } else {
            element.setSnrStatus(request.getParameter("status"));
            int result = -1;
            if (!type.equals("add")) {
                result = elementDao.update(element);
            } else {
                result = elementDao.insert(element);
            }
            session.setAttribute("return", result);
        }
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./modifyEntity.jsp?entity=eigeneAuftraege&id=" + element.getSnrId());
    }
    
    if (comparingString.equals("handwerker")) {
        bean.Nutzer element = new bean.Nutzer();
        element.setNtzEmail(request.getParameter("email"));
        element.setNtzPasswort(request.getParameter("passwort"));
        element.setNtzName(request.getParameter("name"));
        element.setNtzVorname(request.getParameter("vorname"));
        
        bean.Beruf brf = new bean.Beruf();
        try {
        Integer i = new Integer(request.getParameter("beruf"));
        brf.setBrfId(i);
        }
        catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        beanDao.BerufDao brfDao = new beanDao.BerufDao();
        brf = brfDao.selectById(brf).get(0);
        element.setBeruf(brf);
        
        int result = -1;
        beanDao.NutzerDao ntzDao = new beanDao.NutzerDao();
        result = ntzDao.insert(element);
        session.setAttribute("return", result);
        
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./modifyEntity.jsp?entity=handwerker&type=add&id=" + element.getNtzEmail());
    }
    //TODO Sanierungsauftrag anlegen
    
    
    /* Adresse bearbeiten    
    if (comparingString.equals("adresse")) {
        bean.Adresse element = new bean.Adresse();
        if (!type.equals("add")) {
            element.setAdrId(Integer.parseInt(session.getAttribute("modifyId").toString()));
        }
        beanDao.AdresseDao elementDao = new beanDao.AdresseDao();
        session.removeAttribute("modifyId");

        if (type == "delete") {
            int result = elementDao.delete(element);
            session.setAttribute("return", result);
        } else {
            element.setAdrStrasse(request.getParameter("strasse"));
            element.setAdrHausnummer(request.getParameter("hausnummer"));
            element.setAdrPlz(request.getParameter("plz"));
            element.setAdrOrt(request.getParameter("ort"));
            element.setAdrLand(request.getParameter("land"));
            int result = -1;
            if (!type.equals("add")) {
                result = elementDao.update(element);
            } else {
                result = elementDao.insert(element);
            }
            session.setAttribute("return", result);
        }
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./modifyEntity.jsp?entity=adresse&id=" + element.getAdrId());
    } */
    
%>