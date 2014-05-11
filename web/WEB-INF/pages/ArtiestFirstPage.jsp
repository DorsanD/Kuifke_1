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
        <title>Kuifke | Welcome artist !</title>
    </head>
    <body>
        <div class="Welcome-container">
            <div class="titel">Kuifke</div>
            <div class="tekst"><p>Artist administration pages</p></div>
        </div>
        <div class="SignUp-container">
            <div class="tekst"><p>Bring your music to the world!</p></div>
            <div class="knop2"><a class="btn btn-default btn-danger" data-target="#ArtistRegisterModal" data-toggle="modal"><span class="glyphicon glyphicon-music"></span> Sign up for free</a></div>
            <div class="login"><p>Already have an account? <a href="#" data-target="#ArtistModal" data-toggle="modal">Log in </a> here. </p></div>
        </div>
        
        <!-- Artist Sign up-->
        <div class="modal fade" id="ArtistRegisterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h2 class="modal-title" id="myModalLabel">Sign up</h2>
                    </div>
                    <div class="modal-body">
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
                 </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        
        
         <!-- Artist Log in-->
         <div class="modal fade" id="ArtistModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h2 class="modal-title" id="myModalLabel">Log in</h2>
                    </div>
                    <div class="modal-body">
                        <form class="form-signin" method="post" action="ArtistLoginServlet">
                            <input type="text" class="form-control" placeholder="Username" name="username" required="true" />                        
                            <input type="password" class="form-control" placeholder="Password" name="password" required="true" /> 
                            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" />
                        </form>
                     </div>
                   </div>
                </div>
         </div>
         
         <div class="footer">
            <div class="row">
                <div class="col-md-4" id="footer-left">Project Programmeren</div>
                <div class="col-md-4" id="footer-center">Kevin Reyns | Wouter Baeckelmans | Dorsan Demaeght</div>
                <div class="col-md-4" id="footer-right">&#169; 2014</div>
            </div>
        </div>
        
         <!-- Bootstrap core JavaScript
================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="./JS/modal.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="JS/bootstrap.min.js"></script>
        <script src="JS/docs.min.js"></script>
    </body>
</html>
