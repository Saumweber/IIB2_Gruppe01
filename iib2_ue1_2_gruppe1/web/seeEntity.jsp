<%-- 
    Document   : seeEntity
    Created on : 14.05.2016, 15:14:23
    Author     : Florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String title = "iib2_ue1_2_gruppe1: Einsehen";
    if (!request.getParameter("entity").isEmpty()) {
        String tmp = request.getParameter("entity").toLowerCase();
        title = title + " - " + tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(title); %></title>
    </head>
    <body>
        <h1><% out.print(title); %></h1>


        <%@page import="mysqlBean.Auftrag" %>
        <jsp:useBean id="auftrag" scope="session" class="mysqlBean.Auftrag" />
        <jsp:setProperty property="*" name="auftrag" />
        Handwerker Mail: <% out.println(auftrag.getAufStatus()); %><br />

        <jsp:useBean id="adresse" scope="session" class="mysqlBean.Adresse" />
        <jsp:setProperty property="adrId" name="adresse" value="1" />


        <% out.print(adresse.getAdrId() + ", "
                    + adresse.getAdrStrasse() + ", "
                    + adresse.getAdrHausnummer() + ", "
                    + adresse.getAdrPlz() + ", "
                    + adresse.getAdrOrt() + ", "
                    + adresse.getAdrLand());
            out.println("<br />-------------<br />");
            java.util.List<mysqlBean.Adresse> adresseList = new mysqlBeanDao.AdresseDao().sAdresse();

            for (mysqlBean.Adresse oneAdresse : adresseList) {
                out.println(oneAdresse.getAdrId() + ", "
                        + oneAdresse.getAdrStrasse() + ", "
                        + oneAdresse.getAdrHausnummer() + ", "
                        + oneAdresse.getAdrPlz() + ", "
                        + oneAdresse.getAdrOrt() + ", "
                        + oneAdresse.getAdrLand() + "<br />");
            }
            out.println("<br />-----------<br />");

            String compare = request.getParameter("entity").toLowerCase();
            if (compare.equals("adresse")) {
        %>
        <form action="./processEnity.jsp" name="form_adresse" method="post">
            <div>
                <label for="strasse">Stra&szlig;e: </label>
                <input type="text" name="strasse" id="strasse" value="" required="required" placeholder="Stra&szlig;e" />
                <br />
                <label for="hausnummer">Hausnummer: </label>
                <input type="text" name="hausnummer" id="hausnummer" value="" required="required" placeholder="Hausnummer" />
                <br />
                <label for="plz">PLZ: </label>
                <input type="text" name="plz" id="plz" value="" required="required" placeholder="PLZ" />
                <br />
                <label for="ort">Ort: </label>
                <input type="text" name="ort" id="ort" value="" required="required" placeholder="Ort" />
                <br />
                <label for="land">Land: </label>
                <input type="text" name="land" id="land" value="" required="required" placeholder="Land" />
                <br />
                <input type="submit" name="submit_adresse" id="submit_adresse" value="einf&uuml;gen" />
                <input type="reset" name="reset_adresse" id="reset_adresse" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("eigentuemer")) {
        %>
        <form action="./processEnity.jsp" name="form_eigentuemer" method="post">
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
                <input type="submit" name="submit_eigentuemer" id="submit_eigentuemer" value="einf&uuml;gen" />
                <input type="reset" name="reset_eigentuemer" id="reset_eigentuemer" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("beruf")) {
        %>
        <form action="./processEnity.jsp" name="form_beruf" method="post">
            <div>
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" value="" required="required" placeholder="Name" />
                <br />
                <label for="spezialisierung">Spezialisierung </label>
                <input type="text" name="spezialisierung" id="spezialisierung" value="" required="required" placeholder="Spezialisierung" />
                <br />
                <input type="submit" name="submit_beruf" id="submit_beruf" value="einf&uuml;gen" />
                <input type="reset" name="reset_beruf" id="reset_beruf" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("handwerker")) {
        %>
        <form action="./processEnity.jsp" name="form_handwerker" method="post">
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
                <input type="submit" name="submit_handwerker" id="submit_handwerker" value="einf&uuml;gen" />
                <input type="reset" name="reset_handwerker" id="reset_handwerker" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("gutachter")) {
        %>
        <form action="./processEnity.jsp" name="form_gutachter" method="post">
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
                <input type="submit" name="submit_gutachter" id="submit_gutachter" value="einf&uuml;gen" />
                <input type="reset" name="reset_gutachter" id="reset_gutachter" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("schaden")) {
        %>
        <form action="./processEnity.jsp" name="form_schaden" method="post">
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
                <input type="submit" name="submit_schaden" id="submit_schaden" value="einf&uuml;gen" />
                <input type="reset" name="reset_schaden" id="reset_schaden" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("gebauede")) {
        %>
        <form action="./processEnity.jsp" name="form_gebaude" method="post">
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
                <input type="submit" name="submit_gebaeude" id="submit_gebaeude" value="einf&uuml;gen" />
                <input type="reset" name="reset_gebaeude" id="reset_gebaeude" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("schadenslage")) {
        %>
        <form action="./processEnity.jsp" name="form_schadenslage" method="post">
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
                <input type="submit" name="submit_schadenslage" id="submit_schadenslage" value="einf&uuml;gen" />
                <input type="reset" name="reset_schadenslage" id="reset_schadenslage" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("multimedia")) {
        %>
        <form action="./processEnity.jsp" name="form_multimedia" method="post">
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
                <input type="submit" name="submit_multimedia" id="submit_multimedia" value="einf&uuml;gen" />
                <input type="reset" name="reset_multimedia" id="reset_multimedia" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
        } else if (compare.equals("schadensart")) {
        %>
        <form action="./processEnity.jsp" name="form_schadensart" method="post">
            <div>
                <label for="name">Name: </label>
                <select name="name" id="name" value="" required="required">
                    <option value="">siehe Adresse Eigentuemer</option>
                </select>
                <br /> 
                <input type="submit" name="submit_schadensart" id="submit_schadensart" value="einf&uuml;gen" />
                <input type="reset" name="reset_schadensart" id="reset_schadensart" value="zur&uuml;cksetzen" />
            </div>
        </form>
        <%
            }
        %>

    </body>
</html>
