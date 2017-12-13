package si.jaklic.adverts;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/info")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfoResource {
    @GET
    public Response getOrders() {
        String[] clani = new String[]{"j2799", "lp7872", "lh7753"};
        String[] mikrostoritve = new String[]{"http://35.198.158.135/orders", "http://35.198.120.63/adverts", "http://35.189.87.170/profiles"};
        String[] github = new String[]{"https://github.com/fri-rso/oglasevanje-storitev", "https://github.com/fri-rso/microservices-profile"};
        String[] travis = new String[]{"https://travis-ci.org/fri-rso/oglasevanje-storitev", "https://travis-ci.org/fri-rso/microservices-profile"};
        String[] dockerhub = new String[]{"https://hub.docker.com/r/frirso/ws-adverts/", "https://hub.docker.com/r/frirso/ws-orders/", "https://hub.docker.com/r/frirso/microservices-profile/"};

        Info info = new Info(
                clani,
                "Nas projekt implementira aplikacijo za oddajo oglasov",
                mikrostoritve,
                github,
                travis,
                dockerhub
        );

        return Response.status(Response.Status.OK).entity(info).build();
    }
}
