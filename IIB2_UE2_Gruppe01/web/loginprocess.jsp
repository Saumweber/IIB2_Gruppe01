<%-- 
    Document   : loginprocess
    Created on : 15.05.2016, 01:03:46
    Author     : Florian
--%>

<%@page import="bean.Nutzer"%>
<%@page import="java.util.List"%>
<%
    if (request.getParameter("logout") != null) {
        session.removeAttribute("loginEmail");
        session.setAttribute("loginError", "Sie wurden erfolgreich ausgeloggt.");
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./index.jsp");
    } else {
        String loginEmail = request.getParameter("email");
        String loginPassword = request.getParameter("password");

        // noch nicht eingeloggt, da Session-Attribut nicht existiert
        if (session.getAttribute("loginEmail") == null) {
            beanDao.NutzerDao nutzerDao = new beanDao.NutzerDao();
            bean.Nutzer nutzer = new bean.Nutzer();
            nutzer.setNtzEmail(loginEmail);

            /*
            beanDao.EigentuemerDao eigentuemerDao = new beanDao.EigentuemerDao();
            bean.Eigentuemer eigentuemer = new bean.Eigentuemer();
            eigentuemer.setEigEmail(loginEmail);

            beanDao.HandwerkerDao handwerkerDao = new beanDao.HandwerkerDao();
            bean.Handwerker handwerker = new bean.Handwerker();
            handwerker.setHawEmail(loginEmail);
            */

            boolean login = false;
            if (nutzerDao.selectByEmail(nutzer).size() > 0
                    && nutzerDao.selectByEmail(nutzer).get(0).getNtzPasswort().equals(loginPassword)) {
                login = true;
            /*
            } else if (eigentuemerDao.selectByEmail(eigentuemer).size() > 0
                    && eigentuemerDao.selectByEmail(eigentuemer).get(0).getEigPasswort().equals(loginPassword)) {
                login = true;
            } else if (handwerkerDao.selectByEmail(handwerker).size() > 0
                    && handwerkerDao.selectByEmail(handwerker).get(0).getHawPasswort().equals(loginPassword)) {
                login = true;
            */
            }
            if (login) {
                session.setAttribute("loginEmail", "email");        
            }
        }

        // Session-abhängig (also angemeldet oder nicht) weiterleiten
        if (session.getAttribute("loginEmail") != null) {
            
            //Weiterleitung zu verschiedenen Dashboards
            bean.Nutzer nutzer = new bean.Nutzer();
            nutzer.setNtzEmail(loginEmail);    
            beanDao.NutzerDao ntzDao = new beanDao.NutzerDao();
            bean.Nutzer ntz = new bean.Nutzer();
            ntz = ntzDao.selectByEmail(nutzer).get(0);
            session.setAttribute("nutzer", ntz);
            String bauplaner = "Bauplaner";
            String handwerker = "Handwerker";
            
            if (ntz.getBeruf().getBrfBerufname().contentEquals("Bauplaner")){
                session.setAttribute("nutzerArt", bauplaner);
                //response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                //response.setHeader("Location", "./dashboard.jsp");
                
            } else {
                session.setAttribute("nutzerArt", handwerker);
                //response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                //response.setHeader("Location", "./dashboard.jsp");
            }
            
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