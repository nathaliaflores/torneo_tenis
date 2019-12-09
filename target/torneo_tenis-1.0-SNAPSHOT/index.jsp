<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Grand Slam</title>
    </head>

    <body id="body-index">
        <div class="container-fluid">
            <div class="row" id="navbar-index">
                <div class="col-12">
                    <nav class="navbar navbar-expand-lg">
                        <a class="navbar-brand text-dark" href="index.jsp">
                            <img src="img/icono-tennis.png" width="30" height="30" class="d-inline-block align-top" alt="">
                            GRAND SLAM
                        </a>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>    
            <br><br><br><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-4 mx-auto">
                    <form action="UsuarioServlet?action=obtenerUsuario" method="POST">
                        <div class="form-group">
                            <label for="usuario">USUARIO:</label>
                            <input type="text" class="form-control" id="usuario" name="usuario"/>
                        </div>
                        <div class="form-group">
                            <label for="password">PASSWORD:</label>
                            <input type="password" class="form-control" id="password" name="password"/>
                        </div>
                        <button type="submit" class="btn btn-warning btn-block">LOGINN</button>
                    </form>
                    ${msg}
                </div>
                <div class="col-3">

                </div>
            </div>
        </div>
        <%@include file="script.jsp" %>
    </body>   
</html>
