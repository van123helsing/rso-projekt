package si.fri.rso.entitete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "uporabnik")
@NamedQueries(value =
        {
                @NamedQuery(name = "Uporabnik.getAll", query = "SELECT u FROM uporabnik u"),
                @NamedQuery(name="Uporabnik.findByUI", query="SELECT u FROM uporabnik u WHERE u.imeUporabnika = :userId")
        })
public class Uporabnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ime_uporabnika")
    private String imeUporabnika;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeUporabnika() {
        return imeUporabnika;
    }

    public void setImeUporabnika(String imeUporabnika) {
        this.imeUporabnika = imeUporabnika;
    }
}
