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
                    <form action="LugarTorneoServlet?action=insertar" method="POST">
                        <div class="form-group">
                            <label for="idLugarTorneo">ID LUGAR TORNEO:</label>
                            <input type="text" class="form-control" name="idLugarTorneo" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="nombre">NOMBRE:</label>
                            <input type="text" class="form-control" name="nombre"/>
                        </div>
                        <div class="form-group">
                            <label for="idPais">PAIS:</label>
                            <select class="form-control" name="idPais">
                                <c:forEach items="${paises}" var="pais">
                                    <option value="${pais.idPais}">${pais.nombre}</option>
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
