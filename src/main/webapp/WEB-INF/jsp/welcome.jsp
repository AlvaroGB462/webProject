<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
</head>
<body>
    <header style="display: flex; justify-content: space-between; align-items: center; padding: 20px;">
        <a href="#" class="u-logo">
            <img src="images/default-logo.png" alt="Logo" style="height: 40px;">
        </a>
        <div id="user-info" style="flex-grow: 1; text-align: center;">
            <c:if test="${not empty usuario}">
                <c:if test="${usuario.admin}">
                    <a href="/admin" class="u-btn u-button-style u-gradient u-text-body-alt-color u-btn-1">Ir a la administración</a>
                </c:if>
                <c:if test="${!usuario.admin}">
                    <span>${usuario.email}</span>
                </c:if>
            </c:if>
        </div>
        <a href="/logout" title="Cerrar sesión">
            <span class="u-icon u-icon-user">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                    <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"/>
                </svg>
            </span>
        </a>
    </header>
</body>
</html>
