package przyrost2.tabele;

import javax.persistence.*;

@Entity
@Table(name = "POCIAGI")
public class Pociag {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Przewoznik_ID", referencedColumnName = "id")
    private Przewoznik przewoznik;

    @Column(name = "Nazwa")
    private String nazwa;

    public Pociag(Przewoznik przewoznik, String nazwa, int ilocsMiejsc, float predkoscSrednia) {
        this.przewoznik = przewoznik;
        this.nazwa = nazwa;
        this.ilocsMiejsc = ilocsMiejsc;
        this.predkoscSrednia = predkoscSrednia;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Column(name = "Ilosc_Miejsc")
    private int ilocsMiejsc;
    @Column(name = "Predkosc_Srednia")
    private float predkoscSrednia;

    public Pociag() {}

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
