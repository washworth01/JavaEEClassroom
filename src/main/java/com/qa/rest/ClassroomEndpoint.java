package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint
{
	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms()
	{
		return service.getAllClassrooms();
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(String classroom)
	{
		return service.createClassroom(classroom);	
	}
	
	@Path("/deleteClassroom/{id}")
	@POST
	@Produces({"application/json"})
	public String delectClassroom(@PathParam("id") Long id)
	{
		return service.deleteClassroom(id);
	}
	
	
	@Path("/createClassroom/{id}")
	@POST
	@Produces({"application/json"})
	public String updateClassroom(@PathParam("id") Long id, String classroom)
	{
		return service.updateClassroom(classroom, id);
	}
}