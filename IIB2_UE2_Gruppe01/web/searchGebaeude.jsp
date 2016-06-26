<%-- 
    Document   : insertGebaeude
    Created on : 25.06.2016, 00:28:42
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./standardMetadata.jsp" />
        <title>IIB2_UE2_Gruppe1: Gebäude eingeben</title>
    </head>
    <body>
        <jsp:include page="./menueHeader.jsp" />
        <h1>Suche nach Gebäude:</h1>
        
        <form action="./seeEntity.jsp?entity=gebaeudename" name="from_Gebaeude" method="post">
            <div>
                <label for="status">Name des Gebäudes: </label>
                <input type="text" name="gebaeudename" id="gebaeudename" value="" required="required" placeholder="Name des Gebäudes" />
                <br />
                <input type="submit" name="submit_gebaeudename" id="submit_gebaeudename" value="Gebäude suchen" />
                <input type="reset" name="reset_gebaeudename" id="reset_gebaeudename" value="zur&uuml;cksetzen" />
            </div>
        </form>
        
    </body>
</html>

