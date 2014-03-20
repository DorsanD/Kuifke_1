<%-- 
    Document   : LoginCheck
    Created on : 13-Mar-2014, 10:50:02
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
        <%
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        if((username.equals("Kuifke") && password.equals("Bertje123")))
            {
            session.setAttribute("username",username);
            response.sendRedirect("welcome.jsp");
            }
        else
            response.sendRedirect("Error.jsp");
        %>
    </body>
</html>
