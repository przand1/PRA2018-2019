package przyrost2.tabele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Trasa {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<OdcinekTrasy> przebiegTrasy = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Pociag_ID",referencedColumnName = "id")
    private Pociag pociag;

    @Column
    private float dlugosc;

    public Trasa() {}

    public Trasa(List<OdcinekTrasy> przebiegTrasy,Pociag pociag) {
        this.pociag = pociag;
        this.przebiegTrasy = przebiegTrasy;
        dlugosc = 0.0f;
        przebiegTrasy.forEach(odcinekTrasy -> dlugosc += odcinekTrasy.getDlugosc());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OdcinekTrasy> getPrzebiegTrasy() {
        return przebiegTrasy;
    }

    public void setPrzebiegTrasy(List<OdcinekTrasy> przebiegTrasy) {
        this.przebiegTrasy = przebiegTrasy;
    }

    public float getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(float dlugosc) {
        this.dlugosc = dlugosc;
    }

    public Pociag getPociag() {
        return pociag;
    }

    public void setPociag(Pociag pociag) {
        this.pociag = pociag;
    }
}
