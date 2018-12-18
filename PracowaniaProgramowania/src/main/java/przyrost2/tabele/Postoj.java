package przyrost2.tabele;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "POSTOJE")
public class Postoj {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Pociag_ID",referencedColumnName = "id")
    private Pociag pociag;

    @ManyToOne
    @JoinColumn(name = "Stacja_ID",referencedColumnName = "id")
    private Stacja stacja;

    @Column(name = "Czas_Przyjazdu")
    private ZonedDateTime przyjazd;

    @Column(name = "Czas_Odjazdu")
    private ZonedDateTime odjazd;

    public Postoj() {}

    public Postoj(Pociag pociag, Stacja stacja, ZonedDateTime przyjazd, ZonedDateTime odjazd) {
        this.pociag = pociag;
        this.stacja = stacja;
        this.przyjazd = przyjazd;
        this.odjazd = odjazd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pociag getPociag() {
        return pociag;
    }

    public void setPociag(Pociag pociag) {
        this.pociag = pociag;
    }

    public Stacja getStacja() {
        return stacja;
    }

    public void setStacja(Stacja stacja) {
        this.stacja = stacja;
    }

    public ZonedDateTime getPrzyjazd() {
        return przyjazd;
    }

    public void setPrzyjazd(ZonedDateTime przyjazd) {
        this.przyjazd = przyjazd;
    }

    public ZonedDateTime getOdjazd() {
        return odjazd;
    }

    public void setOdjazd(ZonedDateTime odjazd) {
        this.odjazd = odjazd;
    }
}
