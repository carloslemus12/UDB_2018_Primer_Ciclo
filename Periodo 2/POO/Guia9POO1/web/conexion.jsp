<%@ page language="java" import="java.sql.*" %>
<%
    Connection conexion = null;
    PreparedStatement st = null;
    ResultSet rs = null; 
    //Leemos el driver de Mysql
    Class.forName("com.mysql.jdbc.Driver");
    // Se obtiene una conexi�n con la base de datos.
    conexion = DriverManager.getConnection("jdbc:mysql://localhost/guia9poo1", "root", "");
    st = conexion.prepareStatement("");
%>