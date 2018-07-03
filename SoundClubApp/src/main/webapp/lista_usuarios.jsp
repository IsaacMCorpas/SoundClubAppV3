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
	<c:forEach var="unAmigo" items="${resultadoBusquesda}">
		<form action="" class="action">
			<section class="muro">
				<div>
					<ul class="collection">
						<li class="collection-item avatar"><img src="${unAmigo.foto}"
							alt="" class="circle"> <span> <span class="title">${unAmigo.nombre}</span>
								<span class="title">${unAmigo.apellidos}</span>

								</p> <a href="./musuario?id=${unAmigo.id}" class="secondary-content"> <i
									class="material-icons">email</i>
							</a></li>
				</div>
			</section>
		</form>
	</c:forEach>


	<tl:footer></tl:footer>



</body>

</html>