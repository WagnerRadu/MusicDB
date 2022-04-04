package com.musicdb.interpretare;


import com.musicdb.melodie.Melodie;
import com.musicdb.muzician.Muzician;

import javax.persistence.*;

@Entity
@Table(name = "interpretari")
public class Interpretare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idinterpretare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmelodie")
    private Melodie melodie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmuzician")
    private Muzician muzician;

    public Integer getIdinterpretare() {
        return idinterpretare;
    }

    public void setIdinterpretare(Integer idinterpretare) {
        this.idinterpretare = idinterpretare;
    }

    public Melodie getMelodie() {
        return melodie;
    }

    public void setMelodie(Melodie melodie) {
        this.melodie = melodie;
    }

    public Muzician getMuzician() {
        return muzician;
    }

    public void setMuzician(Muzician muzician) {
        this.muzician = muzician;
    }
}
