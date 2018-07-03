package com.soundclub.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundclub.models.Usuario;
import com.soundclub.persistence.UsuarioEM;

@WebServlet("/musuario")
public class DatoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("email")!=null) {
			String email=(String)session.getAttribute("email");
			
			int id_Usuario=Integer.parseInt(request.getParameter("id"));
			Usuario usuarioEncontrado=UsuarioEM.getInstance().getUsuarioID(id_Usuario);
			Usuario usuarioActivo=UsuarioEM.getInstance().getUsuarioEmail(email);
			//System.out.println("Los datos del usuario son  ::  "+usuarioEncontrado.getNombre()+usuarioEncontrado.getApellidos());
			
			boolean esAmigo=usuarioActivo.esAmigo(id_Usuario);   
			request.setAttribute("usuario", usuarioEncontrado);
			request.setAttribute("esAmigo", esAmigo);
			System.out.println("Paso la asignacion de variables  ::  ");
			request.getRequestDispatcher("usuario.jsp").forward(request, response);
		
		}else {
			response.sendRedirect("login");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
