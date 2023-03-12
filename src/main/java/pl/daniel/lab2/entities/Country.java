package pl.daniel.lab2.entities;

import jakarta.persistence.*;

@Entity
public class Country {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String nazwa;

    @Column
    private String kontynent;

    @Column
    private Double liczbaLudnosci;

    @Column
    private Double powierzchnia;

    public Country() {
    }

    @Override
    public String toString() {
        return "Encja Country{ id=" + id + ", nazwa " + nazwa + ", kontynent " +
                kontynent + ", liczba ludnosci=" + liczbaLudnosci + ", powierzchnia=" + powierzchnia +
                "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKontynent() {
        return kontynent;
    }

    public void setKontynent(String kontynent) {
        this.kontynent = kontynent;
    }

    public Double getLiczbaLudnosci() {
        return liczbaLudnosci;
    }

    public void setLiczbaLudnosci(Double liczbaLudnosci) {
        this.liczbaLudnosci = liczbaLudnosci;
    }

    public Double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }
}
