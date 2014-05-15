<%-- 
    Document   : DownloadPage
    Created on : 15-May-2014, 15:58:38
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
       <a href="./Music/${trackBean.getFile_Location()}">${trackBean.getFile_Location()}</a>
    </body>
</html>
