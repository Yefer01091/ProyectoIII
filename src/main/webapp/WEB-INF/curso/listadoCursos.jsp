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
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Docente</th>     
                                <th>Jornada</th>
                                <th>Codigo</th>
                                <th></th>


                            </tr>

                        </thead>

                        <tbody>
                            <%--recorremos los cursos--%>
                            <c:forEach var="cursos" items="${cursos}">
                                <tr>
                                    <td> ${cursos.id}</td>
                                    <td> ${cursos.nombre}</td>
                                    <td> ${cursos.profesor}</td>
                                    <td> ${cursos.jornada}</td>
                                    <td> ${cursos.codigo}</td>
                                    <td> 
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&id=${cursos.id}"  class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
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
                        <h3>Total de Cursos </h3>
                        <h4 class="display-4" value="${totalCursos}">
                            <i class="fas fa-book"></i> ${totalCursos}                          

                        </h4>
                    </div>
                </div>
            </div>
        </div>



    </div>
                          
</section>


<!--agregar curso-->


<jsp:include page="/WEB-INF/curso/agregarCurso.jsp"></jsp:include>  