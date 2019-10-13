package Zrna;


import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import BeleziKlice.BeleziKlice;
import si.fri.rso.entitete.Album;

@ApplicationScoped
public class AlbumZrno {
    private Logger log = Logger.getLogger(AlbumZrno.class.getName());

    @PostConstruct
    private void init() {
        log.info("Incializiram AlbumZrno");
    }

    @PersistenceContext(unitName = "kumuluzee-rest-eclipselink5")
    private EntityManager em;

    @BeleziKlice
    public List<Album> getAlbums() {
        Query query = em.createNamedQuery("Album.getAll", Album.class);
        return query.getResultList();
    }

    @Transactional
    public void dodajAlbum(Album Album) {
        if(Album !=null){
            em.persist(Album);
        }
    }

    @Transactional
    public void posodobiAlbum(int albumID, Album album) {
        Album l = em.find(Album.class,albumID);
        album.setId(l.getId());
        em.merge(album);
    }

    @Transactional
    public boolean odstraniAlbum(int albumID) {
        Album album = em.find(Album.class, albumID);
        if (album != null) {
            em.remove(album);
            return true;
        }
        return false;
    }

    public Album pridobiAlbum (int albumID) {
        Album album = em.find(Album.class, albumID);
        if (album == null){
            throw new NotFoundException();
        }
        return album;
    }
}
