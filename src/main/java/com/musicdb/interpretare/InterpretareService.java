package com.musicdb.interpretare;

import com.musicdb.melodie.Melodie;
import com.musicdb.melodie.MelodieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterpretareService {
    @Autowired
    private InterpretareRepository repo;

    public List<Interpretare> listAll() {
        return (List<Interpretare>) repo.findAll();
    }

    public void save(Interpretare interpretare) {
        repo.save(interpretare);
    }

    public void delete(Integer idinterpretare) {
        //Optional<Melodie> melodie = repo.findById(idmelodie);
        repo.deleteById(idinterpretare);
    }

    public Interpretare get(Integer idinterpretare) {
        Optional<Interpretare> interpretare = repo.findById(idinterpretare);
        return interpretare.get();
    }
}
