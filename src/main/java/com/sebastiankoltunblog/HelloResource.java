package com.sebastiankoltunblog;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Event<String> requestEvent;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHello() {
        requestEvent.fire(uriInfo.getAbsolutePath().toString());
        return Response.ok().entity(new MessageResponse("Hello World!")).build();
    }


    class MessageResponse {
        private String message;

        public MessageResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
