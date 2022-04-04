package com.musicdb.melodie;

import com.musicdb.interpretare.Interpretare;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "melodii")
public class Melodie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idmelodie;
    @Column
    String nume;
    @Column
    Integer durata;

    public Integer getIdmelodie() {
        return idmelodie;
    }

    public void setIdmelodie(Integer idmelodie) {
        this.idmelodie = idmelodie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    @OneToMany(mappedBy = "melodie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Interpretare> interpretaris = new HashSet<>();
}
