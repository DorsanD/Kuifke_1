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
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

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
          <a class="navbar-welcome" href="WelcomePage">Welcome ${CUSTOMERBEAN.getUsername()} to Kuifke</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="WelcomePage.jsp">HOME</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">GENRES <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Dance</a></li>
                <li class="divider"></li>
                <li><a href="#">Electro</a></li>
                <li class="divider"></li>
                <li><a href="#">Hip Hop</a></li>
                <li class="divider"></li>
                <li><a href="#">Pop</a></li>
                <li class="divider"></li>
                <li><a href="#">Rock</a></li>
                <li class="divider"></li>
                <li><a href="#">Other</a></li>
              </ul>
            </li>
            <li><a href="#contact">RECENT RELEASES</a></li>
            <li><a href="#contact">STORE</a></li>
            <li><a href="AboutUsServlet">ABOUT US</a></li>
            <li><a href="ContactServlet">CONTACT</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="ConfirmServlet">MY ACCOUNT</a></li>
            <li><a href="LogoutServlet">LOG OUT</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>  
        
        <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <img src="./Images/dorsan.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Dorsan Demaeght</h2>
          <p>Dorsan is our back-end programmer. blabla...</p>
      </div>
        <div class="col-md-4">
          <img src="./Images/kevin.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Kevin Reyns</h2>
          <p>Kevin makes some front-end pages blabla</p>
      </div>
        <div class="col-md-4">
          <img src="./Images/wouter.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
          <h2>Wouter Baeckelmans</h2>
          <p>Wouter argues about colors and shit.</p>
      </div>
      </div>
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>            
    </body>
</html>