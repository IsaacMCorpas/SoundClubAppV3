package com.soundclub.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soundclub.models.Genero_Musical;
import com.soundclub.models.Instrumento;
import com.soundclub.models.Pais;
import com.soundclub.models.Usuario;
import com.soundclub.persistence.UsuarioEM;
import com.soundclub.persistence.Genero_MusicalEM;
import com.soundclub.persistence.InstrumentoEM;
import com.soundclub.persistence.PaisesEM;

@WebServlet("/editarperfil")
public class EditarperfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Obtiene Sesion! :: DOGET");
		HttpSession session = request.getSession();

		Usuario usuario = UsuarioEM.getInstance().getUsuarioEmail((String) session.getAttribute("email"));

		List<Instrumento> listaInstrumento = InstrumentoEM.getInstance().getListaInstrumento();
		List<Pais> listaPaises = PaisesEM.getInstance().getListaPais();
		List<Genero_Musical> listaGeneros = Genero_MusicalEM.getInstance().getListaGenero_Musical();
		// pasar usuarioActual al JSP mediante request.Attribute
		request.setAttribute("listaInstrumentos", listaInstrumento);
		request.setAttribute("listaPaises", listaPaises);
		request.setAttribute("listaGeneros", listaGeneros);
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("editarperfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Empezamos!");
		HttpSession session = request.getSession();

		Usuario usuarioActual = UsuarioEM.getInstance().getUsuarioEmail((String) session.getAttribute("email"));
		System.out.println("Obtiene Sesion!");
		int id_Usuario = usuarioActual.getId();

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String pais_recide = request.getParameter("pais");
		int idPais = Integer.parseInt(pais_recide);
		String ciudad_recide = request.getParameter("ciudad");
		String calle = request.getParameter("direccion");
		String password = request.getParameter("actual_pass");
		String newpassword = request.getParameter("passwordsignup");
		String[] instrumentos = request.getParameterValues("instrumento");
		String[] generoMusical = request.getParameterValues("genero_musical");
		String fotoPerfil = request.getParameter("files");
		String fecha_nacimiento = request.getParameter("fecha");
		String sexos = request.getParameter("group");
		Usuario usuarioToUpdate = new Usuario();
		// usuarioToUpdate.setId(id_Usuario);
		System.out.println("He cargado datos");
		usuarioToUpdate.setId(id_Usuario);
		usuarioToUpdate.setNombre(nombre);
		usuarioToUpdate.setApellidos(apellidos);
		usuarioToUpdate.setEmail(email);
		usuarioToUpdate.setPassword(password);
		usuarioToUpdate.setCiudad_recide(ciudad_recide);
		usuarioToUpdate.setCalle(calle);
		Pais unPais = PaisesEM.getInstance().getPaisID(idPais);
		System.out.println("He obtenido id Pais");
		usuarioToUpdate.setPais_recide(unPais);
		usuarioToUpdate.setFoto(fotoPerfil);
		System.out.println("tusmuelas:" + instrumentos);

		DateFormat formatter;
		Date fechanacimiento_date;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechanacimiento_date = formatter.parse(fecha_nacimiento);
			System.out.println("fecha: " + fechanacimiento_date);
			usuarioToUpdate.setFecha_nacimiento(fechanacimiento_date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int sexo_user = Integer.parseInt(sexos);
		usuarioToUpdate.setSexo(sexo_user);

		List<Instrumento> listaInstrumentos = new ArrayList<Instrumento>();

		for (String unInstrumento : instrumentos) {
			listaInstrumentos.add(new Instrumento(Integer.parseInt(unInstrumento), ""));
			System.out.println("VALOR DE: " + unInstrumento);
		}

		//
		usuarioToUpdate.setListaInstrumento(listaInstrumentos);
		System.out.println("HASTA AQUI PARECE FUNCIONAR");

		List<Genero_Musical> listaGenero_musical = new ArrayList<Genero_Musical>();

		for (String unGenero : generoMusical) {
			listaGenero_musical.add(new Genero_Musical(Integer.parseInt(unGenero), ""));

			System.out.println("VALOR DE: " + unGenero);
		}
		usuarioToUpdate.setListaGenero_musical(listaGenero_musical);
		System.out.println("Funciona lista de generos?");

		Hashtable errors = usuarioToUpdate.validar();
		System.out.println("ERRORES: " + errors);
		boolean hayError = (boolean) errors.get("hayError");

		if (!hayError) {
			response.setContentType("application/json");
			System.out.println("Usuario  editado");
			UsuarioEM.getInstance().update(usuarioToUpdate);
			System.out.println(usuarioToUpdate);
			response.sendRedirect("principal");

		} else {
			request.setAttribute("errors", errors);
			request.setAttribute("Usuario", usuarioToUpdate);
			System.out.println("Usuario no editado");

			doGet(request, response);

		}
	}

}