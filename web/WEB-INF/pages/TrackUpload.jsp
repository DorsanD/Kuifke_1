<%-- 
    Document   : TrackUpload
    Created on : 22-Apr-2014, 11:02:23
    Author     : Dorsan
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="./Images/Favicon.ico">

        <title>Artist | Track Upload</title>

        <!-- Bootstrap core CSS -->
        <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./CSS/WelcomePage.css" rel="stylesheet">
        <link href="./CSS/ArtistAccount.css" rel="stylesheet">
        <link href="./CSS/AlterUser.css" rel="stylesheet">
        <link href="./CSS/TrackUpload.css" rel="stylesheet">

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

        <!-- Song upload formulier -->
        <h1>Upload a song!</h1>
        <div class="Alter">
            <form class="form-signin" action="FileUploadServlet" method="post" enctype="multipart/form-data" multiple>
                Select your music file: <input type="file" name="file" value="Choose a file" required="true"/>
                Select your album image: <input type="file" name="image" value="Choose a file" required="true"/>
                <input  class="btn btn-primary btn-lg" type="submit"value="Send"/>
            </form>
        </div>

        <!-- Bootstrap core JavaScript
       ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./JS/bootstrap.min.js"></script>
        <script src="./JS/docs.min.js"></script>
    </body>
</html>

