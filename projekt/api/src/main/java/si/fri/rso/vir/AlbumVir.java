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
import si.fri.rso.entitete.Album;


@Path("album")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AlbumVir {

    @Inject
    private AlbumZrno albumZrno;

    @GET
    public Response vrniAlbume() {
        List<Album> album = albumZrno.getAlbums();
        return Response.status(Response.Status.OK).entity(album).build();
    }

    @Path("{id}")
    @DELETE
    public Response odstraniAlbum(@PathParam("id") Integer id) {
        boolean odstrani = albumZrno.odstraniAlbum(id);
        if (odstrani) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    public Response posodobiAlbum(@PathParam("id") Integer id, Album album) {
        albumZrno.posodobiAlbum(id, album);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    public Response dodajAlbum (Album album) {
        albumZrno.dodajAlbum(album);
        return Response.status(Response.Status.CREATED).build();
    }
}
