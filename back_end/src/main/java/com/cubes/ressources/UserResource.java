package com.cubes.ressources;

import com.cubes.services.User;
import com.cubes.services.UserService;
import io.agroal.api.AgroalDataSource;
import org.jboss.resteasy.reactive.RestResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/user")
public class UserResource {
    @Inject
    private AgroalDataSource dataSource;

    UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<String> register(User user) {
        if (userService.register(user, dataSource)) {
            return RestResponse.status(RestResponse.Status.CREATED);
        } else {
            return RestResponse.status(RestResponse.Status.BAD_REQUEST);
        }
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello, welcome to the API";
    }
}