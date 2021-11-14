
<!-- <meta http-equiv="refresh"  content="0;url=${pageContext.request.contextPath}/ServletControlador">  -->
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/39cd639674.js" crossorigin="anonymous"></script>
        <script src="https://js.hcaptcha.com/1/api.js" async defer></script>
        <title>Hello, world!</title>

    </head>
    <body>
        <br>
        <br>
        <div class="container center-block" >
            <div class="row justify-content-center">
                <div class="card" style="width: 22rem;">
                    <img src="logou.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <form method="POST" action="Validar">
                            <div class="form-group">
                                <label>Correo</label>

                                <input type="email" class="form-control" name="txtusuario">
                                <small id="emailHelp" class="form-text text-muted">Ingrese su correo electronico</small>                                

                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Contraseña</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="txtpassword">
                            </div>
                            <br>
                            <div class="mb-1" >
                                <div  class="h-captcha" data-sitekey="01a09185-6d16-44d1-84ae-c0fc29380766" >

                                </div>

                                <label style="color: red">${error}</label>
                            </div>
                            <button type="submit" class="btn btn-primary" name="accion" value="Ingresar">Ingresar</button>
                             <button type="submit" class="btn btn-primary" name="accion" value="recuperar">Recuperar Contraseña</button>
                            <br>
                          
                            <div>
                                <a href=" # "class="nav-link"
                                   data-bs-toggle="modal" data-bs-target="#recuperarContrasenaModal">
                                    <i ></i> Olvido su contraseña
                                </a>                                 
                            </div>
                    </div> 

                    </form>
                </div>
            </div>
        </div>  
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
   
    
   

</body>
<jsp:include page="/WEB-INF/usuario/recuperarContrasena.jsp" flush="true"></jsp:include>
</html>
