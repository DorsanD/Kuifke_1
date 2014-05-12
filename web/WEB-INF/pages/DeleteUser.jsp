<%-- 
    Document   : DeleteUser
    Created on : 22-Apr-2014, 10:35:18
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./Images/Favicon.ico">
        <title>Delete user account</title>
        
         <!-- Bootstrap core CSS -->
    <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./CSS/WelcomePage.css" rel="stylesheet">
    <link href="./CSS/Contact.css" rel="stylesheet">

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
              <div class="container" id="contact">
              <div class="row">
              <div class="col-md-6 col-md-offset-3">
                <div class="well well-sm">
                  <form class="form-horizontal" action="" method="post">
                  <fieldset>
                    <legend class="text-center">Are you sure you want to delete this account?</legend>
                    <p>To confirm your request, fill in a reason here. You also need to provide us with your email address in case we got any questions regarding your request.</p>
                    <!-- Name input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="name">Username</label>
                      <div class="col-md-9">
                        <input id="name" name="name" type="text" placeholder="Your username" class="form-control">
                      </div>
                    </div>

                    <!-- Email input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="email">Your E-mail</label>
                      <div class="col-md-9">
                        <input id="email" name="email" type="text" placeholder="Your email" class="form-control">
                      </div>
                    </div>

                    <!-- Message body -->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="message">Reason</label>
                      <div class="col-md-9">
                        <textarea class="form-control" id="message" name="message" placeholder="Please enter your reason here..." rows="5"></textarea>
                      </div>
                    </div>

                    <!-- Form actions -->
                    <div class="form-group">
                      <div class="col-md-12 text-right">
                        <button type="submit" class="btn btn-primary btn-lg">Send request</button>
                      </div>
                    </div>
                  </fieldset>
                  </form>
                </div>
              </div>
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
