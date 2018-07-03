package com.soundclub.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.soundclub.persistence.InstrumentoEM;

@Path("/instrumento")
public class InstrumentoAPI extends JSONService {
	private static Logger logger=Logger.getLogger("Instrumentos");
	
	
@Path("")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getListaInstrumento() {
	try {
		return Response.status(202).entity(InstrumentoEM.getInstance().getListaInstrumento()).build();
	} catch (Exception e) {
		e.printStackTrace();
		return Response.status(404).entity("El objeto no existe").build();
	}
	
}





}
