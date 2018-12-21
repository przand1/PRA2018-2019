package przyrost2.tabele;

import javax.persistence.*;

@Entity
@Table(name = "STACJE")
public class Stacja {

    public boolean equals(Stacja s) {
        return this.id == s.getId();
    }

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;

    @Column(name = "Nazwa_Stacji")
    private String nazwa;

    @Column(name = "Miasto")
    private String miasto;

    @Column(name = "Liczba_Peronow")
    private int liczbaPeronow;

    public Stacja() {}

    public Stacja(String nazwa, String miasto, int liczbaPeronow) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.liczbaPeronow = liczbaPeronow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getLiczbaPeronow() {
        return liczbaPeronow;
    }

    public void setLiczbaPeronow(int liczbaPeronow) {
        this.liczbaPeronow = liczbaPeronow;
    }
}
