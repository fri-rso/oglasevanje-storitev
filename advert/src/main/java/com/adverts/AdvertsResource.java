package com.adverts;

import com.adverts.models.Advert;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/adverts")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdvertsResource {
    @PersistenceContext(unitName = "adverts")
    private EntityManager em;

    @Inject
    private AdvertsProperties ordersProperties;

    @GET
    @Path("/{id}")
    public Response getAdvert(@PathParam("id") Integer id) {

        Advert o = em.find(Advert.class, id);

        if (o == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(o).build();
    }

    @GET
    public Response getAdverts() {
        TypedQuery<Advert> query = em.createNamedQuery("Advert.findAll", Advert.class);
        List<Advert> adverts = query.getResultList();

        return Response.ok(adverts).build();
    }

    /*
    @POST
    public Response placeOrder(Book b) {

        if (b == null || b.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Response bookResponse = ClientBuilder.newClient()
                .target(ordersProperties.getCatalogueUrl()).path("books").path(b.getId().toString()).request().get();

        if (!bookResponse.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Order o = new Order();
        o.setBook(bookResponse.readEntity(Book.class));
        o.setOrderDate(new Date());

        em.getTransaction().begin();

        em.persist(o);

        em.getTransaction().commit();

        return Response.status(Response.Status.CREATED).entity(o).build();
    }
    */
}
