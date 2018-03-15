package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class TelePhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String mdl ;
    private String comp ;
    private String country ;

    public TelePhone(){}

    public TelePhone(String model, String company, String country) {
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
