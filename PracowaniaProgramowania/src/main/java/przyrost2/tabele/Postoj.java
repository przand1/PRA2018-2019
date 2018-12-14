package przyrost2.tabele;

import javax.persistence.*;

@Entity
public class Postoj {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "Pociag_ID",referencedColumnName = "id")
    private Pociag pociag;

    @ManyToOne
    @JoinColumn(name = "Stacja_ID",referencedColumnName = "id")
    private Stacja stacja;

//    @Column
//    private
}
