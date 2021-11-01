/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import datos.CursoDaoJDBC;
import datos.EstudianteDaoJDBC;
import modelos.Curso;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelos.Estudiante;

/**
 *
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Estudiantes")) {
            List<Estudiante> estudiantes = new EstudianteDaoJDBC().listar();
            request.setAttribute("estudiantes", estudiantes);
            request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
        }

        if (menu.equals("Cursos")) {
            this.cargarcurso(request, response);

            if (accion.equals("Agregarcurso")) {
                this.insertarcurso(request, response);                
               

            }

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

    private void insertarcurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String profesor = request.getParameter("docente");
        String jornada = request.getParameter("jornada");
        String codigostring = request.getParameter("codigo");
        int codigo = Integer.parseInt(codigostring);

        Curso curso = new Curso(nombre, profesor, jornada, codigo);
        int cantidadregistros = new CursoDaoJDBC().insertar(curso);
        this.cargarcurso(request, response);

    }

    private void cargarcurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Curso> cursos = new CursoDaoJDBC().listar();
        System.out.print("cursos = " + cursos);
        request.setAttribute("totalCursos", cursos.size());
        request.setAttribute("cursos", cursos);
        request.getRequestDispatcher("cursos.jsp").forward(request, response);
    }

}
