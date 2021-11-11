<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title"> Registro</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div>
            <form action=" ${pageContext.request.contextPath}/ServletControlador?menu=Usuario" method="POST" class="was-validated">
                <div class="modal-body">


                    <div class="form-group">
                        <label for="correo">Correo</label>                         
                        <input type="text" class="form-control" name="Correo" required>
                    </div>
                    <div class="form-group">
                        <label for="contrasena">Contraseña</label>
                        <input type="password" class="form-control" name="contrasena"required>
                    </div>
                    <div class="form-group">
                        <label for="contrasena2">Confirmacion de contraseña</label>
                        <input type="password" class="form-control" name="contrasena2"required>
                    </div>


                </div>
                <div class="model-footer">
                    <button class="btn-primary" type="submit" name="accion" value="AgregarUsuario" >Registrar</button>

                </div>




            </form>
                </div>



        </div>

    </div>