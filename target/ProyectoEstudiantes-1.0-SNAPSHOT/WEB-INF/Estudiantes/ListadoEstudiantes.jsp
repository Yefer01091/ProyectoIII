<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="cursos">
     <div class="col-md-8">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">sexo</th>
                            <th scope="col">edad</th>
                            <th scope="col">cedula</th>
                            <th scope="col">telefono</th>
                            <th scope="col">semestre</th>
                            <th scope="col">idusuario</th>
                            <th scope="col">nombre</th>
                            <th scope="col">apellido</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="estudiantes" items="${estudiantes}">

                            <tr>
                                <th scope="row">${estudiantes.getId()}</th>
                                <td>${estudiantes.getSexo()}</td>
                                <td>${estudiantes.getEdad()}</td>
                                <td>${estudiantes.getCedula()}</td>
                                <td>${estudiantes.getTelefono()}</td>
                                <td>${estudiantes.getSemestre()}</td>
                                <td>${estudiantes.getIdusuario()}</td>
                                <td>${estudiantes.getNombre()}</td>
                                <td>${estudiantes.getApellido()}</td>
                               
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Cargar&id=${usuario.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&id=${usuario.getId()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
                          
</section>


<!--agregar curso-->


<jsp:include page="/WEB-INF/curso/agregarCurso.jsp"></jsp:include>  