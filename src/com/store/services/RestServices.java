package com.store.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.store.DAO.ItemDAOImpl;
import com.store.context.SpringApplicationContext;
import com.store.entities.Item;

//localhost:8080/Rest.api/rest/data
//@RestController
@Path("/data")
public class RestServices {
	
	public ItemDAOImpl itemDAO = (ItemDAOImpl) SpringApplicationContext.getBean("ItemDAO");
	
	public RestServices(){}
	
//	@RequestMapping(value = "/items", method = RequestMethod.GET,headers="Accept=application/json")
	@GET
	@Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems(){
//		return itemDAO.getAll();
		List<Item> items = itemDAO.getAll();
//		return items.size();
		return Response.status(201).entity(items).build();
//		return Response.ok(items.size()).build();
	}

//	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET,headers="Accept=application/json")
//	regex for checking int {id: \\d+}
	@GET
	@Path("/item/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public /*Item*/ Response getItemById(/*@PathVariable */@PathParam("id") int id){
//		return itemDAO.getById(id);
		Item item = itemDAO.getById(id);
		return Response.ok(item).build();
	}

}
