package com.store.services;

import java.io.IOException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.store.DAO.ItemDAOImpl;
import com.store.context.SpringApplicationContext;
import com.store.entities.Item;

//http://localhost:8080/Rest.api/rest/getprice?mpn=hand&availability=0&pricesort=1

@Path("/getprice")
public class RestServices {
	public ItemDAOImpl itemDAO = (ItemDAOImpl) SpringApplicationContext.getBean("ItemDAO");
	public ObjectMapper mapper;

	public RestServices(){}
	
//	@RequestMapping(value = "/items", method = RequestMethod.GET,headers="Accept=application/json")
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArrangedItem( 
			@QueryParam("mpn") String mpn, 
			/*@DefaultValue("0") */@QueryParam("{availibility: [0-2]}") /*@Pattern("[0-2]", message = "The sort ID must be a valid number")*/ int availability, 
			/*@DefaultValue("0") */@QueryParam("{pricesort: [0-2]}") /*@Pattern(regexp="", message = "The sort ID must be a valid number" Internationalization may be added)*/ int pricesort) 
					throws NotFoundException{
//	public Response getArrangedItem(@Context UriInfo info)throws NotFoundException{
//		try{
			/*String mpn = info.getQueryParameters().getFirst("mpn").trim();
			String availabilitySTR = info.getQueryParameters().getFirst("availability");
			int availability = Integer.parseInt(availabilitySTR);
			if(availability!=0&&availability!=1&&availability!=2) availability=0;
			String pricesortSRT = info.getQueryParameters().getFirst("pricesort");
			int pricesort = Integer.parseInt(pricesortSRT);
			if(pricesort!=0&&pricesort!=1&&pricesort!=2) pricesort=0;
*/		try{
			String representation;
			Item item = itemDAO.getArrangedItem(mpn, availability, pricesort);
			mapper = new ObjectMapper();
			representation = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
			return Response.status(200).entity(representation).build();
		}catch(JsonGenerationException|JsonMappingException e){
			throw new NotFoundException(Response.status(Status.BAD_REQUEST)
                    .entity("Couldn't find a good with mpn: " + e.getMessage())
                    .build());
		}catch(NumberFormatException e){
				throw new BadRequestException(Response.status(Status.BAD_REQUEST)
	                    .entity("Couldn't find a good with mpn: " + e.getMessage())
	                    .build());
		}catch(IOException e){
			throw new NotFoundException(Response.status(Status.BAD_REQUEST)
                    .entity("Couldn't find a good with mpn: " + e.getMessage())
                    .build());		
		}
		
//		return Response.status(200).entity(mpn + ", " + availability + ", " + pricesort).build();
	}

//	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET,headers="Accept=application/json")
//	regex for checking int {id: \\d+}
	@GET
	@Path("/item/{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getItemById(/*@PathVariable*/ @PathParam("id") int id){
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
