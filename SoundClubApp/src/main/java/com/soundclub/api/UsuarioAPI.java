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
