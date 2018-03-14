<%-- 
    Document   : comprobar
    Created on : 14-mar-2018, 20:17:08
    Author     : MekakuZero
--%>

<%
    HttpSession sesionOk = request.getSession();
    
    if (sesionOk.getAttribute("usuario") == null) {
%>
        <jsp:forward page="index.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>
<%
    }
%>