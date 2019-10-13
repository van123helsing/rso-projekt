package Zrna;


import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import BeleziKlice.BeleziKlice;
import si.fri.rso.entitete.Komentar;

@ApplicationScoped
public class KomentarZrno {
    private Logger log = Logger.getLogger(KomentarZrno.class.getName());

    @PostConstruct
    private void init() {
        log.info("Incializiram KomentarZrno");
    }

    @PersistenceContext(unitName = "kumuluzee-rest-eclipselink4")
    private EntityManager em;

    @BeleziKlice
    public List<Komentar> getKomentar() {
        Query query = em.createNamedQuery("Komentar.getAll", Komentar.class);
        return query.getResultList();
    }

    @Transactional
    public void dodajKomentar(Komentar komentar) {
        if(komentar !=null){
            em.persist(komentar);
        }
    }

    @Transactional
    public void posodobiKomentar(int komentarID, Komentar komentar) {
        Komentar l = em.find(Komentar.class,komentarID);
        komentar.setId(l.getId());
        em.merge(komentar);
    }

    @Transactional
    public boolean odstraniKomentar(int komentarID) {
        Komentar komentar = em.find(Komentar.class, komentarID);
        if (komentar != null) {
            em.remove(komentar);
            return true;
        }
        return false;
    }

    @BeleziKlice
    public List<Komentar> pridobiKomentarZaSliko(int slikaId) {
        Query query = em.createNamedQuery("Komentar.findCommentsBySlika", Komentar.class).setParameter("slikaId",slikaId);
        return query.getResultList();
    }

}
