<%-- 
    Document   : listaChofer
    Created on : 19-sep-2016, 14:55:49
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Chofer</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="chofer" items="${chofer}">
                    <tr>
                        <td>${chofer.idChofer}</td>
                        <td>${chofer.nombre}</td>
                        <td>${chofer.email}</td>
                        <td>${chofer.telefono}</td>
                        <td>${chofer.direccion}</td>
                        <td>${chofer.edad}</td>
                        <td><a href="ChoferController?action=cambiar&idChofer=${chofer.idChofer}">Cambiar</a></td>
                        <td><a href="ChoferController?action=borrar&idChofer=${chofer.idChofer}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ChoferController?action=agregar">Nuevo Chofer</a>
        </p>
    </body>
</html>
