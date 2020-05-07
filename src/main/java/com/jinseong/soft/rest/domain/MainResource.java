package com.jinseong.soft.rest.domain;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/main")
@Produces(MediaType.APPLICATION_JSON)
public class MainResource {

  @Path("/hello")
  @GET
  public Response getHello() {
    return Response.status(Response.Status.OK).entity("Hello!").build();
  }
}
