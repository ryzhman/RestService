//package com.store.serviceTools;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.ext.ExceptionMapper;
//
//import org.hibernate.validator.method.MethodConstraintViolationException;
//
////@Provider
//public class ValidationExceptionHandler implements ExceptionMapper<MethodConstraintViolationException> 
//{
//    @Override
//    public Response toResponse(MethodConstraintViolationException exception) 
//    {
//        return Response.status(Status.BAD_REQUEST).entity("Fields are filled incorrectly").build();
//    }
//}
