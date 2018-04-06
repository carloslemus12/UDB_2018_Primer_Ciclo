/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojica.alexander.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mojica.alexander.modelo.UsuarioModelo;
import mojica.alexander.pojo.Usuario;

/**
 *
 * @author MekakuZero
 */
public class login extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()){
            try {
                // Obtenemos la informacion del formulario
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                if (username.trim().isEmpty() || password.trim().isEmpty()) {
                    request.setAttribute("mensaje_Error", "Ambos campos son obligatorios");
                    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
                
                // Creamos el javabeans
                UsuarioModelo usuario = new UsuarioModelo(new Usuario(username, password));

                if (usuario.login()) { // Los datos son validos
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", usuario.getUsuario());
                    response.sendRedirect("/poo_parcial_web_2/index.jsp");
                } else {
                    request.setAttribute("mensaje_Error", "EL nombre del usuario y la clave no coinciden");
                    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
                    dispatcher.forward(request, response);
                }
            }
            catch(Exception error) {
                request.setAttribute("mensaje_Error", "Error: " + error.getMessage());
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
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
