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
        <title>JSP Page</title>
        <script>
            var table = document.getElementById("mytab1");
            for (var i = 0, row; row = table.rows[i]; i++) {
            }
        </script>
    </head>
    <body>
        <h3>Welkom ${CUSTOMERBEAN.getFirst_Name()}</h3>
        <div class="MijnProfiel">
                <h4>Hieronder uw resultaten:</h4>
                <div>
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
