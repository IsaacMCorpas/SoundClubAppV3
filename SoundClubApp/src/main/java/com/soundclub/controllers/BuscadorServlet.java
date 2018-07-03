package com.soundclub.controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.soundclub.models.Usuario;
import com.soundclub.persistence.UsuarioEM;

@WebServlet("/buscador")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public BuscadorServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.getRequestDispatcher("buscador.jsp").forward(request, response);

	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
								
		String nombre= request.getParameter("user");
		//System.out.println("Nombre del usuario a buscar"+nombre);
		
		List<Usuario> newU = UsuarioEM.getInstance().getListaUsuarioBusqueda(nombre);
		//System.out.println("Lista de usuario a cargar"+newU);				
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);		
		StringWriter stringEmp = new StringWriter();
		
		objectMapper.writeValue(stringEmp, newU);
		
		System.out.println("Datos enviados"+stringEmp.toString());	
		response.setContentType("application/json");
		response.getWriter().append(stringEmp.toString()).flush();
		
	}
}