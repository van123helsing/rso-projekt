package si.fri.rso.entitete;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "slika_album")
@NamedQueries(value =
        {
                @NamedQuery(name="Slika_Album.getAll", query = "SELECT sa FROM slika_album sa"),
                @NamedQuery(name="Slika_Album.findAlbumsBySlika", query="SELECT s FROM slika_album s WHERE s.idSlika = :slikaId"),
                @NamedQuery(name="Slika_Album.findSlikeByAlbums", query="SELECT a FROM slika_album a WHERE a.idAlbum = :albumId"),
                @NamedQuery(name="Slika_Album.deleteSlikaFromAlbum", query="DELETE FROM slika_album sa WHERE sa.idAlbum = :albumId AND sa.idSlika = :slikaId")

        })
public class Slika_Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album idAlbum;

    @ManyToOne
    @JoinColumn(name = "id_slika")
    private Slika idSlika;

    public Slika_Album() {

    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Slika getIdSlika() {
        return idSlika;
    }

    public void setIdSlika(Slika idSlika) {
        this.idSlika = idSlika;
    }

    public Slika_Album(Slika idSlika, Album idAlbum) {
        this.idSlika = idSlika;
        this.idAlbum = idAlbum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
