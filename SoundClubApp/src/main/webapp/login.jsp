<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->

    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="assets/styles/materialize.min.css" media="screen,projection" />
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
    crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="assets/styles/styles.css" type="text/css" rel="stylesheet" media="all" />
    <link href="assets/styles/print.css" type="text/css" rel="stylesheet" media="print" />
    <link href="assets/styles/screen.css" type="text/css" rel="stylesheet" media="screen" />

</head>
<body class="backpag">
<header>
    <nav> 
        <div class="nav-wrapper">
            <a href="#"><img src="assets/images/LOGO2.png" width="180" alt="LOGO2"></a>
        </div>
    </nav>
</header>
<section class="muro">
        <form method="POST" class="action" id="formulario">
            <h2><i class="fas fa-music">Iniciar Sesion</i></h2>
            <div class="error" id="showError">${error!=null?error:""}</div>
            <label>Login<input type="text" placeholder="&#128272; Correo electronico" value="" name="usuario" id="usuario"></label>
            <label>Password<input type="password" id="passwordsignup" minlength= "3" maxlength="12" placeholder="&#128272;Contraseña" name="passwordsignup"></label>
            <input id="btnEntrar" type="submit" value="Entrar"><a href="./registrar_usuario">Registrate ahora</a>
        </form>
</section>
<footer>
        <div class="contenedor-menu">
            <br>
            <br>
        </div>
</footer>

</body>


</html>