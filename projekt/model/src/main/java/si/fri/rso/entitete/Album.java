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

@Entity(name = "album")
@NamedQueries(value =
        {
                @NamedQuery(name = "Album.getAll", query = "SELECT a FROM album a")
        })
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ime_albuma")
    private String imeAlbuma;

    @Column(name="datum_nastanka_albuma")
    private Date datumNastankaAlbuma;

    @ManyToOne
    @JoinColumn(name = "id_uporabnik")
    private Uporabnik idUporabnik;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeAlbuma() {
        return imeAlbuma;
    }

    public void setImeAlbuma(String imeAlbuma) {
        this.imeAlbuma = imeAlbuma;
    }

    public Date getDatumNastankaAlbuma() {
        return datumNastankaAlbuma;
    }

    public void setDatumNastankaAlbuma(Date datumNastankaAlbuma) {
        this.datumNastankaAlbuma = datumNastankaAlbuma;
    }

    public Uporabnik getIdUporabnik() {
        return idUporabnik;
    }

    public void setIdUporabnik(Uporabnik idUporabnik) {
        this.idUporabnik = idUporabnik;
    }
}
