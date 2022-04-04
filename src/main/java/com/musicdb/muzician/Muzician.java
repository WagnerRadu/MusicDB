package com.musicdb.muzician;

import com.musicdb.interpretare.Interpretare;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "muzicieni")
public class Muzician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmuzician;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private String gen_muzical;
    @Column
    private Date data_nasterii;
    @Column
    private String tara;

    public Integer getIdmuzician() {
        return idmuzician;
    }

    public void setIdmuzician(Integer id) {
        this.idmuzician = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getGen_muzical() {
        return gen_muzical;
    }

    public void setGen_muzical(String gen_muzical) {
        this.gen_muzical = gen_muzical;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    @Override
    public String toString() {
        return "Muzician{" +
                "idmuzician=" + idmuzician +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", gen_muzical='" + gen_muzical + '\'' +
                ", data_nasterii=" + data_nasterii +
                ", tara='" + tara + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "muzician", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Interpretare> interpretaris = new HashSet<>();
}
