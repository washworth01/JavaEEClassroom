package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint
{
	@Inject
	private TraineeService service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({"application/json"})
	public String getAllTrainees()
	{
		return service.getAllTrainees();
	}
	
	@Path("/createTrainee")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee)
	{
		return service.createTrainee(trainee);	
	}
	
	@Path("/deleteTrainee/{id}")
	@POST
	@Produces({"application/json"})
	public String delectTrainee(@PathParam("id") Long id)
	{
		return service.deleteTrainee(id);
	}
	
	@Path("/createTrainee/{id}")
	@POST
	@Produces({"application/json"})
	public String updateTrainee(@PathParam("id") Long id, String trainee)
	{
		return service.updateTrainee(trainee, id);
	}
}