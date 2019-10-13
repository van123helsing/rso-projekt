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

@Entity(name = "komentar")
@NamedQueries(value =
        {
                @NamedQuery(name = "Komentar.getAll", query = "SELECT k FROM album k"),
                @NamedQuery(name="Komentar.findCommentsBySlika", query="SELECT k FROM komentar k WHERE k.idSlika = :slikaId"),

        })
public class Komentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="vsebina")
    private String vsebina;

    @Column(name="datum_nastanka_komentarja")
    private Date datumNastankaKomentarja;

    @ManyToOne
    @JoinColumn(name = "id_uporabnik")
    private Uporabnik idUporabnik;

    @ManyToOne
    @JoinColumn(name = "id_slika")
    private Slika idSlika;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVsebina() {
        return vsebina;
    }

    public void setVsebina(String vsebina) {
        this.vsebina = vsebina;
    }

    public Date getDatumNastankaKomentarja() {
        return datumNastankaKomentarja;
    }

    public void setDatumNastankaKomentarja(Date datumNastankaKomentarja) {
        this.datumNastankaKomentarja = datumNastankaKomentarja;
    }

    public Uporabnik getIdUporabnik() {
        return idUporabnik;
    }

    public void setIdUporabnik(Uporabnik idUporabnik) {
        this.idUporabnik = idUporabnik;
    }

    public Slika getIdSlika() {
        return idSlika;
    }

    public void setIdSlika(Slika idSlika) {
        this.idSlika = idSlika;
    }
}
