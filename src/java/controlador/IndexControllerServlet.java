/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Util;

/**
 *
 * @author romina
 */
 @WebServlet (name="IndexControllerServlet",loadOnStartup=1,urlPatterns={"/index"})
public class IndexControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//   
//        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        String username = request.getParameter("usuarioFace");
////        String nombre = request.getParameter("nombreFace");
////        String apellido = request.getParameter("apellidoFace");
////        String email = request.getParameter("emailFace");
////        String fecha_nacimiento = request.getParameter("cumpleFace");
////        String ubicacion = request.getParameter("direccionFace");
////        String foto = request.getParameter("fotoFace");
////        
////        System.out.println("Entro al servlet");
////        
////        if (email != null) {
////                if ((email.compareTo("undefined") != 0)
////                        && (email.compareTo("") != 0)) {
////                    Util.usuario = IndexControlador.LogIn(username, nombre, apellido, email,
////                            fecha_nacimiento, ubicacion, foto);
////                    response.sendRedirect("inicio.jsp");
////                    System.out.println("Redirecciono");
////                }
////            }
//        
////        response.setContentType("text/html;charset=UTF-8");
////        PrintWriter out = response.getWriter();
////        try {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet IndexControllerServlet</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet IndexControllerServlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
////        } finally {            
////            out.close();
////        }
//    }
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        
        String username = request.getParameter("usuarioFace");
        String nombre = request.getParameter("nombreFace");
        String apellido = request.getParameter("apellidoFace");
        String email = request.getParameter("emailFace");
        String fecha_nacimiento = request.getParameter("cumpleFace");
        String ubicacion = request.getParameter("direccionFace");
        String foto = request.getParameter("fotoFace");
        
        System.out.println("Entro al servlet do get");
        
        if (email != null) {
                if ((email.compareTo("undefined") != 0)
                        && (email.compareTo("") != 0)) {
                    Util.usuario = IndexControlador.LogIn(username, nombre, apellido, email,
                            fecha_nacimiento, ubicacion, foto);
                    response.sendRedirect("inicio");
                    System.out.println("Redirecciono en do get");
                }
            }
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
