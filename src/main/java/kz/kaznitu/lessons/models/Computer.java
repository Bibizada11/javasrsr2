package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String mdl ;
    private String comp ;
    private String country;

    public Computer(){}

    public Computer(String mdl, String comp, String country) {
        this.mdl = mdl;
        this.comp = comp;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return mdl;
    }

    public void setModel(String model) {
        this.mdl = mdl;
    }

    public String getCompany() {
        return comp;
    }

    public void setCompany(String company) {
        this.comp = comp;
    }

    public String getStrana() {
        return country;
    }

    public void setStrana(String strana) {
        this.country = country;
    }
}

