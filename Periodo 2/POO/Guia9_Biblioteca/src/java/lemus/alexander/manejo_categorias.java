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
public class manejo_categorias extends HttpServlet {

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
            
            try{
                Categorias categoria = new Categorias();
                
                if (request.getSession().getAttribute("model_categoria") != null) {
                    categoria = (Categorias)request.getSession().getAttribute("model_categoria");
                }                

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty())
                    categoria.setId(Integer.valueOf(request.getParameter("id")));
                else
                    categoria.setId(0);

                if (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty())
                    categoria.setCategoria(request.getParameter("nombre"));
                else
                    categoria.setCategoria("");

                switch (request.getParameter("Accion")) {
                    case "Guardar":
                        if (categoria.guardar())
                            response.sendRedirect("/Guia9_Biblioteca/categorias.jsp");
                        else
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        break;
                    case "Eliminar":
                        if (categoria.eliminar())
                            response.sendRedirect("/Guia9_Biblioteca/categorias.jsp");
                        else
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        break;
                    case "Modificar":
                        if (categoria.actualizar())
                            response.sendRedirect("/Guia9_Biblioteca/categorias.jsp");
                        else
                            response.sendRedirect("/Guia9_Biblioteca/error.jsp");
                        break;
                }

                out.println(categoria.toString());
            } catch(Exception error){
                out.println(error.getMessage() + " <br> " + error.getLocalizedMessage());
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
