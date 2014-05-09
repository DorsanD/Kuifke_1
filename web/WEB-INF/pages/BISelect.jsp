<%-- 
    Document   : BISelect
    Created on : 06-May-2014, 13:04:24
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./Images/Favicon.ico">
        <title>Kuifke - Business Intelligence</title>
        
        <!-- Bootstrap core CSS -->
    <link href="./CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./CSS/WelcomePage.css" rel="stylesheet">
    <link href="./CSS/BISelect.css" rel="stylesheet">

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
        
         <h1>Select 1 or more fields from the list below.</h1>
         
         <form action="BIServlet" method="post">
            <select multiple class="form-control" id="SelectColumns" name="selectedColumns">
                <c:forEach items="${COLUMNS}" var="BIBean">
                    <option value=${BIBean.getId()} multiple>${BIBean.getTable()}.${BIBean.getColumn()}</option>
                </c:forEach>
            </select>
            <div class="form-group">
                <button type="submit" name="Next" class="btn btn-default">Submit</button>
            </div>
        </form>
    </body>
</html>
