<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/survey.css">
        <title>Vraag 1</title>
    </head>
    <body>
        <h1>Vraag 1</h1>
        Wilt u ook registreren op FlexBook?
        <form method="post">
            <input type="hidden" name="page" value="1" /> 
            <label for="selection1" >Zeker</label>
            <input id="selection1" type="radio" name="answer" value="0" required="true" />&nbsp;&nbsp;
            <label for="selection2" >Jazeker</label>
            <input id="selection2" type="radio" name="answer" value="1" />&nbsp;&nbsp;
            <label for="selection3" >Ja hoor</label>
            <input id="selection3" type="radio" name="answer" value="2"  />&nbsp;&nbsp;
            <label for="selection4" >Yup</label>
            <input id="selection4" type="radio" name="answer" value="3" />&nbsp;&nbsp;
            <label for="selection5" >Flexibledoodle</label>
            <input id="selection5" type="radio" name="answer" value="4" /><br/>            
            <input type="submit" value="Verder" />
        </form>
    </body>
</html>
