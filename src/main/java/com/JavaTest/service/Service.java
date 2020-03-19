package com.JavaTest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.JavaTest.model.User;

@Path("/json/product")
public class Service {

	@GET
	@Path("/get")
	@Produces("application/json")
	public User getUser() {

		User user = new User();
		user.setId(1);
		user.setBody("some comment");
		user.setPostId(1);
		
		return user; 

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public static Response createUser(User user) {

		String result = "User created : " + user;
		return Response.status(201).entity(result).build();
		
	}
	
}