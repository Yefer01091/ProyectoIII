<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="cursos">
    <div  clas="container">
        <div class="row">
            <div class="col-md-1"> </div>
            <div class="col-md-7">
                <div clas="card">
                    <div class="card-header">
                        <h4 listado de Cursos></h4>
                    </div>
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
                                    <a class="btn btn-secondary" href="Controlador?menu=Empleados&accion=Cargar&id=${usuario.getId()}" >
                                        <i class="fas fa-angle-double-right"></i> Editar </a>
                                    
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
             </div>

            </div>
            <div class="col-md-3"> 
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">                   
                        <h3>Total de estudiantes </h3>
                        <h4 class="display-4" value="${totalEstudiantes}">
                            <i class="fas fa-book"></i> ${totalEstudiantes}                          

                        </h4>
                    </div>
                </div>
            </div>
        </div>



    </div>
                          
</section>

<!--agregar curso-->


<jsp:include page="/WEB-INF/estudiante/agregarEstudiante.jsp"></jsp:include>  