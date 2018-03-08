/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udb.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author MekakuZero
 */
public class Servlet_Ingresaremp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ResultSet rs = null;
            Connection conexion = null;
            String ids=request.getParameter("codigo");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String telefono=request.getParameter("telefono");

            try{
                Class.forName("com.mysql.jdbc.Driver");
            
                conexion = DriverManager.getConnection ("jdbc:mysql://localhost/Guia7_POO1","root", "");
                
                // Permite ejecutar sentencias SQL sin parámetros
                Statement s = conexion.createStatement();
                
                s.executeUpdate("Insert into Empleados " + "values("+ids+",\""+nombre+"\",\""+apellido+"\",\""+telefono+"\")");
                rs = s.executeQuery ("select * from Empleados");
                
                //Decimos que nos hemos conectado
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>Datos Ingresados Exitosamente</h1>");
                out.println("<table align='center' with='75%' border=1>");
                out.println("<tr><th>Codigo</th><th>Nombres</th><th>Apellidos"+"</th><th>Telefono</th></tr>");
                
                while (rs.next()){
                    out.println("<tr><td>"+rs.getInt("Codigo")+"</td><td>"+
                    rs.getString("Nombre")+"</td><td>"+rs.getString("Apellidos")+"</td><td>"+
                    rs.getString("Telefono")+"</td></tr>");
                }
                
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
                
                conexion.close();
            }
            catch (ClassNotFoundException e1) {
            //Error si no puedo leer el driver
                out.println("ERROR:No encuentro el driver de la BD: "+
                e1.getMessage());
            }
            catch (SQLException e2) {
                //Error SQL: login/passwd mal
                out.println("ERROR:Fallo en SQL: "+e2.getMessage());
            }
            finally {
                out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
