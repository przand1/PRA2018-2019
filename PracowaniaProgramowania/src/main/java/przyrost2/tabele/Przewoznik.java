package przyrost2.tabele;

import javax.persistence.*;

@Entity
@Table(name = "PRZEWOZNICY")
public class Przewoznik {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Cennik_ID", referencedColumnName = "id")
    private Cennik cennik;

    @Column(name = "Nazwa_firmy")
    private String nazwa;
    @Column(name = "Skrot")
    private String skrot;
    @Column(name = "Adres_Siedziby")
    private String siedziba;

    public Przewoznik() {}

    public Przewoznik(Cennik cennik, String nazwa, String skrot, String siedziba) {
        this.cennik = cennik;
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.siedziba = siedziba;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cennik getCennik() {
        return cennik;
    }

    public void setCennik(Cennik cennik) {
        this.cennik = cennik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public String getSiedziba() {
        return siedziba;
    }

    public void setSiedziba(String siedziba) {
        this.siedziba = siedziba;
    }
}
