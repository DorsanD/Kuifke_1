<%-- 
    Document   : LogIn
    Created on : 13-Mar-2014, 10:14:22
    Author     : Dorsan
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="Kuifke_1.dao.WebsiteDao"%>
<%@page import="Kuifke_1.domain.CustomerBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>    </head>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap core CSS -->
        <link href="CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="CSS/Registratie.css" rel="stylesheet">

    </head>
    <body>
        
        
        <form class="form-signin" action="Login" method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" class="form-control" placeholder="Username" name="username" required="true" /> 
            <input type="password" class="form-control" placeholder="Password" name="password" required="true" /> 

            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" />

            
        </form>

    </body>
</html>
