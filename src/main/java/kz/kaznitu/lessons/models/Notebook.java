package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String model ;
    private String company ;
    private String strana ;

    public Notebook(){}

    public Notebook(String model, String company, String strana) {
        this.model = model;
        this.company = company;
        this.strana = strana;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }
}

