package si.jaklic.adverts;

import si.jaklic.adverts.models.Advert;
import si.jaklic.adverts.models.Order;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/orders")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {

  @PersistenceContext
  private EntityManager em;

  @Inject
  private OrdersProperties ordersProperties;

//  @GET
//  public Response getOrders() {
//    final TypedQuery<Order> query = em.createNamedQuery("Order.findAll", Order.class);
//    final List<Order> orders = query.getResultList();
//    return Response.ok(orders).build();
//  }

  @GET
  @Path("/{id}")
  public Response getOrder(@PathParam("id") final Integer id) {
    return Response.ok().build();
  }

  @POST
  public Response placeOrder(final Advert advert) {
    if(advert == null || advert.getId() == null) {
      return Response.status(Response.Status.BAD_REQUEST).build();
    }

    final Response advertResponse = ClientBuilder.newClient()
        .target(ordersProperties.getCatalogueUrl())
        .path("adverts")
        .path(advert.getId().toString())
        .request().get();

    if(!advertResponse.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    final Order order = new Order();
    order.setAdvert(advertResponse.readEntity(Advert.class));
    order.setOrderDate(new Date());

    em.getTransaction().begin();
    em.persist(order);
    em.getTransaction().commit();

    return Response.status(Response.Status.CREATED).entity(order).build();
  }
}
