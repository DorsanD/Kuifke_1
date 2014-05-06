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
    <link href="./CSS/Account.css" rel="stylesheet">
    
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
          <a class="navbar-welcome" href="WelcomePageServlet">Welcome ${CUSTOMERBEAN.getFirst_Name()} to Kuifke</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="WelcomePageServlet">HOME</a></li>
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
            <li><a href="BIServlet">Business Intelligence </a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="AccountServlet">MY ACCOUNT</a></li>
            <li><a href="LogoutServlet">LOG OUT</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>  
    
        <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>My account</h1>
        <div class="table-responsive">
            <form action="AccountServlet" method="post">
            <table class="table">
            <tbody>
            <tr>
            <td>Username:</td>
            <td>${CUSTOMERBEAN.getUsername()} <a class="btn btn-primary btn-lg" type="submit">Change Username &raquo;</a></td>
            </tr>
            <tr>
            <td>Name:</td>
            <td>${CUSTOMERBEAN.getLast_Name()}</td>
            </tr>
            <tr>
            <td>Firstname:</td>
            <td>${CUSTOMERBEAN.getFirst_Name()}</td>
            </tr>
            <tr>
            <td>Gender:</td>
            <td>${CUSTOMERBEAN.getGender()}</td>
            </tr>
            <tr>
            <td>E-mail:</td>
            <td>${CUSTOMERBEAN.getEmail_Address()} <a class="btn btn-primary btn-lg" role="button">Change E-mail &raquo;</a></td></td>
            </tr>
            </tbody>
            </table>
            </form>
            </div>
        </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script> 
    </body>
</html>