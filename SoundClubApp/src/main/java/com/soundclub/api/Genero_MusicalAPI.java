package com.soundclub.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.soundclub.models.Genero_Musical;
import com.soundclub.models.StatusMessage;
import com.soundclub.persistence.Genero_MusicalEM;

@Path("/genero_musical")
public class Genero_MusicalAPI extends JSONService {
	private static Logger logger = Logger.getLogger("GeneroMusical");

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getGeneroMusical(@HeaderParam("token") String token) {
		int userId = this.getUserIdFromToken(token);

		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			logger.info("Estoy enviando lista generos_musicales ...");

			try {
				return Response.status(202).entity(Genero_MusicalEM.getInstance().getListaGenero_Musical()).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(500).entity("Ha habido un error al pedir genero_musical").build();
			}
		}
	}

	@Path("/{idgenero_musical}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getGeneroMusicalID(@PathParam(value = "idgenero_musical") int idgm) {
		Genero_Musical unGenero = Genero_MusicalEM.getInstance().getGenero_MusicalID(idgm);

		try {
			if (unGenero != null)
				return Response.status(202).entity(unGenero).build();
			else
				return Response.status(404).entity("El genero musical con este id no existe").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir la id del genero_musical").build();
		}
	}

}
