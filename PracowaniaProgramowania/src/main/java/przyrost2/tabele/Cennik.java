package przyrost2.tabele;

import javax.persistence.*;

@Entity
@Table(name = "CENNIKI")
public class Cennik {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "ID")
    private int id;

    @Column(name = "Stawka_za_km_Klasa_1")
    private float stawkaZaKmKl1;
    @Column(name = "Stawka_za_km_Klasa_2")
    private float stawkaZaKmKl2;

    public Cennik() {}

    public Cennik(float stawkaZaKmKl1, float stawkaZaKmKl2) {
        this.stawkaZaKmKl1 = stawkaZaKmKl1;
        this.stawkaZaKmKl2 = stawkaZaKmKl2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getStawkaZaKmKl1() {
        return stawkaZaKmKl1;
    }

    public void setStawkaZaKmKl1(float stawkaZaKmKl1) {
        this.stawkaZaKmKl1 = stawkaZaKmKl1;
    }

    public float getStawkaZaKmKl2() {
        return stawkaZaKmKl2;
    }

    public void setStawkaZaKmKl2(float stawkaZaKmKl2) {
        this.stawkaZaKmKl2 = stawkaZaKmKl2;
    }
}
