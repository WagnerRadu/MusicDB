package com.musicdb.muzician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzicianService {
    @Autowired private MuzicianRepository repo;

    public List<Muzician> listAll() {
        return (List<Muzician>) repo.findAll();
    }


    public void save(Muzician muzician) {
        repo.save(muzician);
    }

    public void delete(Integer idmuzician) {
        repo.deleteById(idmuzician);
    }

    public Muzician get(Integer idmuzician) {
        Optional<Muzician> muzician = repo.findById(idmuzician);
        return muzician.get();
    }
}
