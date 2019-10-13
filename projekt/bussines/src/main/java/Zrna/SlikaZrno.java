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

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import BeleziKlice.BeleziKlice;
import si.fri.rso.entitete.Slika;

@ApplicationScoped
public class SlikaZrno {
    private Logger log = Logger.getLogger(SlikaZrno.class.getName());

    @PostConstruct
    private void init() {
        log.info("Incializiram SlikaZrno");
    }

    @PersistenceContext(unitName = "kumuluzee-rest-eclipselink2")
    private EntityManager em;

    @BeleziKlice
    public List<Slika> getSlike() {
        Query query = em.createNamedQuery("Slika.getAll", Slika.class);
        return query.getResultList();
    }

    public Slika vrniSlikoById (int id) {
        Slika o = em.find(Slika.class, id);
        if (o == null){
            throw new NotFoundException();
        }
        return o;
    }


    @Transactional
    public void dodajSliko(Slika slika) {
        if(slika !=null){
            em.persist(slika);
        }
    }

    @Transactional
    public void posodobiSliko(int slikaID, Slika slika) {
        Slika o = em.find(Slika.class,slikaID);
        slika.setId(o.getId());
        em.merge(slika);
    }

    @Transactional
    public boolean odstraniSliko(int  slikaID) {
        Slika slika = em.find(Slika.class, slikaID);
        if (slika != null) {
            em.remove(slika);
            return true;
        }
        return false;
    }
}
