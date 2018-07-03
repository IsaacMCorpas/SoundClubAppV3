package com.soundclub.api;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.soundclub.models.StatusMessage;
import com.soundclub.persistence.UsuarioEM;


@Path("/usuario")
public class UsuarioAPI  extends JSONService {
	private static Logger logger=Logger.getLogger("Usuarios");
	
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getListaUsuarios(@HeaderParam("token") String token) {
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {

			try {
				if (usuarios != null)
					return Response.status(Status.OK.getStatusCode()).entity(usuarios).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode()).entity("La lista no existe").build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al pedir la lista de usuarios").build();
			}
		}
	}

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response AddUsuario(Usuario nuevoUsuario) {
		try {
			return Response.status(Status.OK.getStatusCode()).entity(UsuarioEM.getInstance().save(nuevoUsuario))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Ha habido un error al crear el nuevo Usuario").build();
		}
	}
	
	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getUnUsuario(@HeaderParam("token") String token, @PathParam(value = "idUsuario") int idUs) {
		Usuario usuarioAObtener = UsuarioEM.getInstance().getUsuarioID(idUs);
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			try {
				if (usuarioAObtener != null)
					return Response.status(Status.OK.getStatusCode()).entity(usuarioAObtener).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode()).entity("El usuario con este Id no existe")
							.build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al acceder a la info. de este Usuario").build();
			}
		}
	}

	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteUsuario(@HeaderParam("token") String token, @PathParam(value = "idUsuario") int idUs) {
		Usuario usuarioABorrar = UsuarioEM.getInstance().getUsuarioID(idUs);
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			try {
				if (usuarioABorrar != null)
					return Response.status(Status.OK.getStatusCode())
							.entity(UsuarioEM.getInstance().borrar(usuarioABorrar)).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode()).entity("El usuario con este Id no existe")
							.build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al acceder al intentar borrar este Usuario").build();
			}
		}
	}

	@Path("/{idUsuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response actualizarUsuario(@HeaderParam("token") String token, @PathParam(value = "idUsuario") int idUs,
			Usuario unUsuarioActualizado) {
		Usuario usuarioAActualizar = UsuarioEM.getInstance().getUsuarioID(idUs);
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			try {
				if (usuarioAActualizar != null)
					return Response.status(Status.OK.getStatusCode())
							.entity(UsuarioEM.getInstance().update(unUsuarioActualizado)).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode()).entity("El usuario con este Id no existe")
							.build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al acceder al intentar actualizar a este Usuario").build();
			}
		}
	}

	@Path("/query")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getListaUsuariosBusqueda(@HeaderParam("token") String token, @QueryParam("name") String name) {

		List<Usuario> usuarioCoincide = UsuarioEM.getInstance().getListaUsuarioBusqueda(name);
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			try {
				if (usuarioCoincide != null)
					return Response.status(Status.OK.getStatusCode()).entity(usuarioCoincide).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode())
							.entity("Ningun Usuario coincide con este nombre").build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al acceder al intentar acceder a esta lista de Usuarios").build();
			}

		}
	}

	@Path("/{id}/instrumentos")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getListaInstrumento(@HeaderParam("token") String token, @PathParam(value = "id") int idUsuario) {
		int userId=this.getUserIdFromToken(token);
		if(userId<=0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}else {		
			try {
				return Response.status(202).entity(UsuarioEM.getInstance().getInstrumentosUsuarioID(idUsuario)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(404).entity("El objeto no existe").build();
			}
		}

	}	
	
	@Path("/{id}/generos_musicales")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getListaGeneros_Musicales(@HeaderParam("token") String token, @PathParam(value = "id") int idUsuario) {
		int userId=this.getUserIdFromToken(token);
		if(userId<=0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}else {
			try {
				return Response.status(202).entity(UsuarioEM.getInstance().getGeneros_MusicalesUsuarioID(idUsuario)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(404).entity("El objeto no existe").build();
			}
		}
	}	
	
	
	@Path("/{id}/amigos")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getListaAmigos( @HeaderParam("token") String token, @PathParam(value = "id") int idUsuario) {
		int userId=this.getUserIdFromToken(token);
		if(userId<=0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}else {
			try {
				return Response.status(202).entity(UsuarioEM.getInstance().getAmigosUsuarioID(idUsuario)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(404).entity("El objeto no existe").build();
			}
		}

	}
	
	
	
}
