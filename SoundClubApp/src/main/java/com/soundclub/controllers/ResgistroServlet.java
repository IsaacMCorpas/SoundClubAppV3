package com.soundclub.controllers;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.soundclub.models.Usuario;
import com.soundclub.persistence.UsuarioEM;

@WebServlet("/registrar_usuario")
public class ResgistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		request.getRequestDispatcher("registrar_usuario.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("emailsignup");
		String password = request.getParameter("clave");
		String repassword = request.getParameter("confirmar_clave");

		
		
		
		Usuario nuevoUsu = new Usuario(0, nombre, apellidos, email, password);

		Hashtable errors = nuevoUsu.validar();
		boolean hayError = (boolean) errors.get("hayError");

		System.out.println(errors + "Usuario  registrado" + hayError);
		if (repassword == null || repassword.equals("") || (!repassword.equals(password))) {
			errors.put("password", "Password y repassword. Deben Coincidir");
			hayError=true;
		}


		System.out.println(errors + "Usuario  registrado" + hayError);
		if (!hayError) {
			response.setContentType("application/json");
			System.out.println("Usuario  registrado");
			UsuarioEM.getInstance().save(nuevoUsu);
			System.out.println(nuevoUsu);
			//DDBB.getInstancia().AnadirUsuario(nombre, apellidos, email, password);
			response.sendRedirect("login");
			

		} else {
			request.setAttribute("errors", errors);
			request.setAttribute("Usuario", nuevoUsu);
			System.out.println("Usuario no registrado");

			doGet(request, response);

		}
	}

}
