package si.fri.rso.entitete;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "slika")
@NamedQueries(value =
        {
                @NamedQuery(name = "Slika.getAll", query = "SELECT s FROM slika s")
        })
public class Slika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ime_slike")
    private String imeSlike;

    @Column(name="url_slike")
    private String urlSlike;

    @Column(name="datum_nastanka_slike")
    private Date datumNastankaSlike;

    @ManyToOne
    @JoinColumn(name = "id_uporabnik")
    private Uporabnik idUporabnik;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeSlike() {
        return imeSlike;
    }

    public void setImeSlike(String imeSlike) {
        this.imeSlike = imeSlike;
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }

    public Date getDatumNastankaSlike() {
        return datumNastankaSlike;
    }

    public void setDatumNastankaSlike(Date datumNastankaSlike) {
        this.datumNastankaSlike = datumNastankaSlike;
    }

    public Uporabnik getIdUporabnik() {
        return idUporabnik;
    }

    public void setIdUporabnik(Uporabnik idUporabnik) {
        this.idUporabnik = idUporabnik;
    }
}
