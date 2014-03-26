<%-- 
    Document   : Registratie
    Created on : 27-Feb-2014, 09:04:14
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
            <!-- Bootstrap core CSS -->
    <link href="CSS/Bootstrap CSS/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="CSS/Registratie.css" rel="stylesheet">

    </head>
    <body>
        
        <div class="container">

        
        <form class="form-signin" role="form" method="post">
            <h2 class="form-signin-heading">Sign up</h2>
            <input type="text" class="form-control" placeholder="Name" name="name" required="true" />
            <input type="text" class="form-control" placeholder="First Name" name="firstname" required="true" />
            <input type="email" class="form-control" placeholder="Email-Address" name="email" required="true" /> 
            <input type="text" class="form-control" placeholder="Username" name="username" required="true" /> 
            <input type="password" class="form-control" placeholder="Password" name="password" required="true" /> 
            <select class="dropd" name="gender" required="true">
			<option value="M">M</option>
			<option value="F">F</option>
			<option value="Other">Other</option>
		</select>
            <select class="dropd" name="language">
			<option value="nederlands">Nederlands</option>
			<option value="engels">English</option>
		</select></br></br></br>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Verder" />
        </form>
    </body>
</html>
