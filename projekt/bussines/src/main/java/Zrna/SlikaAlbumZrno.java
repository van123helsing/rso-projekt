package Zrna;


import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;

import BeleziKlice.BeleziKlice;
import si.fri.rso.entitete.Slika_Album;

@ApplicationScoped
public class SlikaAlbumZrno {
    private Logger log = Logger.getLogger(SlikaAlbumZrno.class.getName());

    @PostConstruct
    private void init() {
        log.info("Incializiram Slika_AlbumZrno");
    }

    @PersistenceContext(unitName = "kumuluzee-rest-eclipselink3")
    private EntityManager em;

    @BeleziKlice
    public List<Slika_Album> getSlika_Albums() {
        Query query = em.createNamedQuery("Slika_Album.getAll", Slika_Album.class);
        return query.getResultList();
    }

    @Transactional
    public void dodajSlika_Album(Slika_Album slikaAlbum) {
        if(slikaAlbum !=null){
            em.persist(slikaAlbum);
        }
    }

    @Transactional
    public boolean odstraniSlikoIzAlbuma(int albumID, int slikaID) {
        Query query = em.createNamedQuery("Slika_Album.deleteSlikaFromAlbum", Slika_Album.class) .setParameter("albumId",albumID).setParameter("slikaId",slikaID);
        return CollectionUtils.isEmpty(query.getResultList());
    }


    public List<Integer> pridobiAlbumeBySlika (int albumID) {
        Query query = em.createNamedQuery("Slika_Album.findAlbumsBySlika", Slika_Album.class);
        return query.getResultList();
    }

    public List<Integer> pridobiSlikeByAlbum (int albumID) {
        Query query = em.createNamedQuery("Slika_Album.findSlikeByAlbums", Slika_Album.class);
        return query.getResultList();
    }
}
