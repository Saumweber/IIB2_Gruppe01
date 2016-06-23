<%-- 
    Document   : modifyEntity
    Created on : 14.05.2016, 15:14:47
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String addOrMod = "";
    String addedOrModedOrDeleted = "";
    String title = "IIB2_UE2_Gruppe1:";
    if (request.getParameter("type") != null
            && request.getParameter("type").toLowerCase().equals("add")) {
        addOrMod = "einf&uuml;gen";
        addedOrModedOrDeleted = "eingef&uuml;gt";
        title = title + " - Anlegen";
    } else if (request.getParameter("type").toLowerCase().equals("delete")) {
        addOrMod = "l&ouml;schen";
        addedOrModedOrDeleted = "gel&ouml;scht";
        title = title + " - L&ouml;schen";
    }

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
        <h1><% out.print(title); %></h1>
        <%
            if (session.getAttribute("return") != null) {
                String entity = request.getParameter("entity");
                entity = entity.substring(0, 1).toUpperCase() + entity.substring(1);
                int returnSet = Integer.parseInt(session.getAttribute("return").toString());
                session.removeAttribute("return");
                if (returnSet > 0) {
                    out.print(entity + " wurde erfolgreich " + addedOrModedOrDeleted + ".");
                } else {
                    out.print("Es trat ein Fehler auf. " + entity + " wurde nicht " + addedOrModedOrDeleted + ".");
                }
            }

            String comparingString = request.getParameter("entity") != null ? request.getParameter("entity").toLowerCase() : "";
            String id = request.getParameter("id") != null ? request.getParameter("id").toString() : "0";
            boolean founded = false;

            if (comparingString.equals("adresse")) {
                bean.Adresse element = new bean.Adresse();
                element.setAdrId(Integer.parseInt(id));
                beanDao.AdresseDao elementDao = new beanDao.AdresseDao();
                if (elementDao.selectById(element).size() > 0) {
                    element = elementDao.selectById(element).get(0);
                    founded = true;
                } else if (request.getParameter("type") != null
                        && !request.getParameter("type").equals("add")
                        && !request.getParameter("type").equals("delete")) {
                    out.println("<p>Die zu bearbeitende Adresse konnte nicht gefunden werden.</p>");
                }
        %>
        <form action="./processEntity.jsp?entity=adresse" name="form_adresse" method="post">
            <div>
                <label for="strasse">Stra&szlig;e: </label>
                <input type="text" name="strasse" id="strasse" value="<% if (founded) {
                        out.print(element.getAdrStrasse());
                    } %>" required="required" placeholder="Stra&szlig;e" />
                <br />
                <label for="hausnummer">Hausnummer: </label>
                <input type="text" name="hausnummer" id="hausnummer" value="<% if (founded) {
                        out.print(element.getAdrHausnummer());
                    } %>" required="required" placeholder="Hausnummer" />
                <br />
                <label for="plz">PLZ: </label>
                <input type="text" name="plz" id="plz" value="<% if (founded) {
                        out.print(element.getAdrPlz());
                    } %>" required="required" placeholder="PLZ" />
                <br />
                <label for="ort">Ort: </label>
                <input type="text" name="ort" id="ort" value="<% if (founded) {
                        out.print(element.getAdrOrt());
                    } %>" required="required" placeholder="Ort" />
                <br />
                <label for="land">Land: </label>
                <input type="text" name="land" id="land" value="<% if (founded) {
                        out.print(element.getAdrLand());
                    }%>" required="required" placeholder="Land" />
                <br />
                <input type="submit" name="submit_adresse" id="submit_adresse" value="<%= addOrMod%>" />
                <input type="reset" name="reset_adresse" id="reset_adresse" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
            if (founded) {
                session.setAttribute("modifyId", element.getAdrId());
            }
        } else if (comparingString.equals("eigentuemer")) {
                bean.Eigentuemer element = new bean.Eigentuemer();
                element.setEigEmail(id);
                beanDao.EigentuemerDao elementDao = new beanDao.EigentuemerDao();
                if (elementDao.selectByEmail(element).size() > 0) {
                    element = elementDao.selectByEmail(element).get(0);
                    founded = true;
                } else if (request.getParameter("type") != null
                        && !request.getParameter("type").equals("add")
                        && !request.getParameter("type").equals("delete")) {
                    out.println("<p>Die zu bearbeitende Adresse konnte nicht gefunden werden.</p>");
                }
        %>
        <form action="./processEntity.jsp" name="form_eigentuemer" method="post">
            <div>
                <label for="vorname">Vorname: </label>
                <input type="text" name="vorname" id="vorname" value="" required="required" placeholder="Vorname" />
                <br />
                <label for="nachname">Nachname </label>
                <input type="text" name="nachname" id="nachname" value="" required="required" placeholder="Nachname" />
                <br />
                <label for="kunde">Kunde: </label>
                <input type="checked" name="kunde" id="plz" value="" />
                <br />
                <label for="adresse">Adresse: </label>
                <select name="adresse" id="adresse" value="" required="required">
                    <option value="adr_id">hier select-beanDoa pro eigentuemer laufen lassen</option>
                </select>
                <br />
                <input type="submit" name="submit_eigentuemer" id="submit_eigentuemer" value="<%= addOrMod%>" />
                <input type="reset" name="reset_eigentuemer" id="reset_eigentuemer" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("beruf")) {
        %>
        <form action="./processEntity.jsp" name="form_beruf" method="post">
            <div>
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" value="" required="required" placeholder="Name" />
                <br />
                <label for="spezialisierung">Spezialisierung </label>
                <input type="text" name="spezialisierung" id="spezialisierung" value="" required="required" placeholder="Spezialisierung" />
                <br />
                <input type="submit" name="submit_beruf" id="submit_beruf" value="<%= addOrMod%>" />
                <input type="reset" name="reset_beruf" id="reset_beruf" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("handwerker")) {
        %>
        <form action="./processEntity.jsp" name="form_handwerker" method="post">
            <div>
                <label for="vorname">Vorname: </label>
                <input type="text" name="vorname" id="vorname" value="" required="required" placeholder="Vorname" />
                <br />
                <label for="nachname">Nachname </label>
                <input type="text" name="nachname" id="nachname" value="" required="required" placeholder="Nachname" />
                <br />
                <label for="kunde">Kunde: </label>
                <input type="checked" name="kunde" id="plz" value="" />
                <br />
                <label for="adresse">Adresse: </label>
                <select name="adresse" id="adresse" value="" required="required">
                    <option value="adr_id">hier select-beanDoa pro eigentuemer laufen lassen</option>
                </select>
                <br />
                <input type="submit" name="submit_handwerker" id="submit_handwerker" value="<%= addOrMod%>" />
                <input type="reset" name="reset_handwerker" id="reset_handwerker" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("gutachter")) {
        %>
        <form action="./processEntity.jsp" name="form_gutachter" method="post">
            <div>
                <label for="vorname">Vorname: </label>
                <input type="text" name="vorname" id="vorname" value="" required="required" placeholder="Vorname" />
                <br />
                <label for="nachname">Nachname </label>
                <input type="text" name="nachname" id="nachname" value="" required="required" placeholder="Nachname" />
                <br />
                <label for="kunde">Kunde: </label>
                <input type="checked" name="kunde" id="plz" value="" />
                <br />
                <label for="adresse">Adresse: </label>
                <select name="adresse" id="adresse" value="" required="required">
                    <option value="adr_id">hier select-beanDoa pro eigentuemer laufen lassen</option>
                </select>
                <br />
                <input type="submit" name="submit_gutachter" id="submit_gutachter" value="<%= addOrMod%>" />
                <input type="reset" name="reset_gutachter" id="reset_gutachter" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("schaden")) {
        %>
        <form action="./processEntity.jsp" name="form_schaden" method="post">
            <div>
                <label for="status">Status: </label>
                <select name="status" id="status" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <label for="schadensart">Schadensart: </label>
                <select name="schadensart" id="schadensart" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <label for="umfang">Umfang: </label>
                <select name="umfang" id="umfang" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <label for="schadenslage">Schadenslage: </label>
                <select name="schadenslage" id="schadenslage" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />                
                <label for="gutachter">Gutachter </label>
                <select name="gutachter" id="gutachter" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <input type="submit" name="submit_schaden" id="submit_schaden" value="<%= addOrMod%>" />
                <input type="reset" name="reset_schaden" id="reset_schaden" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("gebauede")) {
        %>
        <form action="./processEntity.jsp" name="form_gebaude" method="post">
            <div>
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" value="" required="required" placeholder="Name" />
                <br />
                <label for="eigentuemer">Eigent&uuml;er: </label>
                <select name="eigentuemer" id="eigentuemer" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <label for="adresse">Adresse: </label>
                <select name="adresse" id="adresse" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />
                <input type="submit" name="submit_gebaeude" id="submit_gebaeude" value="<%= addOrMod%>" />
                <input type="reset" name="reset_gebaeude" id="reset_gebaeude" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("schadenslage")) {
        %>
        <form action="./processEntity.jsp" name="form_schadenslage" method="post">
            <div>
                <label for="stockwerk">Stockwerk: </label>
                <input type="text" name="stockwerk" id="stockwerk" value="" required="required" placeholder="Stockwerk:" />
                <br />
                <label for="raum">Raum: </label>
                <input type="text" name="raum" id="raum" value="" required="required" placeholder="Raum" />
                <br />
                <label for="gebaeude">Geb&auml;ude: </label>
                <select name="gebaeude" id="gebaeude" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br />                
                <input type="submit" name="submit_schadenslage" id="submit_schadenslage" value="<%= addOrMod%>" />
                <input type="reset" name="reset_schadenslage" id="reset_schadenslage" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("multimedia")) {
        %>
        <form action="./processEntity.jsp" name="form_multimedia" method="post">
            <div>
                <label for="art">Art: </label>
                <select name="art" id="art" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br /> 
                <label for="dateipfad">Dateipfad: </label>
                <input type="text" name="dateipfad" id="dateipfad" value="" required="required" placeholder="Dateipfad" />
                <br />  
                <label for="schaden">Schaden: </label>
                <select name="schaden" id="schaden" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br /> 
                <input type="submit" name="submit_multimedia" id="submit_multimedia" value="<%= addOrMod%>" />
                <input type="reset" name="reset_multimedia" id="reset_multimedia" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (comparingString.equals("schadensart")) {
        %>
        <form action="./processEntity.jsp" name="form_schadensart" method="post">
            <div>
                <label for="name">Name: </label>
                <select name="name" id="name" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br /> 
                <input type="submit" name="submit_schadensart" id="submit_schadensart" value="<%= addOrMod%>" />
                <input type="reset" name="reset_schadensart" id="reset_schadensart" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
            }
        %>
    </body>
</html>
