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
                    <a href="LugarTorneoServlet?action=cargarFormularioInsertar" class="btn btn-outline-warning">(+) Insertar</a>
                </div>
                <div class="col-4" align="center">
                    <h5>LUGAR TORNEOS</h5>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">
                    <table class="table table-sm table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Id Lugar Torneo</th>
                                <th>Nombre</th>
                                <th>Pais</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lugarTorneos}" var="lugarTorneo">
                                <tr>
                                    <td>${lugarTorneo.idLugarTorneo}</td>
                                    <td>${lugarTorneo.nombre}</td>
                                    <td>${lugarTorneo.nombrePais}</td>
                                    <td>
                                        <a href="LugarTorneoServlet?action=obtenerUno&idLugarTorneo=${lugarTorneo.idLugarTorneo}" class="btn btn-outline-success">Editar</a>
                                        <a href="LugarTorneoServlet?action=eliminar&idLugarTorneo=${lugarTorneo.idLugarTorneo}" class="btn btn-outline-danger">Eliminar</a>
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
