/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import datos.CursoDaoJDBC;
import modelos.Curso;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String menu = request.getParameter("menu");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Estudiantes")) {
            List<Curso> cursos = new CursoDaoJDBC().listar();
            request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
        }
        if (menu.equals("Cursos")) {
            List<Curso> cursos = new CursoDaoJDBC().listar();
            System.out.print("cursos = " + cursos);
            request.setAttribute("totalCursos", cursos.size());
            request.setAttribute("cursos", cursos);
            request.getRequestDispatcher("cursos.jsp").forward(request, response);

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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
