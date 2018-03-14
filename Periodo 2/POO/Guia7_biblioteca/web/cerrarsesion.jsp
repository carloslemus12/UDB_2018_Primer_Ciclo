<%-- 
    Document   : cerrarsesion
    Created on : 14-mar-2018, 15:17:55
    Author     : MekakuZero
--%>

<%@ page session="true" %>
    <%
     HttpSession sesionOk = request.getSession();
     sesionOk.invalidate();
    %>
<jsp:forward page="index.jsp"/>
