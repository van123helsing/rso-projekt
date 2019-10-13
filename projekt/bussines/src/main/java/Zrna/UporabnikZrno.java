package Zrna;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.apache.commons.collections4.CollectionUtils;

import BeleziKlice.BeleziKlice;
import si.fri.rso.entitete.Uporabnik;


@ApplicationScoped
public class UporabnikZrno {

    private Logger log = Logger.getLogger(UporabnikZrno.class.getName());

    @PostConstruct
    private void init() {
        log.info("Incializiram UporabnikZrno");
    }

    @PersistenceContext(unitName = "kumuluzee-rest-eclipselink1")
    private EntityManager em;

    @BeleziKlice
    public List<Uporabnik> getUporabniki() {
        Query query = em.createNamedQuery("Uporabnik.getAll", Uporabnik.class);
        return query.getResultList();
    }

    public Uporabnik getUpByUpime(String userId) {
        Query query = em.createNamedQuery("Uporabnik.findByUI", Uporabnik.class).setParameter("userId",userId);
        if(query.getResultList().isEmpty()){
            return null;
        } else {
            Iterator iter = query.getResultList().iterator();
            return (Uporabnik) iter.next();
        }
    }

    public Uporabnik pridobiUporabnika (int uporabnikId) {
        Uporabnik uporabnik = em.find(Uporabnik.class, uporabnikId);
        if (uporabnik == null){
            throw new NotFoundException();
        }
        return uporabnik;
    }


    @Transactional
    public void dodajUporabnika(Uporabnik uporabnik){
        if(uporabnik !=null){
            em.persist(uporabnik);
        }
    }

    @Transactional
    public void posodobiUporabnika(int uporabnikId, Uporabnik uporabnik) {
        Uporabnik u = em.find(Uporabnik.class,uporabnikId);
        uporabnik.setId(u.getId());
        em.merge(uporabnik);
    }

    @Transactional
    public boolean odstraniUporanbika(int uporabnikId) {
        Uporabnik uporabnik = em.find(Uporabnik.class, uporabnikId);
        if (uporabnik != null){
            em.remove(uporabnik);
            return true;
        }
        return false;
    }

}