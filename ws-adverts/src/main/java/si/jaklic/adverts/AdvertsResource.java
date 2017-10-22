package si.jaklic.adverts;

import si.jaklic.adverts.models.Advert;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Igor Fele <igor.fele@result.si>
 * @since $VERSION
 */
@Path("/adverts")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdvertsResource {

  @PersistenceContext
  private EntityManager em;

  @GET
  public Response getAdverts() {
    final TypedQuery<Advert> query = em.createNamedQuery("Advert.findAll", Advert.class);
    final List<Advert> adverts = query.getResultList();
    return Response.ok(adverts).build();
  }

  @GET
  @Path("/{id}")
  public Response getAdvert(@PathParam("id") final Integer id) {
    final Advert advert = em.find(Advert.class, id);

    if(advert == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok(advert).build();
  }

  @POST
  public Response createAdvert(final Advert advert) {
    advert.setId(null);

    em.getTransaction().begin();
    em.persist(advert);
    em.getTransaction().commit();

    return Response.status(Response.Status.CREATED).entity(advert).build();
  }
}
