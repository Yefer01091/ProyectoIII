<div class="modal fade" id="agregarEstudianteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title"> Agregar Estudiante</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action=" ${pageContext.request.contextPath}/ServletControlador?menu=Estudiantes" method="POST" class="was-validated">
                <div class="modal-body">


                    <div class="form-group">
                        <label for="nombre">Nombre</label>                         
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido"required>
                    </div>
                    <div class="form-group">
                        <label for="idusuario">Idusuario</label>
                        <input type="number" class="form-control" name="idusuario"required>
                    </div>

                    <div class="form-group">
                        <label for="semestre">Semestre</label>
                        <select class="form-control " name="semestre"required>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="number" class="form-control" name="telefono"required>
                    </div>
                    <div class="form-group">
                        <label for="cedula">Cedula</label>
                        <input type="number" class="form-control" name="cedula"required>
                    </div>
                     <div class="form-group">
                        <label for="edad">Edad</label>
                        <input type="number" class="form-control" name="edad"required>
                    </div>
                    <div class="form-group">
                        <label for="sexo">Sexo</label>
                        <select class="form-control " name="sexo"required>
                            <option>M</option>
                            <option>F</option>                           

                        </select>
                    </div>


                </div>
                <div class="model-footer">
                    <button class="btn-primary" type="submit" name="accion" value="Agregarestudiante" >Guardar</button>

                </div>




            </form>



        </div>

    </div>