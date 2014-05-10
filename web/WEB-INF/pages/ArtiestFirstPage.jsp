<%-- 
    Document   : ArtiestFirstPage
    Created on : 10-May-2014, 11:23:13
    Author     : Dorsan
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="Kuifke_1.dao.WebsiteDao"%>
<%@page import="Kuifke_1.domain.ArtistBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <link rel="shortcut icon" href="./Images/Favicon.ico">
        <link href="./CSS/Bootstrap CSS/bootstrap.css" rel="stylesheet">
        <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">
        <link href="CSS/Registratie.css" rel="stylesheet">
        <link href="./CSS/FirstPage.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>

        
        <!-- Artist Sign up-->

                        <form class="form-signin" role="form" method="post">
                            <input type="text" class="form-control" placeholder="Artist Name" name="Artist_Name" required="true" />
                            <input type="text" class="form-control" placeholder="Name" name="lastname" required="true" />
                            <input type="text" class="form-control" placeholder="First Name" name="firstname" required="true" />
                            <select class="dropd" name="gender" required="true">
                                <option value="M">M</option>
                                <option value="F">F</option>
                            </select>
                            <input type="email" class="form-control" placeholder="Email-Address" name="email" required="true" /> 
                            <input type="text" class="form-control" placeholder="Username" name="username" required="true" /> 
                            <input type="password" class="form-control" placeholder="Password" name="password" required="true" /> 
                            
                            <select class="dropd" name="language">
                                <option value="nederlands">Nederlands</option>
                                <option value="engels">English</option>
                            </select></br></br>
                            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign Up" />
                        </form>
                

        
        
         <!-- Artist Log in-->
      

                        <form class="form-signin" method="post" action="ArtistLoginServlet">
                            <input type="text" class="form-control" placeholder="Username" name="username" required="true" /> 
                            <input type="password" class="form-control" placeholder="Password" name="password" required="true" /> 

                            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" />
                        </form>
                   
    </body>
</html>
