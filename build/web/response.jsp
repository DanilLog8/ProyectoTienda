<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Respuesta de Compra</title>
        
    </head>
    <body>
        
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            <%-- Lógica para mostrar SweetAlert según el resultado de la compra --%>
            <% if (request.getAttribute("success") != null) {%>
        Swal.fire({
            icon: 'success',
            title: '¡Compra exitosa!',
            text: '<%= request.getAttribute("success")%>',
            confirmButtonText: 'Aceptar'
        }).then(() => {
            // Redirige a la página "MostrarArticulo"
            window.location.href = 'MostrarArticulo';
        });
            <% } else if (request.getAttribute("error") != null) {%>
        Swal.fire({
            icon: 'error',
            title: 'Error en la compra',
            text: '<%= request.getAttribute("error")%>',
            confirmButtonText: 'Aceptar'
        }).then(() => {
            // Regresa a la página anterior
            window.history.back();
        });
            <% }%>
        </script>
    </body>
</html>