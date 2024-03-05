package at.htlleonding.vehicle.boundary;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance hello(String name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get(@QueryParam("name") String name) {
        return Templates.hello(name);
    }
}
