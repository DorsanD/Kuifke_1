<%-- 
    Document   : AlterUser
    Created on : 22-Apr-2014, 09:37:04
    Author     : Dorsan
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="AlterUserServlet" method="post">
            <input type="text" name="First_Name" value="${CUSTOMERBEAN.getFirst_Name()}"/>
            <input type="submit"/>
        </form>
    </body>
</html>
