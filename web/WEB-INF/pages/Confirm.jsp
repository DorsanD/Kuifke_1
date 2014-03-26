<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/survey.css">
        <title>Bevestiging</title>
    </head>
    <body>
        <h1>Bevestiging</h1>
        Beste ${websiteBean.name}, <br/>
        Wij hebben hetvolgende genoteerd: <br />

        
        Naam: ${websiteBean.name}
        <br />
        Voornaam: ${websiteBean.firstname}
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
            Wij danken u voor de registratie! </p>
    </body>
</html>
