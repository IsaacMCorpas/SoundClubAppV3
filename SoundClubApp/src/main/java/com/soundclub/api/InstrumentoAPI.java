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

import com.soundclub.models.Instrumento;
import com.soundclub.models.StatusMessage;
import com.soundclub.persistence.InstrumentoEM;

@Path("/instrumento")
public class InstrumentoAPI extends JSONService {
	private static Logger logger = Logger.getLogger("Instrumentos");

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getInstrumento(@HeaderParam("token") String token) {
		int userId = this.getUserIdFromToken(token);
		
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			logger.info("Estoy enviando lista generos_musicales ...");

			try {
				return Response.status(202).entity(InstrumentoEM.getInstance().getListaInstrumento()).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(500).entity("Ha habido un error al pedir un instrumento").build();
			}
		}
	}

	@Path("/{idinstrumento}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getInstrumentoID(@PathParam(value = "idinstrumento") int idi) {
		Instrumento unInstrumento = InstrumentoEM.getInstance().getInstrumentoID(idi);

		try {
			if (unInstrumento != null)
				return Response.status(202).entity(unInstrumento).build();
			else
				return Response.status(404).entity("El instrumento con este id no existe").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir la id del instrumento").build();
		}
	}
}
