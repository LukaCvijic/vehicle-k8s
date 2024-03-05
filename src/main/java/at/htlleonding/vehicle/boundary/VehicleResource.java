package at.htlleonding.vehicle.boundary;

import at.htlleonding.vehicle.control.VehiclePanacheRepo;
import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.json.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/vehicle")
public class VehicleResource {

    @Inject
    VehiclePanacheRepo vpr;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance vehicle(Vehicle vehicle);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    @Blocking
    public TemplateInstance get(@PathParam("id") Long id) {
        return Templates.vehicle(vpr.findById(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> findAll() {
        /*
        List<Vehicle> all = new ArrayList<>();
        all.add(find(42));
        return all;
        */

        return vpr.listAll();
    }

    @GET
    @Path("myjson")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject myCustomJsonObject(){
        return Json.createObjectBuilder()
                .add("first-name", "Bertl")
                .add("last-name", "Balazs")
                .build();
    }

    @GET
    @Path("myResponse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response myCustomResponse(@QueryParam("no") Integer no){

        if(no == 1){
            return Response
                    .ok(new Vehicle("Opel", "Karl"))
                    .header("MY_HEADER_ENTRY", "java is cool")
                    .build();
        }
        else {
            return Response
                    .status(Response.Status.CONFLICT)
                    .build();
        }

    }
}
