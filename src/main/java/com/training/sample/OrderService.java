package com.training.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class OrderService {
	@GET
	@Path("/getOrder")
	@Produces({MediaType.APPLICATION_XML})	
	public ResponseData getOrder(@QueryParam("") RequestData request)
	{
		return null;
	}

}
