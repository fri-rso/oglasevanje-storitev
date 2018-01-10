package si.jaklic.adverts;


import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/info")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfoResource {
    @Inject
    private OrdersProperties ordersProperties;

    @Inject
    @DiscoverService(value = "ws-orders", environment = "dev", version = "1.0.0")
    private String ws_orders;

    @Inject
    @DiscoverService(value = "ws-adverts", environment = "dev", version = "1.0.0")
    private String ws_adverts;

    @Inject
    @DiscoverService(value = "microservices-comments", environment = "dev", version = "1.0.0")
    private String microservices_comments;

    @GET
    public Response getOrders() {
        String[] clani = new String[]{"j2799", "lp7872", "lh7753"};
        String[] mikrostoritve = new String[]{"http://35.205.24.229/orders", "http://35.205.77.9/adverts", "http://35.189.87.170/profiles"};
        String[] github = new String[]{"https://github.com/fri-rso/oglasevanje-storitev", "https://github.com/fri-rso/microservices-profile"};
        String[] travis = new String[]{"https://travis-ci.org/fri-rso/oglasevanje-storitev", "https://travis-ci.org/fri-rso/microservices-profile"};
        String[] dockerhub = new String[]{"https://hub.docker.com/r/frirso/ws-adverts/", "https://hub.docker.com/r/frirso/ws-orders/", "https://hub.docker.com/r/frirso/microservices-profile/"};
        String[] internal_mikrostoritve = new String[] {
                "ws_orders: " + this.ws_orders,
                "ws_adverts: " + this.ws_adverts,
                "microservices_comments: " + this.microservices_comments
        };

        Info info = new Info(
                clani,
                "Nas projekt implementira aplikacijo za oddajo oglasov",
                mikrostoritve,
                github,
                travis,
                dockerhub,
                internal_mikrostoritve
        );

        return Response.status(Response.Status.OK).entity(info).build();
    }
}
