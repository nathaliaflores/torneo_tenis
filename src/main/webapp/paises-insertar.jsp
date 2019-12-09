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
                    <form action="PaisServlet?action=insertar" method="POST">
                        <div class="form-group">
                            <label for="idPais">ID PAIS:</label>
                            <input type="text" class="form-control" name="idPais" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="nombre">NOMBRE:</label>
                            <input type="text" class="form-control" name="nombre"/>
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
