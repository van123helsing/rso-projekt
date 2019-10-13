package si.fri.rso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Zrna.AlbumZrno;
import Zrna.KomentarZrno;
import Zrna.SlikaAlbumZrno;
import Zrna.SlikaZrno;
import Zrna.UporabnikZrno;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    @Inject
    private UporabnikZrno uporabnikiZrno;
    @Inject
    private SlikaAlbumZrno slikaAlbumZrno;
    @Inject
    private KomentarZrno komentarZrno;
    @Inject
    private SlikaZrno slikaZrno;
    @Inject
    private AlbumZrno albumZrno;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html: charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}