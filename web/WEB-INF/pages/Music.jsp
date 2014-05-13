<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./Images/Favicon.ico">

    <title>Enjoy Our Music!</title>

    <!-- Bootstrap core CSS -->
    <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./CSS/WelcomePage.css" rel="stylesheet">
    <link href="./CSS/MusicPage.css" rel="stylesheet">

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
        
      <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Music</h1>
        <div class="table-responsive">
            <form action="AccountServlet" method="post">
            <table class="table">
            <tbody>
            <thead>
                <th>#</th>
                <th>Name</th>
                <th>Artist</th>
                <th>Time</th>
                <th>Genre</th>
            </thead>
            <tr class="white">
            <td>1</td>
            <td>Dammit</td>
            <td>Blink 182</td>
            <td>bla</td>
            <td>bla</td>
            </tr>
            <tr class="gray">
            <td>2</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            </tr>
            <tr class="white">
            <td>3</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            </tr>
            <tr class="gray">
            <td>4</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            </tr>
            <tr class="white">
            <td>5</td>
            <td>bla</td></td>
            <td>bla</td>
            <td>bla</td>
            <td>bla</td>
            </tr>
            </tbody>
            </table>
            </form>
            </div>
        </div>
    </div>  
          
        <div class="musicdiv">
            <p>Dammit - Blink 182</p>
                <audio controls>
                        <source src="./Music/Dammit.mp3" type="audio/mpeg" />
                        <a href="./Music/Dammit.mp3">Dammit</a>
                </audio>
        </div>
        

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <script src="./JS/docs.min.js"></script>
  </body>
</html>
