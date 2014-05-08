<%-- 
    Document   : BIResults
    Created on : 06-May-2014, 13:05:56
    Author     : Dorsan
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link href="./CSS/BIResults.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
        <script>
            var table = document.getElementById("mytab1");
            for (var i = 0, row; row = table.rows[i]; i++) {
            }
        </script>
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
        
        <div class="MijnProfiel">
                <h1>Hieronder kan u uw opgevraagde resultaten terugvinden:</h1>
                <div>
                    <h2>Download uw resultaten hier</h2>
                    <a class="BiKnop1" href="${EXCEL}"><button type="submit" class="btn btn-primary btn-block">Download als xls</button></a>
                    <a class="BiKnop1" href="${PDF}"><button type="submit" class="btn btn-primary btn-block" >Dowload als pdf</button></a>
                </div>
            <div class="table-responsive">
            <table class="table table-striped" id="mytab1">
                <tr>
                    <th colspan="4">Resultaten:</th>
                <tr/>

                <c:set var="teller" value="0" property="teller" />
                <c:forEach items="${SELCOLUMNS}" var="BIBean">
                    
                    <c:if test="${teller<AANTALCOL}">
                        <c:if test="${teller==0}" >
                            <tr> 
                            </c:if>  
                            <th> ${BIBean.getTable()}.${BIBean.getColumn()}</th>

                            <c:if test="${teller==AANTALCOL-1}" >
                            </tr> 
                        </c:if>  
                        <c:set var="teller" value="${teller+1}" property="teller" />  
                    </c:if>
                            
                </c:forEach>


                <c:set var="teller" value="0" property="teller" />
                <c:forEach items="${SELCOLUMNS}" var="BIBean">

                    <c:if test="${teller==0}" >
                        <tr> 
                        </c:if>  
                        <td> ${BIBean.getData()}</td>

                        <c:if test="${teller==AANTALCOL-1}" >
                            <c:set var="teller" value="-1" property="teller" />
                        </tr> 
                    </c:if>  
                    <c:set var="teller" value="${teller+1}" property="teller" />                       


                </c:forEach>
            </table>
        </div>
</div>
<div class="clearfix"></div>
    </div>
    </body>
</html>
