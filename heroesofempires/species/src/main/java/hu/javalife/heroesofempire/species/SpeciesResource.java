package hu.javalife.heroesofempire.species;


import io.swagger.annotations.*;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/species")
@ApplicationScoped
@Api(value = "/species", consumes = "application/json")
@SwaggerDefinition(
        info = @Info(
                title = "Example Service",
                description = "A simple example here",
                version = "1.0.0",
                contact = @Contact(
                        name = "Laurent CAILLETEAU",
                        email = "lll@gmail.com",
                        url = ""
                )
        ),
        host = "localhost",
        basePath = "/api/v2",
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
)
public class SpeciesResource {
    private List<Species> specs = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        return Response.ok(specs).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @ApiOperation(value = "Get hero by id", response = Species.class)
    public Species getSpecById(@PathParam("id") int id) {
        return specs.get(id);

    }
    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Delete by index")
    public void delById(@PathParam("id")int id){
        specs.remove(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(value = "new Spec",
            notes = "Add new Spec",
            response = Species.class)
    @ApiResponses(value = {@ApiResponse(code=400,message = "Valamiszar"),
            @ApiResponse(code=200,message = "MindenFasza")})

    public Response addHero(@ApiParam(value = "nameOfSpec",required = true)
                            @FormParam("name") String pName,
                            @ApiParam(value = "descOfSpec",required = true)
                            @FormParam("secs") String pDesc) {
        Species newSpec = new Species(pName, pDesc);
        specs.add(newSpec);
        return Response.ok(newSpec).build();
    }

}
