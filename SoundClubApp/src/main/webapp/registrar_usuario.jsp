<%@page import="com.soundclub.models.Usuario"%>
<%@page import="java.util.Hashtable"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!--Import Google Icon Font-->

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="assets/styles/materialize.min.css" media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.9/css/all.css"
	integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href="assets/styles/styles.css" type="text/css" rel="stylesheet"
	media="all" />
<link href="assets/styles/print.css" type="text/css" rel="stylesheet"
	media="print" />
<link href="assets/styles/screen.css" type="text/css" rel="stylesheet"
	media="screen" />
<!--Import Google Icon Font-->
<!--Import materialize.css-->
<!-- Compiled and minified CSS -->
</head>
<body class="backpag">
	<header>
		<nav>
			<div class="nav-wrapper">
				<a href="#"><img src="assets/images/LOGO2.png" width="180"
					alt="LOGO2"></a>
			</div>
		</nav>
	</header>

	<section class="muro">
		<form action="" method="POST" class="action" id="formulario">
			<h2>
				<i class="fas fa-music">Registrate</i>
			</h2>

			<label>Nombre<input type="text" placeholder="&#128272;"
				name="nombre" id="usuario" required></label> 
				<label>Apellidos<input
				type="text" placeholder="&#128272;" name="apellidos" id="Apellidos" 
				required></label> 
				<label>Email<input id="emailsignup" 
				name="emailsignup" type="email" placeholder="&#128272;" required></label> 
				<label>Contrasena<input type="password" id="passwordsignup" 
				minlength="3" maxlength="12" placeholder="&#128272;" name="clave"></label>
				 <label>Repite contrasena<input id="passwordsignup_confirm"
				minlength="3" maxlength="12" name="confirmar_clave"
				required="required" type="password" placeholder="&#128272;"/></label> 
				<input id="btnEnviar" type="submit" ></input>

		</form>
	</section>

	<footer>
		<div class="contenedor-menu">
			<br> <br>
		</div>
	</footer>
	<!--JavaScript at end of body for optimized loading-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="assets/scripts/materialize.min.js"></script>
	<script src="assets/scripts/headroom.min.js"></script>
	<script src="assets/scripts/materialize.min.js"></script>
	<script src="assets/scripts/init.js"></script>
	<script src="assets/scripts/scripts.js"></script>
	<script src="./assets/js/lista_usuario.js"></script>
	<script src="./assets/js/buscador.js"></script>
	<script src="./assets/js/autocompletado.js"></script>
	

</body>

</html>