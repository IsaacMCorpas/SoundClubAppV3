<%@ attribute name="page" required="true" type="java.lang.String"%>
<%@ attribute name="estilo" required="true" type="java.lang.String"%>
<header>
	<nav>
		<ul id="dropdown1" class="dropdown-content">
			<!-- <li class="tab disabled"><a href="./editarperfil">Perfil</a></li>
			<li><a href="./editarperfil">Editar</a></li>
			<li class="divider"></li> -->
			<li><a href="./logout">Cerrar Sesion</a></li>
		</ul>
		<div class="nav-wrapper">
			<a href="principal"><img src="assets/images/LOGO2.png"
				width="180" alt="LOGO2"></a>
			<ul id="imgheader" class="right hide-on-med-and-down">
				<li><a href="./editarperfil"><img
						src="https://materializecss.com/images/yuna.jpg" alt="foto_perfil"
						class="circle"></a>
				<li><a class="dropdown-trigger" href="#!"
					data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</div>
	</nav>

	<div >
	<form id="fsbusqueda" method="GET" action="./lista_usuarios">
                        <input type="search" name="txtbusqueda" id="txtbusqueda"  placeholder=" Buscar..." >
                        <button id="btnbusqueda" type="submit">
                            <i id="fa fa-search" class="fa fa-search"></i>
                        </button>
                    </form>
                     <div id="sugerencias"></div>
		
	</div>
</header>