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
}
