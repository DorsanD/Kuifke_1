<%-- 
    Document   : AlterCredits
    Created on : 15-May-2014, 11:37:00
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
       <h1>Change your first name!</h1>
        <div class="Alter">
            <p>Current name: ${CUSTOMERBEAN.getCredits()}</p>
            <form action="BuySongServlet" method="post">
                Amount of credits to add: <input type="text" name="Credits"/>
                <input type="submit" class="btn btn-primary btn-lg" value="Send"/>
            </form>
        </div>
    </body>
</html>
