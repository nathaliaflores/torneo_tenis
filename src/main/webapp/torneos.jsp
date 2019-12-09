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
                    <a href="TorneoServlet?action=cargarFormularioInsertar" class="btn btn-outline-warning">(+) Insertar</a>
                </div>
                <div class="col-4" align="center">
                    <h5>TORNEOS</h5>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    <table class="table table-sm table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Id Torneo</th>
                                <th>Nombre</th>
                                <th>Año</th>
                                <th>Premio</th>
                                <th>Lugar Torneo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${torneos}" var="torneo">
                                <tr>
                                    <td>${torneo.idTorneo}</td>
                                    <td>${torneo.nombre}</td>
                                    <td>${torneo.anio}</td>
                                    <td>${torneo.premio}</td>
                                    <td>${torneo.nombreLugarTorneo}</td>
                                    <td>
                                        <a href="TorneoServlet?action=obtenerUno&idTorneo=${torneo.idTorneo}" class="btn btn-outline-success">Editar</a>
                                        <a href="TorneoServlet?action=eliminar&idTorneo=${torneo.idTorneo}" class="btn btn-outline-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> 
            </div>
        </div>
        <%@include file="script.jsp" %>
    </body>   
</html>
