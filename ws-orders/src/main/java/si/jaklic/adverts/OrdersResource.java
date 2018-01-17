package si.jaklic.adverts;

import com.google.gson.Gson;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import si.jaklic.adverts.models.Advert;
import si.jaklic.adverts.models.Order;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/orders")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {

  @PersistenceContext
  private EntityManager em;

  @Inject
  private OrdersProperties ordersProperties;

  @Inject
  @DiscoverService(value = "ws-adverts", environment = "dev", version = "1.0.0")
  private String ws_adverts;

  @GET
  public Response getOrders() {
    final TypedQuery<Order> query = em.createNamedQuery("Order.findAll", Order.class);
    final List<Order> orders = query.getResultList();

    return Response.ok(orders).build();
  }

  @GET
  @Path("/{id}")
  public Response getOrder(@PathParam("id") final Integer id) {
    return Response.ok().build();
  }

  @POST
  public Response placeOrder(final Order order) {
    order.setId(null);

    final Response advertResponse = ClientBuilder.newClient()
        .target(ordersProperties.getAdvertsUrl())
        .path("adverts")
        .path(order.getAdvert().getId().toString())
        .request().get();

    if (!advertResponse.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    // final Order order = new Order();
    order.setAdvert(advertResponse.readEntity(Advert.class));
    order.setOrderDate(new Date());

    em.getTransaction().begin();
    em.persist(order);
    em.getTransaction().commit();

    return Response.status(Response.Status.CREATED).entity(order).build();
  }

  @GET
  @Path("related")
  public Response relatedOrders() {
    final TypedQuery<Order> query = em.createNamedQuery("Order.findAll", Order.class);
    final List<Order> orders = query.getResultList();

    List<RelatedOrder> relatedOrders = new ArrayList<RelatedOrder>();

    for (Order order : orders) {
      String url = this.ws_adverts.toString() + "/adverts/" + order.getId().toString();

      Client client = ClientBuilder.newClient();
      Response response = client.target(url).request().get();
      int status = response.getStatus();
      System.out.println("Status code: " + status);
      String output  = response.readEntity(String.class);

      System.out.println(output);

      Gson g = new Gson();
      Advert advert = g.fromJson(output, Advert.class);

      RelatedOrder ro = new RelatedOrder(
              order.getId(),
              order.getOrderDate(),
              order.getQuantity(),
              advert.getId(),
              advert.getTitle(),
              advert.getDescription(),
              advert.getAuthor()
      );
      relatedOrders.add(ro);

    }

    System.out.println("-----");
    System.out.println(ordersProperties.getWebPageTitle());

    return Response.ok(relatedOrders).build();
  }
}
