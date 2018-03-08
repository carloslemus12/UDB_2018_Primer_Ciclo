<%-- 
    Document   : principal
    Created on : 07-mar-2018, 0:11:18
    Author     : MekakuZero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession session_actual=request.getSession(false);
    String usuario =(String) session_actual.getAttribute("USER");
    String nombres =(String) session_actual.getAttribute("NAME");
    if (usuario==null){
        response.sendRedirect("login.html");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
