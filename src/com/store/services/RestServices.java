package com.store.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.store.DAO.ItemDAOImpl;
import com.store.entities.Item;

//@RestController
@Path("/data")
public class RestServices {
	public ItemDAOImpl itemDAO = new ItemDAOImpl();;
	
//	@RequestMapping(value = "/", method = RequestMethod.GET,headers="Accept=application/json")
	@GET
	@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
	public String greeting(){
		return "Hello in REST service!";
	}
	
//	@RequestMapping(value = "/items", method = RequestMethod.GET,headers="Accept=application/json")
	@GET
	@Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
	public /*List<Item>*/ Response getAllItems(){
//		return itemDAO.getAll();
		List<Item> items = itemDAO.getAll();
		return Response.ok(items).build();
	}

//	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	@GET
	@Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
	public /*Item*/ Response getItemById(/*@PathVariable */@PathParam("id") int id){
//		return itemDAO.getById(id);
		Item item = itemDAO.getById(id);
		return Response.ok(item).build();
	}

}
