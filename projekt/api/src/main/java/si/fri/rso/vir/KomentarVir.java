package si.fri.rso.vir;

import java.util.List;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Zrna.KomentarZrno;
import Zrna.SlikaZrno;
import si.fri.rso.entitete.Komentar;
import si.fri.rso.entitete.Slika;


@Path("komentar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class KomentarVir {
    @Inject
    private KomentarZrno komentarZrno;


    @GET
    public Response vrniKomentarje() {
        List<Komentar> komentarji = komentarZrno.getKomentar();
        return Response.status(Response.Status.OK).entity(komentarji).build();
    }

    @Path("{id}")
    @DELETE
    public Response odstraniKomentar(@PathParam("id") Integer id) {
        boolean odstrani = komentarZrno.odstraniKomentar(id);
        if (odstrani) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    public Response posodobiKomentar(@PathParam("id") Integer id, Komentar komentar) {
        komentarZrno.posodobiKomentar(id, komentar);
        return Response.status(Response.Status.OK).build();
    }


    @POST
    public Response dodajKomentar(Komentar komentar) {
        komentarZrno.dodajKomentar(komentar);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("/slika{id}")
    @GET
    public Response vrniKomentarjeZaSliko(@PathParam("id") Integer id) {
        List<Komentar> komentarji = komentarZrno.pridobiKomentarZaSliko(id);
        return Response.status(Response.Status.OK).entity(komentarji).build();
    }

}
