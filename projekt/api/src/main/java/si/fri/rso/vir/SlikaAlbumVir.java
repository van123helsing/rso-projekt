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

import Zrna.AlbumZrno;
import Zrna.SlikaAlbumZrno;
import si.fri.rso.entitete.Album;
import si.fri.rso.entitete.Slika_Album;


@Path("album")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class SlikaAlbumVir {

    @Inject
    private SlikaAlbumZrno slikaAlbumZrno;

    @GET
    public Response vrniSlikeAlbuma() {
        List<Slika_Album> slikaAlbum = slikaAlbumZrno.getSlika_Albums();
        return Response.status(Response.Status.OK).entity(slikaAlbum).build();
    }

    @Path("{idSlike}/{idAlbuma}")
    @DELETE
    public Response odstraniSlikoIzAlbuma(@PathParam("idSlike") Integer idSlike, @PathParam("idAlbuma") Integer idAlbuma) {
        boolean odstrani = slikaAlbumZrno.odstraniSlikoIzAlbuma(idAlbuma,idSlike);

        if (odstrani) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response dodajSlikoVAlbum(Slika_Album slikaAlbum) {
        slikaAlbumZrno.dodajSlika_Album(slikaAlbum);
        return Response.status(Response.Status.CREATED).build();
    }
}
