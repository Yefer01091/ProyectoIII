<div class="modal fade" id="agregarCursoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title"> Agregar Curso</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action=" ${pageContext.request.contextPath}/ServletControlador?menu=Cursos" method="POST" class="was-validated">
                <div class="modal-body">


                    <div class="form-group">
                        <label for="nombre">Nombre</label>                         
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="docente">Docente</label>
                        <input type="text" class="form-control" name="docente"required>
                    </div>
                    <div class="form-group">
                        <label for="jornada">Jornada</label>
                        <select class="form-control " name="jornada"required>
                            <option>diurna</option>
                            <option>noche</option>
                            <option>tarde</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="codigo">Codigo</label>
                        <input type="number" class="form-control" name="codigo"required>
                    </div>


                </div>
                <div class="model-footer">
                    <button class="btn-primary" type="submit" name="accion" value="Agregarcurso" >Guardar</button>

                </div>




            </form>



        </div>

    </div>