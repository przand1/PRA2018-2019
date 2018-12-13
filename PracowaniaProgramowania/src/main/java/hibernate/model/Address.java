package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String city;

    @Column(length = 5, nullable = false)
    String nr;

    public Address(String street, String city, String nr, String housenr, String postcode) {
        this.street = street;
        this.city = city;
        this.nr = nr;
        this.housenr = housenr;
        this.postcode = postcode;
    }
    public Address() {}

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", nr='" + nr + '\'' +
                ", housenr='" + housenr + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    @Column(length = 5)
    String housenr;

    @Column(length = 5, nullable = false)
    String postcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getHousenr() {
        return housenr;
    }

    public void setHousenr(String housenr) {
        this.housenr = housenr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}