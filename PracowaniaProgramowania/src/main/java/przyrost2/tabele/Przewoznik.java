package przyrost2.tabele;

import javax.persistence.*;

@Entity
public class Przewoznik {
    @Id
    @GeneratedValue
    private int id;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Cennik_ID", referencedColumnName = "id")
    private Cennik cennik;

    @Column
    private String nazwa;
    @Column
    private String skrot;
    @Column
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
