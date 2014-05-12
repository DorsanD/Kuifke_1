<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./Images/Favicon.ico">

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
        
        <h1>Discover</h1>
        
        
        <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/DudeRanch.jpg" onmouseover="this.src='./Images/DudeRanchP.jpg';" onmouseout="this.src='./Images/DudeRanch.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Blink 182</h4>
              <h5>Dammit</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="./Images/AppealToReason.jpg" onmouseover="this.src='./Images/AppealToReasonP.jpg';" onmouseout="this.src='./Images/AppealToReason.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Rise Against</h4>
              <h5>Hero Of War</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/PageAvenue.jpg" onmouseover="this.src='./Images/PageAvenueP.jpg';" onmouseout="this.src='./Images/PageAvenue.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Story Of The Year</h4>
              <h5>In The Shadows</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/DoesThisLookInfected.png" onmouseover="this.src='./Images/DoesThisLookInfectedP.jpg';" onmouseout="this.src='./Images/DoesThisLookInfected.png';"class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Sum 41</h4>
              <h5>Still Waiting</h5>
            </div>
          </div>
          
         <h1 id="top">Top rated hits</h1>   
        
         <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/Shotgun.jpg" onmouseover="this.src='./Images/ShotgunP.jpg';" onmouseout="this.src='./Images/Shotgun.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Yellow Claw</h4>
              <h5>Shotgun</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="./Images/LetItGo.jpg" onmouseover="this.src='./Images/LetItGoP.jpg';" onmouseout="this.src='./Images/LetItGo.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Demi Lovato</h4>
              <h5>Let It Go</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/DarkHorse.jpg" onmouseover="this.src='./Images/DarkHorseP.jpg';" onmouseout="this.src='./Images/DarkHorse.jpg';" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Katy Perry</h4>
              <h5>Dark Horse</h5>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="./Images/CleanBandit.jpg" onmouseover="this.src='./Images/CleanBanditP.jpg';" onmouseout="this.src='./Images/CleanBandit.jpg';"class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Clean Bandit</h4>
              <h5>Rather Be</h5>
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
