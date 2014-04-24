<%-- 
    Document   : AlterArtist
    Created on : 24-Apr-2014, 11:53:51
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
       <form action="AlterArtistServlet" method="post">
            <input type="text" name="First_Name" value="${ARTISTBEAN.getFirst_Name()}"/>
            <input type="submit"/>
        </form>
    </body>
</html>
