<%-- 
    Document   : TrackUpload
    Created on : 22-Apr-2014, 11:02:23
    Author     : Dorsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form class="form-signin" action="FileUploadServlet" method="post" enctype="multipart/form-data" multiple>
            <input type="file" name="file"/>
            <input type="file" name="image"/>
            <input type="submit"/>
        </form>
        
    </body>
</html>
