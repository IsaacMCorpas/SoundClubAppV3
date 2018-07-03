<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>
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
</head>
<body>
<header></header>
	<tl:header page="lista_usuarios" estilo="activo"></tl:header>
	<section class="muro">
		<form action="" class="action">
			<div id="usuario" idusuario="500" class="remitente">
				<div id="foto">
					<img class="fotoremitente" src="${usuario!=null?usuario.foto:''}"
						alt="Foto del usuario">
				</div>
				<div id="nombre" class="nombre_remitente">${usuario.nombre!=null?usuario.nombre:""}
					${usuario.apellidos!=null?usuario.apellidos:""}</div>
			</div>
			<div class="mensaje">
				<div id="agregar-amigo" data-id="${usuario.id}">
					<a href="#"> <i class="medium material-icons">
							${esAmigo?"person":"person_add"} </i>
					</a>
				</div>
				<div>
					<a href="#"> <i class="medium material-icons">contact_mail</i>
					</a>
				</div>

			</div>
			<div id="vive" class="vive">
				<i class="Medium material-icons"> location_on </i>
				${usuario.ciudad_recide!=null?usuario.ciudad_recide:""}
			</div>
			<div id="descripcion" class="descripcion"></div>

			<div id="instrumentos">
				<h5>Domino estos instrumentos</h5>
				
				<c:forEach var="unInstrumento" items="${usuario.listaInstrumento}"
					varStatus="counter">
					<label> <input type='checkbox' checked='checked'
						disabled='disabled' /> <span>${unInstrumento.nombre}</span>
					</label>

				</c:forEach>
			</div>

			<br> <br>
			<div id="instrumentos">
				<h5>Gustos Musicales</h5>
				
				<c:forEach var="unGeneroMusical" items="${usuario.listaGenero_musical}"
					varStatus="counter">
					<label> <input type='checkbox' checked='checked'
						disabled='disabled' /> <span>${unGeneroMusical.nombre}</span>
					</label>

				</c:forEach>
			</div>
		</form>
	</section>
	
	<tl:footer></tl:footer>
</body>
	<script type="text/javascript" src="./assets/js/"></script>
</html>



