<div class="modal fade" id="recuperarContrasenaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title"> Recuperar contraseña</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div>
            <form action=" ${pageContext.request.contextPath}/Validar?menu=Usuario" method="POST" class="was-validated">
                <div class="modal-body">


                    <div class="form-group">
                        <label for="correo">Correo</label>                         
                        <input type="text" class="form-control" name="Correo" required>
                    </div>
                   


                </div>
                <div class="model-footer">
                    <button class="btn-primary" type="submit" name="accion" value="Recuperarcontrasena" >Recuperar</button>

                </div>




            </form>
                </div>



        </div>

    </div>