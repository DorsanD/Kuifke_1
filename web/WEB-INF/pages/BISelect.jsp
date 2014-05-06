<%-- 
    Document   : BISelect
    Created on : 06-May-2014, 13:04:24
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
<form action="BIServlet" method="post">
            <select multiple class="form-control" id="SelectColumns" name="selectedColumns">
                <c:forEach items="${COLUMNS}" var="BIBean">
                    <option value=${BIBean.getId()} multiple>${BIBean.getTable()}.${BIBean.getColumn()}</option>
                </c:forEach>
            </select>
            <div class="form-group">
                <button type="submit" name="Next" class="btn btn-default">Voltooien</button>
            </div>
        </form>
    </body>
</html>
