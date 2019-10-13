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

import Zrna.DosegiZrn;
import Zrna.UporabnikZrno;
import si.fri.rso.entitete.Uporabnik;


@Path("uporabniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UporabnikVir {

    @Inject
    private UporabnikZrno uporabnikZrno;

    @Inject
    private DosegiZrn dosegiZrn;


    @GET
    public Response vrniUporabnike() {
        dosegiZrn.identifikator();
        List<Uporabnik> uporabniki = uporabnikZrno.getUporabniki();
        dosegiZrn.identifikator();
        return Response.status(Response.Status.OK).entity(uporabniki).build();
    }

    @Path("{id}")
    @GET
    public Response vrniUporabnikaById(@PathParam("id") Integer id) {
        dosegiZrn.identifikator();
        Uporabnik uporabniki = uporabnikZrno.pridobiUporabnika(id);
        return Response.status(Response.Status.OK).entity(uporabniki).build();
    }

    @Path("{upIme}")
    @GET
    public Response vrniUporabnikaByUpIme(@PathParam("upIme") String upIme) {
        Uporabnik uporabniki = uporabnikZrno.getUpByUpime(upIme);
        return Response.status(Response.Status.OK).entity(uporabniki).build();
    }

    @Path("{id}")
    @DELETE
    public Response odstraniUporabnika(@PathParam("id") Integer id) {
        boolean odstrani = uporabnikZrno.odstraniUporanbika(id);
        if (odstrani) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("{id}")
    @PUT
    public Response posodobiUporabnika(@PathParam("id") Integer id, Uporabnik uporabnik) {
        uporabnikZrno.posodobiUporabnika(id,uporabnik);
        return Response.status(Response.Status.OK).build();
    }


    @POST
    public Response dodajUporabnika( Uporabnik uporabnik) {
        uporabnikZrno.dodajUporabnika(uporabnik);
        return Response.status(Response.Status.CREATED).build();
    }

}