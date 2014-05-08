<%-- 
    Document   : Contact
    Created on : 24-apr-2014, 11:10:36
    Author     : Kevin
--%>

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

    <title>Contact</title>

    <!-- Bootstrap core CSS -->
    <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./CSS/WelcomePage.css" rel="stylesheet">
    <link href="./CSS/AboutUs.css" rel="stylesheet">
    
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
        
        <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-welcome" href="WelcomePageServlet">Welcome ${CUSTOMERBEAN.getUsername()} to Kuifke</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="WelcomePageServlet">HOME</a></li>
            <li><a href="AboutUsServlet">ABOUT US</a></li>
            <li><a href="ContactServlet">CONTACT</a></li>
            <li><a href="BIServlet" class="BI">BUSINESS INTELLIGENCE</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="AccountServlet">MY ACCOUNT</a></li>
            <li><a href="LogoutServlet">LOG OUT</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>  
        
        <!-- About us - Columns -->
      <div class="row">
        <div class="col-md-4">
          <img src="./Images/dorsan.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Dorsan Demaeght</h2>
          <p>Dorsan is our back-end programmer. With his extended knowledge in Java he made the back-end.
              Besides this, he also was the 'leader' of the team and checked that everyone fullfilled their tasks in time.<p>
      </div>
        <div class="col-md-4">
          <img src="./Images/kevin.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Kevin Reyns</h2>
          <p>Kevin mainly focussed on the front-end. With the use of Bootstrap he made the layout of our website.
             He also decided the color patterns we were going to use and made the Mock-Ups.</p>
      </div>
        <div class="col-md-4">
          <img src="./Images/wouter.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Wouter Baeckelmans</h2>
          <p>Wouter mainly helped Kevin with the front-end. Besides this, he also made the database and was our project leader. He made the scrum reports and used the tool 'Trello' to help him do so.</p>
      </div>
      </div>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>            
    </body>
</html>
