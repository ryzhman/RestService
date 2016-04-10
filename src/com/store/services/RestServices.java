package com.store.services;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.store.DAO.ItemDAOImpl;
import com.store.context.SpringApplicationContext;
import com.store.entities.Item;

//localhost:8080/Rest.api/rest/data
//@RestController
@Path("/data")
public class RestServices {
	public ItemDAOImpl itemDAO = (ItemDAOImpl) SpringApplicationContext.getBean("ItemDAO");
	public ObjectMapper mapper;

	public RestServices(){}
	
//	@RequestMapping(value = "/items", method = RequestMethod.GET,headers="Accept=application/json")
	@GET
	@Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems(){
		try{
			String representation;
			List<Item> items = itemDAO.getAll();
			mapper = new ObjectMapper();
			representation = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);
			return Response.status(201).entity(representation).build();
		}catch(JsonGenerationException|JsonMappingException e){
			e.getMessage();
			return Response.status(500).entity("error during formatting").build();
		}catch(IOException e){
			e.getMessage();
			return Response.status(500).entity("error during formatting").build();
		}
	}

//	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET,headers="Accept=application/json")
//	regex for checking int {id: \\d+}
	@GET
	@Path("/item/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public /*Item*/ Response getItemById(/*@PathVariable */@PathParam("id") int id){
		try{
			String representation;
			Item item = itemDAO.getById(id);
			mapper = new ObjectMapper();
			representation = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
			return Response.status(201).entity(representation).build();
		}catch(JsonGenerationException|JsonMappingException e){
			e.getMessage();
			return Response.status(500).entity("error during formatting").build();
		}catch(IOException e){
			e.getMessage();
			return Response.status(500).entity("error during formatting").build();
		}
	}

}
