package org.vaadin.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class DummyService {

	@Path("dummy")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String dummy() {
		return "dummy";
	}
}
