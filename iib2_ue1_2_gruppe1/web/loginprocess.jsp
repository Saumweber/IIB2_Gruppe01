<%-- 
    Document   : loginprocess
    Created on : 15.05.2016, 01:03:46
    Author     : Florian
--%>

<%
    if (request.getParameter("logout") != null) {
        session.removeAttribute("loginEmail");
        session.setAttribute("loginError", "Sie wurden erfolgreich ausgeloggt.");
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", "./index.jsp");
    } else {
        String loginEmail = request.getParameter("email");
        String loginPassword = request.getParameter("password");

        /* 
        // gemäß E-Mail auskommentiert, da scheinbar Java anders hashed als MySQL
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
        md.update(loginPassword.getBytes("UTF-8"));
        byte[] digest = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        loginPassword = hexString.toString();
         */
        // noch nicht eingeloggt, da Session-Attribut nicht existiert
        if (session.getAttribute("loginEmail") == null) {
            beanDao.GutachterDao gutachterDao = new beanDao.GutachterDao();
            bean.Gutachter gutachter = new bean.Gutachter();
            gutachter.setGutEmail(loginEmail);

            beanDao.EigentuemerDao eigentuemerDao = new beanDao.EigentuemerDao();
            bean.Eigentuemer eigentuemer = new bean.Eigentuemer();
            eigentuemer.setEigEmail(loginEmail);

            beanDao.HandwerkerDao handwerkerDao = new beanDao.HandwerkerDao();
            bean.Handwerker handwerker = new bean.Handwerker();
            handwerker.setHawEmail(loginEmail);

            boolean login = false;
            if (gutachterDao.selectByEmail(gutachter).size() > 0
                    && gutachterDao.selectByEmail(gutachter).get(0).getGutPasswort().equals(loginPassword)) {
                login = true;
            } else if (eigentuemerDao.selectByEmail(eigentuemer).size() > 0
                    && eigentuemerDao.selectByEmail(eigentuemer).get(0).getEigPasswort().equals(loginPassword)) {
                login = true;
            } else if (handwerkerDao.selectByEmail(handwerker).size() > 0
                    && handwerkerDao.selectByEmail(handwerker).get(0).getHawPasswort().equals(loginPassword)) {
                login = true;
            }
            if (login) {
                session.setAttribute("loginEmail", "email");
            }
        }

        // Session-abhängig (also angemeldet oder nicht) weiterleiten
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