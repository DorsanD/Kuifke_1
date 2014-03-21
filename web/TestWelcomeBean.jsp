<%-- 
    Document   : welcome
    Created on : 13-Mar-2014, 10:46:18
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                    <%
            String a=session.getAttribute("username").toString();
            out.println("Hello  "+a);
            %>
            </h2>
            <br/>
            <br/>
            <br/><br/><br/><br/><br/>
        <a href="logout.jsp">Logout</a>

    </body>
</html>
