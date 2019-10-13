package Zrna;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BelezenjeKlicevZrno {
    private int stevec;

    public void povecajSteviloKlicev() {
        stevec++;
        System.out.println(stevec);
    }
}
