<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
              integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Grand Slam</title>
    </head>
    <body id="fondo-suave">
        <div class="container-fluid">
            <%@include file="navbar.jsp" %>
            <br><br>
            <div class="row">
                <div class="col-4">
                    <a href="TorneoModalidadFase?action=cargarFormularioInsertar" class="btn btn-outline-warning">(+) Insertar</a>
                </div>
                <div class="col-4" align="center">
                    <h5>TORNEOS-MODALIDADES-FASES</h5>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    <table class="table table-sm table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Id torneo-modalidad-fase</th>
                                <th>Id Torneo</th>
                                <th>Id Modalidad</th>
                                <th>Id Fase</th>
                                <th>Premio Consuelo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tmfs}" var="tmf">
                                <tr>
                                    <td>${tmf.idTmf}</td>
                                    <td>${tmf.nombreTorneo}</td>
                                    <td>${tmf.nombreModalidad}</td>
                                    <td>${tmf.nombreFase}</td>
                                    <td>${tmf.premioConsuelo}</td>
                                    <td>
                                        <a href="TorneoModalidadFase?action=obtenerUno&idTmf=${tmf.idTmf}" class="btn btn-outline-success">Editar</a>
                                        <a href="TorneoModalidadFase?action=eliminar&idTmf=${tmf.idTmf}" class="btn btn-outline-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> 
            </div>
        </div>
            <div class="modal fade" id="modalInsertar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">INSERTAR MARCA</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="MarcaServlet?action=insertar" method="POST">
                        <div class="form-group">
                            <label for="idMarca">ID MARCA:</label>
                            <input type="text" class="form-control" name="idMarca" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="nombre">NOMBRE:</label>
                            <input type="text" class="form-control" name="nombre"/>
                        </div>
                        <button class="btn btn-primary btn-block">INSERTAR</button>
                    </form>
                    </div>
                </div>
            </div>
        </div>
            
        <%@include file="script.jsp" %>
    </body>   
</html>
