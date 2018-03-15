package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Dostavka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;
    private String magazin;

    public Dostavka() {
    }

    public Dostavka(String city, String magazin) {
        this.city = city;
        this.magazin = magazin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getMagazin() {
        return magazin;
    }

    public void setMagazin(String magazin) {
        this.magazin = magazin;
    }
}