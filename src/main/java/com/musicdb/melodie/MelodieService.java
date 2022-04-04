package com.musicdb.melodie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MelodieService {
    @Autowired private MelodieRepository repo;

    public List<Melodie> listAll() {
        return (List<Melodie>) repo.findAll();
    }

    public void save(Melodie melodie) {
        repo.save(melodie);
    }

    public void delete(Integer idmelodie) {
        repo.deleteById(idmelodie);
    }

    public Melodie get(Integer idmelodie) {
        Optional<Melodie> melodie = repo.findById(idmelodie);
        return melodie.get();
    }

}
