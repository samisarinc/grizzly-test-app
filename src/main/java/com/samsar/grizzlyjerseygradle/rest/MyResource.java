package com.samsar.grizzlyjerseygradle.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.samsar.grizzlyjerseygradle.model.MyModel;

@Path("myresource")
public class MyResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MyModel getHello() {
		MyModel track = new MyModel();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;
	}

}