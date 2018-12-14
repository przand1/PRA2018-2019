package przyrost2.tabele;

import com.sun.xml.internal.ws.server.ServerRtException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stacja {

    @Id
    @GeneratedValue
    private int id;


    @Column
    private String nazwa;

    @Column
    private String miasto;

    @Column
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
