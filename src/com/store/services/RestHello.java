package com.store.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class RestHello {
		@GET
		@Path("/hello")
	    @Produces(MediaType.APPLICATION_JSON)
		public String greeting(){
			return "Hello in REST service!";
		}
}
