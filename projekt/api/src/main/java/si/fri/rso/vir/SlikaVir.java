package si.fri.rso.vir;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.jetty.http2.api.Session;

import com.kumuluz.ee.rest.beans.QueryParameters;

import Zrna.SlikaZrno;
import si.fri.rso.entitete.Slika;


@Path("slika")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SlikaVir {
    @Inject
    private SlikaZrno slikaZrno;


    @GET
    public Response vrniSlike() {
        List<Slika> slike = slikaZrno.getSlike();
        return Response.status(Response.Status.OK).entity(slike).build();
    }

    @Path("{id}")
    @DELETE
    public Response odstraniSliko(@PathParam("id") Integer id) {
        boolean odstrani = slikaZrno.odstraniSliko(id);
        if (odstrani) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    public Response posodobiSliko(@PathParam("id") Integer id, Slika slika) {
        slikaZrno.posodobiSliko(id, slika);
        return Response.status(Response.Status.OK).build();
    }


    @POST
    public Response dodajSliko(Slika slika) {
        slikaZrno.dodajSliko(slika);
        return Response.status(Response.Status.CREATED).build();
    }
}
