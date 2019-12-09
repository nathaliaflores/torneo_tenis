<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Grand Slam</title>
    </head>
    <body>
        <div class="container-fluid">
            <%@ include file="navbar.jsp" %>
            <br><br> <br><br>
            <div class="row" align="center">
                <div class="col-4">
                    <div class="card" id="modulos">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-3">
                                    <img src="img/mantenimiento.png">
                                </div>
                                <div class="col-9">
                                    <h5 class="card-title">
                                        MANTENIMIENTOS
                                    </h5>
                                </div>
                            </div>
                            <br>
                            <a href="mantenimientos.jsp" class="btn btn-warning btn-block">ENTRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="card" id="modulos">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-3">
                                    <img src="img/torneo.png">
                                </div>
                                <div class="col-9">
                                    <h5 class="card-title">
                                        TORNEOS
                                    </h5>
                                </div>
                            </div>
                            <br>
                            <a href="torneo.jsp" class="btn btn-warning btn-block">ENTRAR</a>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="card" id="modulos">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-3">
                                    <img src="img/historial.png">
                                </div>
                                <div class="col-9">
                                    <h5 class="card-title">
                                        HISTORIAL
                                    </h5>
                                </div>
                            </div>
                            <br>
                            <a href="alquiler.jsp" class="btn btn-warning btn-block">ENTRAR</a>
                        </div>
                    </div>
                </div>
            </div>
    <%@ include file="script.jsp" %>
</body>
</html>
