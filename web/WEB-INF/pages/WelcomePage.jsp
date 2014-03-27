<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Welcome to Kuifke!</title>

    <!-- Bootstrap core CSS -->
    <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./CSS/WelcomePage.css" rel="stylesheet">

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
          <a class="navbar-logo" href="WelcomePage.jsp"><img class="logo" src="Images/Logo.png" height=80px width=100px></a>
          <a class="navbar-account" href="#">Welcome ${websiteBean.username}</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="WelcomePage.jsp">HOME</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">GENRES <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="divider"></li>
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
            <li><a href="#contact">ABOUT US</a></li>
            <li><a href="#contact">CONTACT</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="./">MY ACCOUNT</a></li>
            <li class="active"><a href="./">LOG OUT</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>       

          

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <script src="./JS/docs.min.js"></script>
  </body>
</html>