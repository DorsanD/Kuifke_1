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
        <link rel="shortcut icon" href="./Images/Favicon.ico">
        
        <title>USER | Buy Credits</title>
        
        <!-- Bootstrap core CSS -->
        <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./CSS/WelcomePage.css" rel="stylesheet">
        <link href="./CSS/AlterUser.css" rel="stylesheet">

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
                        <li><a href="MusicPageServlet">MUSIC</a></li>
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

            <!-- Koop credits formulier -->
            <h1>Buy some extra credits</h1>
            <div class="Alter">
                <p>Current amount of credits: ${CUSTOMERBEAN.getCredits()}</p>
                <form action="BuyCreditsServlet" method="post">         
                    Amount of credits to add: <input type="number" name="Credits"/>
                <input type="submit" class="btn btn-primary btn-lg" value="Send"/>
                </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="../../dist/js/bootstrap.min.js"></script> 
    </body>
</html>
