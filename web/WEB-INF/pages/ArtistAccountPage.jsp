<%-- 
    Document   : ArtistAccountPage
    Created on : 10-May-2014, 13:55:07
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
        <div class="jumbotron">
      <div class="container">
        <h1>My account</h1>
        <div class="table-responsive">
            <form action="AccountServlet" method="post">
            <table class="table">
            <tbody>
            <tr>
            <td>Username:</td>
            <td>${ARTISTBEAN.getUsername()}</td>
            </tr>
            <tr>
            <td>Name:</td>
            <td>${ARTISTBEAN.getLast_Name()} </td>
            </tr>
            <tr>
            <td>Firstname:</td>
            <td>${ARTISTBEAN.getFirst_Name()} <a href="ArtistAlterServlet">Change Name</a></td>
            </tr>
            <tr>
            <td>Gender:</td>
            <td>${ARTISTBEAN.getGender()}</td>
            </tr>
            <tr>
            <td>E-mail:</td>
            <td>${ARTISTBEAN.getEmail_Address()}</td></td>
            </tr>
            </tbody>
            </table>
            </form>
            </div>
        </div>
    </div>
            
            <a href="FileUploadServlet"> wenst u een track up te loaden? </a>
    </body>
</html>
