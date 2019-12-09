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
    <body>
        <div class="container-fluid">
            <%@include file="navbar.jsp" %>
            <br><br><br><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-4 mx-auto">
                    <form action="TorneoServlet?action=insertar" method="POST">
                        <div class="form-group">
                            <label for="idTorneo">ID TORNEO:</label>
                            <input type="text" class="form-control" name="idTorneo" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="nombre">NOMBRE:</label>
                            <input type="text" class="form-control" name="nombre"/>
                        </div>
                        <div class="form-group">
                            <label for="anio">AÑO:</label>
                            <input type="text" class="form-control" name="anio"/>
                        </div>
                        <div class="form-group">
                            <label for="premio">PREMIO:</label>
                            <input type="text" class="form-control" name="premio"/>
                        </div>
                        <div class="form-group">
                            <label for="idLugarTorneo">LUGAR TORNEO:</label>
                            <select class="form-control" name="idLugarTorneo">
                                <c:forEach items="${lugarTorneos}" var="lugarTorneo">
                                    <option value="${lugarTorneo.idLugarTorneo}">${lugarTorneo.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-primary btn-block">INSERTAR</button>
                    </form>
                </div>
                <div class="col-3">
                    <span style="color: red " class="font-weight-bold">${msg}</span>
                    
                </div>
            </div>
        </div>
        <%@include file="script.jsp" %>
    </body>   
</html>
