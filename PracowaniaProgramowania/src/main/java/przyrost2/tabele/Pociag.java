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


}
