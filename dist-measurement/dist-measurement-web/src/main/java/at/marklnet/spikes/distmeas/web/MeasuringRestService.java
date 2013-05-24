package at.marklnet.spikes.distmeas.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * RestEasy
 * http://docs.jboss.org/resteasy/docs/2.3.6.Final/userguide/html_single/index.html
 * 
 * @author Markus Markl
 */
@Path("/measuringService")
public class MeasuringRestService {
		
	/**
	 * isAlive Method.
	 * 
	 * URL z.B: http://localhost:8080/dist-measurement-web/rest/measuringService/isAlive
	 * 
	 * @return ""
	 */
	@GET
	@Path("/isAlive")
	public Response isAlive() {
		final String result = "MeasuringService is alive.";
		return Response.status(200).entity(result).build();
	}

}
