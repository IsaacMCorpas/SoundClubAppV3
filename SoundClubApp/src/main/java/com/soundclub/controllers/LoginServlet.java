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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("email")==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("principal");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("usuario");
		String pass=request.getParameter("passwordsignup");
		Usuario unUsuario=UsuarioEM.getInstance().getUsuarioEmailPass(email, pass);
		
		System.out.println("entro al DoPOST del login" +email+" :: "+pass);
		
		if(unUsuario!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("email", unUsuario.getEmail());
			System.out.println("entro al DoPOST del login  :: usuario existe");
			response.sendRedirect("principal");
		}else {
			request.setAttribute("error", "Error al logearte:: login / password incorrectos!!");
			request.setAttribute("usuario", email);
			System.out.println("entro al DoPOST del login :: usuario no  existe");
			this.doGet(request, response);
		}
		
	}

}
