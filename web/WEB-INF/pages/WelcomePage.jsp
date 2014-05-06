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
        <style>

body {
  margin: 0;
  background: #222;
  min-width: 960px;
}

rect {
  fill: none;
  pointer-events: all;
}

circle {
  fill: none;
  stroke-width: 2.5px;
}

</style>
    
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
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="AccountServlet">MY ACCOUNT</a></li>
            <li><a href="LogoutServlet">LOG OUT</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>   
            <script src="http://d3js.org/d3.v3.min.js"></script>
<script>

var width = Math.max(960, innerWidth),
    height = Math.max(500, innerHeight);

var i = 0;

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

svg.append("rect")
    .attr("width", width)
    .attr("height", height)
    .on("ontouchstart" in document ? "touchmove" : "mousemove", particle);

function particle() {
  var m = d3.mouse(this);

  svg.insert("circle", "rect")
      .attr("cx", m[0])
      .attr("cy", m[1])
      .attr("r", 1e-6)
      .style("stroke", d3.hsl((i = (i + 1) % 360), 1, .5))
      .style("stroke-opacity", 1)
    .transition()
      .duration(2000)
      .ease(Math.sqrt)
      .attr("r", 100)
      .style("stroke-opacity", 1e-6)
      .remove();

  d3.event.preventDefault();
}

</script>

<div class="footer">
  <div class="row-footer">    
    <div class="col-xs-6 col-sm-6 col-md-3 column">          
      	<h4>Follow Us</h4>
        <ul class="nav">
          <li><a href="#">Facebook</a></li>
          <li><a href="#">Twitter</a></li>
        </ul> 
      </div>
    <div class="col-xs-6 col-md-3 column">          
      	<h4>Contact Us</h4>
        <ul class="nav">         
          <li><a href="#">contact.kuifke@gmail.com</a></li>
         </ul> 
      </div>
    <div class="col-xs-6 col-md-3 column">          
      	<h4>Created by</h4>
        <ul class="nav">
          <li>Wouter Baeckelmans</li>
          <li>Kevin Reyns</li>
          <li>Dorsan Demaeght</li>
        </ul> 
      </div>
    <div class="col-xs-6 col-md-3 column">   
      	<h4>(c) 2014. All rights reserved.</h4>
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
