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

/**
 *
 * @author MekakuZero
 */
public class manejo_libros extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try{
                Libros libro = new Libros();
                
                if (request.getSession().getAttribute("modelo_libro") != null) {
                    libro = (Libros)request.getSession().getAttribute("modelo_libro");
                }                

                if (request.getParameter("txtId") != null && !request.getParameter("txtId").isEmpty())
                    libro.setId(Integer.valueOf(request.getParameter("txtId")));
                else
                    libro.setId(0);
                
                if (request.getParameter("cantidad") != null && !request.getParameter("cantidad").isEmpty())
                    libro.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
                else
                    libro.setCantidad(0);
                
                if (request.getParameter("categoria") != null && !request.getParameter("categoria").isEmpty())
                    libro.setCategoria(Integer.valueOf(request.getParameter("categoria")));
                else
                    libro.setCategoria(0);
                
                if (request.getParameter("titulo") != null && !request.getParameter("titulo").isEmpty())
                    libro.setTitulo(request.getParameter("titulo"));
                else
                    libro.setTitulo("");
                
                if (request.getParameter("isbn") != null && !request.getParameter("isbn").isEmpty())
                    libro.setIsbn(request.getParameter("isbn"));
                else
                    libro.setIsbn("");
                
                if (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty())
                    libro.setDescripcion(request.getParameter("descripcion"));
                
                if (request.getParameter("edicion") != null && !request.getParameter("edicion").isEmpty())
                    libro.setEdicion(request.getParameter("edicion"));
                else
                    libro.setEdicion("");
                
                switch (request.getParameter("Accion")) {
                    case "Guardar libro":
                        if (libro.guardar())
                            response.sendRedirect("/Guia9_Biblioteca/libros.jsp");
                        else {
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        }   break;
                    case "Eliminar":
                        if (libro.eliminar())
                            response.sendRedirect("/Guia9_Biblioteca/libros.jsp");
                        else {
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        }   break;
                    case "Modificar libro":
                        if (libro.actualizar())
                            response.sendRedirect("/Guia9_Biblioteca/libros.jsp");
                        else {
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        }   break;
                    default:
                        break;
                }
                
                out.println(libro.toString());
            } catch(Exception error) {
                out.println(error.getMessage() + "<br>" + error.getLocalizedMessage() + "<br>" + error.toString());
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
