<%-- 
    Document   : ArtistAccountPage
    Created on : 10-May-2014, 13:55:07
    Author     : Dorsan
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

        <title>Artist | Account Page</title>

        <!-- Bootstrap core CSS -->
        <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./CSS/WelcomePage.css" rel="stylesheet">
        <link href="./CSS/Account.css" rel="stylesheet">
        <link href="./CSS/ArtistAccount.css" rel="stylesheet">

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
                    <a class="navbar-welcome" href="ArtistAccountServlet">Welcome ${ARTISTBEAN.getArtist_Name()} to Kuifke</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="ArtistAccountServlet">MY ACCOUNT</a></li>
                        <li><a href="ArtistLogoutServlet">LOG OUT</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <!-- Account info tabel -->
        <div class="jumbotron">
            <div class="container">
                <h1>My account</h1>
                <div class="table-responsive">
                    <form action="AccountServlet" method="post">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>Username:</td>
                                    <td>${ARTISTBEAN.getUsername()}</td>
                                </tr>
                                <tr>
                                    <td>Name:</td>
                                    <td>${ARTISTBEAN.getLast_Name()} </td>
                                </tr>
                                <tr>
                                    <td>Firstname:</td>
                                    <td>${ARTISTBEAN.getFirst_Name()} <a href="AlterArtistServlet" class="btn btn-primary btn-lg" type="submit">Change Name</a></td>
                                </tr>
                                <tr>
                                    <td>Gender:</td>
                                    <td>${ARTISTBEAN.getGender()}</td>
                                </tr>
                                <tr>
                                    <td>E-mail:</td>
                                    <td>${ARTISTBEAN.getEmail_Address()}</td></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>

        <!-- Upload a song en delete account links -->
        <div class="upload">
            <h2>Click here to upload a song:</h2>
            <a href="FileUploadServlet" class="btn btn-primary btn-lg" type="submit">Upload a song!</a>
        </div>

        <div class="upload">
            <h2>Click here to delete your account:</h2>
            <a href="ArtistDeleteServlet" class="btn btn-primary btn-lg" type="submit">Delete your account!</a>
        </div>

        <!-- Bootstrap core JavaScript
       ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./JS/bootstrap.min.js"></script>
        <script src="./JS/docs.min.js"></script>
    </body>
</html>

