<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="./Images/Favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/survey.css">
        <title>User | Registration confirmation</title>
    </head>
    <body>
        <h1>Confirmation</h1>
        Dear ${websiteBean.name}, <br/>
        We noted the following details of your registration : <br />

        
        Last Name: ${websiteBean.name}
        <br />
        First Name: ${websiteBean.firstname}
        </br>
        Gender:         ${websiteBean.gender}
        <br/>
        E-mail:         ${websiteBean.email}
        <br/>
        Username:        ${websiteBean.username}
        <br/>
        
        Language:         ${websiteBean.language}
        <br/>

        <p>
            We thank you for your registration! </p>
    </body>
</html>
