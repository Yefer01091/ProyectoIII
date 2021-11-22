<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
     
    <div class="col-md-2">
        
        <div class="card-body">
            <h5 class="card-title">Cursos</h5>
            <h6 class="card-subtitle mb-2 text-muted">Gestion de cursos</h6>


            <form action="ServletControlador?menu=Cursos" method="POST" class="was-validated">
                <div class="modal-body">


                    <div class="form-group">
                        <label for="nombre">Curso</label>                         
                        <input type="text" class="form-control" name="nombre" required  value="${cur.getNombre()}">
                    </div>
                    <div class="form-group">
                        <label for="docente">Docente</label>
                        <input type="text" class="form-control" name="docente"required value="${cur.getProfesor()}">
                    </div>
                    <div class="form-group">
                        <label for="jornada">Jornada</label>
                        <select class="form-control " name="jornada"required value="${cur.getJornada()}">
                            <option>diurna</option>
                            <option>noche</option>
                            <option>tarde</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="codigo">Codigo</label>
                        <input type="number" class="form-control" name="codigo"required value="${cur.getCodigo()}"> 
                    </div>


                </div>
                <div class="model-footer">
                    <button class="btn-primary" type="submit" name="accion" value="Agregarcurso" >Guardar</button>


                    <button class="btn-primary" type="submit" name="accion" value="Editarcurso" >Editar</button>

                </div>




            </form>
        </div>
    </div>
    
    <div class="col-md-10">
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
                                       
                                        <th>Curso</th>
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
                                           
                                            <td> ${cursos.nombre}</td>
                                            <td> ${cursos.profesor}</td>
                                            <td> ${cursos.jornada}</td>
                                            <td> ${cursos.codigo}</td>
                                            <td> 
                                                <a href="ServletControlador?menu=Cursos&accion=cargarcurso&id=${cursos.id}"  class="btn btn-success">
                                                  <i class="fas fa-pen"></i>
                                                </a>

                                            </td>
                                            <td> 
                                                <a href="ServletControlador?menu=Cursos&accion=eliminarcurso&ide=${cursos.id}"  class="btn btn-danger">
                                                    <i class="fas fa-trash-alt"></i>
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
    </div>
</div>


<!--agregar curso-->


