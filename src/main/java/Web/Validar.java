/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

  
    
    Usuario usuario = new Usuario();
    UsuarioDaoJDBC usuarioDAO = new UsuarioDaoJDBC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            String correo= request.getParameter("txtusuario");
            String contrasena = request.getParameter("txtpassword");
            usuario = usuarioDAO.Validar(correo,contrasena);
            System.out.print("dato"+usuario.getCorreo());
            if(usuario.getCorreo()!= null){
                System.out.print("dato1"+usuario.getCorreo());
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("ServletControlador?menu=Principal").forward(request, response);
                

            }else{
                 request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            

        }
        if (accion.equalsIgnoreCase("Salir")) {
           /*eliminara el cache para evitar que dandole a atras al navegador  recupere la session */
             response.setHeader ("Clear-Site-Data", "\"cache\"");
             /*invalida la session*/
            request.getSession().invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            

        }
        
        else{ 
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
