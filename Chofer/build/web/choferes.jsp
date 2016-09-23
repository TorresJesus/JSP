<%-- 
    Document   : usuarios
    Created on : 19-sep-2016, 14:54:38
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Chofer</title>
    </head>
    <body>
        <form action="ChoferController" method="post">
            <fieldset>
                <div>
                    <label>id de chofer: </label>
                    <input type="text" name="id_chofer" value="${chofer.idChofer}"
                           placeholder="idChofer"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Nombre: </label>
                    <input type="text" name="nombre" value="${chofer.nombre}"
                           placeholder="Nombre"/>
                </div>
                <div>       
                    <label>Email: </label>
                    <input type="text" name="email" value="${chofer.email}"
                           placeholder="Email"/>
                </div>
                <div>
                    <label>Telefono: </label>
                    <input type="text" name="telefono" value="${chofer.telefono}"
                           placeholder="Telefono"/>
                </div>
                <div>
                    <label>Direccion: </label>
                    <input type="text" name="direccion" value="${chofer.direccion}"
                           placeholder="Direccion"/>
                </div>
                <div>
                    <label>Edad: </label>
                    <input type="text" name="edad" value="${chofer.edad}"
                           placeholder="Edad"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
