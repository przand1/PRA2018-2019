package przyrost2.tabele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cennik {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private float stawkaZaKm;

}
