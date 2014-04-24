<%-- 
    Document   : DeleteArtist
    Created on : 24-Apr-2014, 12:01:47
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ArtistDeleteServlet" method="post">
            <input type="text" name="ArtistId"/>
            <input type="submit">
        </form>
    </body>
</html>
