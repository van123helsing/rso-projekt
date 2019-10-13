package Zrna;


import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DosegiZrn {

    private UUID id = UUID.randomUUID();

    @PostConstruct
    public void naKoncu(){
        System.out.print("Vstop:");
        System.out.println(id);
    }

    @PreDestroy
    public void naZacetku(){
        System.out.print("Konec:");
        System.out.println(id);
    }

    public void identifikator(){

    }


}
