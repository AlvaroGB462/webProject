<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/static/styleLogin.css' />">
</head>
<body>
    <div class="wrapper">
        <form id="login-form" class="form" action="/login" method="POST">
            <h1 class="title">Inicio</h1>
            
            <!-- Mostrar error si las credenciales son incorrectas -->
            <c:if test="${not empty error}">
                <div style="color: red; text-align: center;">${error}</div>
            </c:if>

            <div class="inp">
                <input type="email" id="email" name="email" class="input" placeholder="usuario o email" required>
                <i class="fa-solid fa-user"></i>
            </div>

            <div class="inp">
                <input type="password" id="password" name="password" class="input" placeholder="contraseña" required>
                <i class="fa-solid fa-lock"></i>
            </div>

            <button type="submit" class="submit">Iniciar sesión</button>
            <p class="footer">¿No tienes cuenta? <a href="#" class="link">Por favor, Regístrate</a></p>
        </form>
    </div>
</body>
</html>
