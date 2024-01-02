package org.app.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("/voting")
public class VotingResource {

    @GET
    @Path("/{name}/{age}")
    public String checkEligibility(@PathParam("name") String name, @PathParam("age") int age) {
        if (age >= 18) {
            return "Hello !, " + name + " You are eligible to vote!";
        } else {
            return "Hello !, " + name + " Sorry, you are not eligible to vote yet.";
        }
    }
}
