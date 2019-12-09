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
                    <form action="TorneoModalidadFase?action=insertar" method="POST">
                        <div class="form-group">
                            <label for="idTmf">ID TORNEO-MODALIDAD-FASE:</label>
                            <input type="text" class="form-control" name="idTmf" value = "${tmf.idTmf}" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="idTorneo">TORNEO:</label>
                            <select class="form-control" name="idTorneo">
                                <c:forEach items="${torneos}" var="torneo">
                                    <option value="${torneo.idTorneo}"<c:if test="${torneo.idTorneo == tmf.idTorneo}">selected</c:if> >${torneo.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idModalidad">MODALIDAD:</label>
                            <select class="form-control" name="idModalidad">
                                <c:forEach items="${modalidades}" var="modalidad">
                                    <option value="${modalidad.idModalidad}" <c:if test="${modalidad.idModalidad == tmf.idModalidad}">selected</c:if> >${modalidad.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idFase">FASE:</label>
                            <select class="form-control" name="idFase">
                                <c:forEach items="${fases}" var="fase">
                                    <option value="${fase.idFase}" <c:if test="${fase.idFase == tmf.idFase}">selected</c:if>>${fase.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="premioConsuelo">PREMIO CONSUELO:</label>
                            <input type="text" class="form-control" name="premioConsuelo"/>
                        </div>
                        <button class="btn btn-primary btn-block">ACTUALIZAR</button>
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
