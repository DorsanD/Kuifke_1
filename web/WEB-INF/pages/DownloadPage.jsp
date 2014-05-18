<%-- 
    Document   : DownloadPage
    Created on : 15-May-2014, 15:58:38
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="./Images/Favicon.ico">

        <title>Kuifke | Welcome</title>

        <!-- Bootstrap core CSS -->
        <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./CSS/WelcomePage.css" rel="stylesheet">
        <link href="./CSS/Account.css" rel="stylesheet">
        <link href="./CSS/DownloadPage.css" rel="stylesheet">

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
        
                <!-- Download link + bijhorende tekst en terugkeer knop -->
                <div class="downl">
        <h2> Please click on the link to download your song: </h2> 
        <a class="btn btn-primary btn-lg downl" href="./Music/${downloadid}" download>${downloadid}</a>
        <h3> You now have ${CUSTOMERBEAN.getCredits()} Credits left! </h3>
        <a id="knop" href="MusicPageServlet" class="btn btn-primary btn-lg" type="submit">Return to music!</a>
                </div>

    <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./JS/bootstrap.min.js"></script>
        <script src="./JS/docs.min.js"></script>
    </body>
</html>