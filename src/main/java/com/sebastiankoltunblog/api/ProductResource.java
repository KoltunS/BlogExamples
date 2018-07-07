package com.sebastiankoltunblog.api;

import com.sebastiankoltunblog.core.CommandGateway;
import com.sebastiankoltunblog.core.Gateway;
import com.sebastiankoltunblog.productcart.AddToCartCommand;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/productcart")
public class ProductResource {
    private static final Logger log = Logger.getLogger(ProductResource.class);
    @Inject
    @Gateway
    private CommandGateway gateway;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToCart(AddToCartCommand command) {
        log.info(command);
        gateway.execute(command);
        return Response.ok().build();
    }
}
