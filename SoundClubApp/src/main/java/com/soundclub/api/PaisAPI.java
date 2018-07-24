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

import com.soundclub.models.Pais;
import com.soundclub.models.StatusMessage;
import com.soundclub.persistence.PaisesEM;



@Path("/pais")
public class PaisAPI extends JSONService {
	private static Logger logger=Logger.getLogger("Pais");


  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  @GET
  public Response getListaPais(@HeaderParam("token") String token){
		int userId = this.getUserIdFromToken(token);
	  
	  if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {
			logger.info("Estoy enviando lista de paises ...");
	  
	try {
		return Response.status(202).entity(PaisesEM.getInstance().getListaPais()).build();
	} catch (Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Ha habido un error al pedir lista de paises").build();
	}
  }
  }
  @Path("/{idpais}")
  @Produces(MediaType.APPLICATION_JSON)
  @GET
  public Response getPaisID(@PathParam(value = "idpais") int idp) {
	  Pais unPais= PaisesEM.getInstance().getPaisID(idp);
	  try {
			if(unPais!=null)return Response.status(202).entity(unPais).build();
			else return Response.status(404).entity("El pais con este id no existe").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Ha habido un error al pedir la id del pais").build();
		}
}
  
  
  
}
