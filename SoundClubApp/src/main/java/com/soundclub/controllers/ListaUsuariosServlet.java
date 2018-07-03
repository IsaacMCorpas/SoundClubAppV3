package com.soundclub.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soundclub.models.Usuario;
import com.soundclub.persistence.UsuarioEM;

@WebServlet("/lista_usuarios")
public class ListaUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener del request el keyword de carlos
		
			String keyword =request.getParameter("txtbusqueda");
			System.out.println("Mostrando Busqueda"+keyword);
			//pedir a base de datos la lista de usuarios que contengan la keyword en nombre, apellido, email
			List<Usuario> listaUsuario = UsuarioEM.getInstance().getListaUsuarioBusqueda(keyword);
			System.out.println(keyword+"::"+listaUsuario);
			
			//guardar resultados en variable listaUsuarios
			request.setAttribute("resultadoBusquesda", listaUsuario);
			
		//request.setAttribute("usuario", );
		request.getRequestDispatcher("lista_usuarios.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtener del request el keyword de carlos
	
		String keyword =request.getParameter("txtbusqueda");
		System.out.println("Mostrando Busqueda"+keyword);
		//pedir a base de datos la lista de usuarios que contengan la keyword en nombre, apellido, email
		List<Usuario> listaUsuario = UsuarioEM.getInstance().getListaUsuarioBusqueda(keyword);
		System.out.println(keyword+"::"+listaUsuario);
		
		//guardar resultados en variable listaUsuarios
		request.setAttribute("resultadoBusquesda", listaUsuario);
		
		//pasar al jsp la variable listaUsuarios mediante request.setAttribute
		doGet(request, response);
	}

}
