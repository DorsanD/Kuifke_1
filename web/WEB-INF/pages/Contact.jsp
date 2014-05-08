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
                    <legend class="text-center">Contact us</legend>
                    <p>We're happy to answer any questions you have or provide you with an estimate. Just send us a message in the form below with any questions you may have.</p>
                    <!-- Name input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="name">Name</label>
                      <div class="col-md-9">
                        <input id="name" name="name" type="text" placeholder="Your name" class="form-control">
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
                      <label class="col-md-3 control-label" for="message">Your message</label>
                      <div class="col-md-9">
                        <textarea class="form-control" id="message" name="message" placeholder="Please enter your message here..." rows="5"></textarea>
                      </div>
                    </div>

                    <!-- Form actions -->
                    <div class="form-group">
                      <div class="col-md-12 text-right">
                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                      </div>
                    </div>
                  </fieldset>
                  </form>
                </div>
              </div>
                </div>
        </div>
    </body>
</html>
