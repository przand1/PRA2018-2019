package przyrost2.tabele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ODCINKI_TRAS")
public class OdcinekTrasy {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Stacja_1_ID",referencedColumnName = "id")
    private Stacja stacja1;

    @ManyToOne
    @JoinColumn(name = "Stacja_2_ID",referencedColumnName = "id")
    private Stacja stacja2;

    @ManyToMany(mappedBy = "przebiegTrasy",cascade = CascadeType.ALL)
    private Set<Trasa> trasy = new HashSet<Trasa>();

    @Column(name = "Dlugosc_Odcinka")
    private float dlugosc;

    public OdcinekTrasy() {}

    public OdcinekTrasy(Stacja stacja1, Stacja stacja2, float dlugosc) {
        this.stacja1 = stacja1;
        this.stacja2 = stacja2;
        this.dlugosc = dlugosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stacja getStacja1() {
        return stacja1;
    }

    public void setStacja1(Stacja stacja1) {
        this.stacja1 = stacja1;
    }

    public Stacja getStacja2() {
        return stacja2;
    }

    public void setStacja2(Stacja stacja2) {
        this.stacja2 = stacja2;
    }

    public float getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(float dlugosc) {
        this.dlugosc = dlugosc;
    }
}
