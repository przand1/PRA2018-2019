package przyrost2.tabele;

import javax.persistence.*;

@Entity
public class Pociag {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "Przewoznik_ID", referencedColumnName = "id")
    private Przewoznik przewoznik;

    @Column
    private int ilocsMiejsc;
    @Column
    private float predkoscSrednia;

    public Pociag() {}

    public Pociag(Przewoznik przewoznik, int ilocsMiejsc, float predkoscSrednia) {
        this.przewoznik = przewoznik;
        this.ilocsMiejsc = ilocsMiejsc;
        this.predkoscSrednia = predkoscSrednia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Przewoznik getPrzewoznik() {
        return przewoznik;
    }

    public void setPrzewoznik(Przewoznik przewoznik) {
        this.przewoznik = przewoznik;
    }

    public int getIlocsMiejsc() {
        return ilocsMiejsc;
    }

    public void setIlocsMiejsc(int ilocsMiejsc) {
        this.ilocsMiejsc = ilocsMiejsc;
    }

    public float getPredkoscSrednia() {
        return predkoscSrednia;
    }

    public void setPredkoscSrednia(float predkoscSrednia) {
        this.predkoscSrednia = predkoscSrednia;
    }
}
