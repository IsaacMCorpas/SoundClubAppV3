<%@page import="com.soundclub.models.Pais"%>
<%@page import="com.soundclub.models.Usuario"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>
<!DOCTYPE html>
<html lang="es">

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
<body class="backpag">

	<section class="muro">
		<style>
h1 {
	text-align: center;
}
</style>

<tl:header page="editarperfil" estilo="activo"></tl:header>
		<h1>
			<i class="fas fa-music">Edita tu perfil</i>
		</h1>
		<form method="POST" class="action" id="formulario>

			<label>Seleccione una imagen de perfil: <input type="file"
				id="files" name="files" />
			</label>
			<img src="${usuario.foto!=null?usuario.foto:" "}"">
			<output id="list"></output>
			<div id="foto"></div>
			<div class="texto">
				<label>Nombre de Usuario: <input
					placeholder="Ej: Laura (primera letra mayÃºs.)" type="text"
					name="nombre" id="nombre"
					value="${usuario.nombre!=null?usuario.nombre:" "}" required>
				</label>
			</div>
			<div class="texto">

				<label>Apellidos: <input placeholder="Ej: Garcia Martinez"
					value="${usuario.apellidos!=null?usuario.apellidos:"
					"}" type="text" name="apellidos" id="apellidos" required>
				</label>
			</div>
			<div class="correoelectronico" name="email">
			<label>Email: 
				<input value="${usuario.email!=null?usuario.email:""}" type="text" name="email" id="email" required>
				</label>
			</div>
			<div class="contraseña">
				<label>Password actual: <input type="password"
					name="actual_pass" id="cnt_origin"
					value="${usuario.password!=null?usuario.password: " "}"required>
				</label>
			</div>
			<div class="contraseña">
				<label>Nuevo Password: <input placeholder="Ej: $%&/(=)0' "
					type="password" name="passwordsignup" id="passwordsignup">
				</label>
			</div>
			<div class="contraseÃ±a">
				<label>Repita la nueva Password: <input
					placeholder="Ej: $%&/(=)0' " type="password"
					name="passwordsignup_confirm" id="passwordsignup_confirm">
				</label>
			</div>
			<!-- Paises -->
			<%-- <div class="paises">
				<select id="pais" name="pais" class="browser-default">
					<c:forEach var="pais" items="${Paises.get()}">
						<option
							value="${pais.getKey()}${usuario.pais_recide.equals(pais.getKey())?"selected":""}">${pais.getValue()}</option>
						<!-- Testear si funciona esta parte, tiene que salir el mapa seleccionado por el usuario, en caso de que tenga -->
					</c:forEach>
				</select> <label for="pais">Seleccione su pais:</label>
				
				PArte del antiguo OPTION ${usuario.pais_recide.equals(pais.getKey())?"selected":""}"

			</div>  --%>
			<div class="texto">
				<div>Paises:</div>
				<select id="pais" name="pais" class="browser-default">
					<c:forEach var="pais" items="${listaPaises}">
						<option value="${pais.cid}"> ${pais.nombre} </option>
					</c:forEach>
					 </select>
			</div>
			<div class="texto">
				<label>Ciudad: <input placeholder="Ej: ParÃ­s"

					value="${usuario.ciudad_recide!=null?usuario.ciudad_recide:""}"
					type="text" name="ciudad" id="ciudad"></label>
			</div>
			<div class="texto">
				<label>Calle o plaza, numero y piso: <input type="text"
					name="direccion" value="${usuario.calle!=null?usuario.calle:"
					"}"
					placeholder="Ej: Gran de Gracia, 150" id="direccion">
				</label>
			</div>
		
			Fecha de nacimiento: 
			<input type="date" name="fecha" value="<fmt:formatDate pattern = "yyyy-MM-dd" value="${usuario.fecha_nacimiento}"">
			
			
			<fieldset class="sexo">
				<legend>Seleccione su sexo:</legend>
				<p>
					<label> <input name="group" type="radio"
						${usuario.sexo==0?"checked":""} value="0"> <span>Varon</span>
					</label>
				</p>
				<p>
					<label> <input name="group" ${usuario.sexo==1?"checked":""}
						value="1" type="radio"> <span>Mujer</span>
					</label>
				</p>

			</fieldset>
			<div class="texto">
				<div>Instrumentos Favoritos:</div>
				<c:forEach var="Inst" items="${listaInstrumentos}">

					<label for="${Inst.nombre}"> <input type="checkbox"
						name="instrumento" id="${Inst.nombre}" value="${Inst.iid}">${Inst.nombre} <span></span>
					</label>

				</c:forEach>

			</div>


			<div class="texto">
				<div>Generos Musicales Favoritos:</div>
				<c:forEach var="Genre" items="${listaGeneros}">

					<label for="${Genre.nombre}"> <input type="checkbox"
						name="genero_musical" id="${Genre.nombre}" value="${Genre.mid}">${Genre.nombre}
						<span></span>
					</label>

				</c:forEach>

			</div>
			<br> <br>
			<button id="btn_Enviar" type="submit">
				Aceptar:</button>
			<button id="btnlimpiar" type="reset" value="Limpiar">
				Limpiar:</button>

			<!--  <div class="editar row">
            <button col type="submit" class="btn btn-primary">Editar</button>
        </div> -->
		</form>

	</section>
<tl:footer></tl:footer>

</body>

</html>