/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import datos.UsuarioDaoJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    String error = "  ";
    Usuario usuario = new Usuario();
    UsuarioDaoJDBC usuarioDAO = new UsuarioDaoJDBC();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {

            String correo = request.getParameter("txtusuario");
            String contrasena = request.getParameter("txtpassword");
            //aca estoy guardando la respuesta del captcha
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

            usuario = usuarioDAO.Validar(correo, contrasena);
            //valido que el captcha este resuelto 
            //hay que ajuistarlo porque no verifico que este bien solo que lo  lleno 
            if ((usuario.getCorreo() != null) && (!gRecaptchaResponse.isEmpty())) {

                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("ServletControlador?menu=Principal").forward(request, response);

            } else {

                if (contrasena.isEmpty()) {
                    error = "Debe introducir una contraseña";
                } else if ((usuario.getCorreo() == null) && (!gRecaptchaResponse.isEmpty()) && (!contrasena.isEmpty())) {
                    error = " Contraseña incorrecta";

                } else if (gRecaptchaResponse.isEmpty()) {
                    error = "El captcha debe ser resuelto";
                } else {
                    error = "Ocurrio un error";
                }

                request.setAttribute("error", error);
                request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        }
        if (accion.equalsIgnoreCase("Salir")) {
            /*eliminara el cache para evitar que dandole a atras al navegador  recupere la session */
            response.setHeader("Clear-Site-Data", "\"cache\"");
            /*invalida la session*/
            request.getSession().invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
         if (accion.equalsIgnoreCase("Recuperarcontrasena")) {
             System.out.println("entro a recuperar contraseña");
         }
           
           

      

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
