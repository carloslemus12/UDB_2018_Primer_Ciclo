/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemus.alexander;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import mojica.alexander.consulta.Conexion;
import mojica.alexander.consulta.Query;
import mojica.alexander.utilidades.Mensaje;
import mojica.alexander.utilidades.Modelo;

/**
 *
 * @author MekakuZero
 */
public class accionCategoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String accion = request.getParameter("Accion");
            
        try {
            PrintWriter out = response.getWriter();
            
            Conexion con;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + accion + "accionCategoria</title>");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />");            
            out.println("</head>");
            out.println("<body>");
            
            if ((con = Conexion.establecerConexion()) != null) {
                
                if (accion.equals("Eliminar")) {
                    if (con.crearQuery("categoria_libro").where("id", Integer.valueOf(id)).delete() > 0) {
                        response.sendRedirect("/Guia7_biblioteca/categorias.jsp");
                    } else
                        out.println("<h1>La accion de " + accion.toLowerCase() + " no se ha podido realizar</h1>");
                } else if(accion.equals("Modificar")) {
                    
                    out.println("<form action='accionCategoria' method='POST'>");
                    out.println("<div class=\"form-row align-items-center d-flex justify-content-center bg-dark p-3\">");
                    
                    out.println("<div class=\"col-auto\">");
                    out.println("<input id='id' class=\"form-control mt-2\" type='hidden' value='" + id + "' name='id'/>");
                    out.println("</div>");
                    
                    out.println("<div class=\"col-auto\">");
                    out.println("<input id='nombre' class=\"form-control mt-2\" type='text' value='"+ nombre + "' name='nombre' placeholder='Categoria' />");
                    out.println("</div>");
                    
                    out.println("<div class=\"col-auto\">");
                    out.println("<input id='btnAccion' class=\"form-control mt-2 btn btn-primary\" type='submit' value='GuardarCambio' name='Accion'/>");
                    out.println("</div>");
                    
                    out.println("</div>");
                    
                    out.println("<div id=\"errorId\" class=\"alert alert-danger mx-5 d-none\" role=\"alert\"></div>");
                    out.println("<div id=\"errorNombre\" class=\"alert alert-danger mx-5 d-none\" role=\"alert\"></div>");

                    out.println("</form>");
                    
                } else if(accion.equals("GuardarCambio")) {
                    if (con.crearQuery("categoria_libro")
                            .agregarCampoValor("categoria", nombre)
                            .where("id", Integer.valueOf(id))
                            .update() > 0) {
                        response.sendRedirect("/Guia7_biblioteca/categorias.jsp");
                    } else
                        out.println("<h1>La accion de modificar no se ha podido realizar</h1>");
                } else {
                    if (con.crearQuery("categoria_libro")
                            .agregarCampoValor("categoria", nombre)
                            .agregarCampoValor("id", Integer.valueOf(id))
                            .insert()> 0) {
                        response.sendRedirect("/Guia7_biblioteca/categorias.jsp");
                    } else
                        out.println("<h1>La accion de modificar no se ha podido realizar</h1>");
                }
                
            } else 
                out.println("<h1>La accion de " + accion.toLowerCase() + " no se ha podido realizar</h1>");
            
            out.println("<script src='js/validacionCategoria.js'></script>");
            out.println("</body>");
            out.println("</html>");
        }  catch(Exception ex){
            try(PrintWriter out = response.getWriter()){
                out.println(ex.getMessage() + " - " + id);
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
