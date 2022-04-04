
package com.musicdb;


import com.musicdb.muzician.Muzician;
import com.musicdb.muzician.MuzicianRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MuzicianRepositoryTest {
    @Autowired private MuzicianRepository repo;

    @Test
    public void testAddNew() throws ParseException {
        Muzician muzician = new Muzician();
        muzician.setNume("George");
        muzician.setPrenume("Lautaru");
        muzician.setGen_muzical("populara");
        //muzician.setData_nasterii(new SimpleDateFormat("yyyy-MM-dd").parse("1992-07-26"));
        muzician.setTara("Romania");

        Muzician savedMuzician = repo.save(muzician);
        Assertions.assertThat(savedMuzician).isNotNull();
        Assertions.assertThat(savedMuzician.getIdmuzician()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Muzician> muzicieni = repo.findAll();
        Assertions.assertThat(muzicieni).hasSizeGreaterThan(0);
        for (Muzician muzician : muzicieni) {
            System.out.println(muzician);
        }
    }

    @Test
    public void testUpdate() {
        Integer muzicianId = 1;
        Optional<Muzician> optionalMuzician = repo.findById(muzicianId);
        Muzician muzician = optionalMuzician.get();
        muzician.setGen_muzical("Death metal");
        repo.save(muzician);
        Muzician updatedMuzician = repo.findById(muzicianId).get();
        Assertions.assertThat(updatedMuzician.getGen_muzical()).isEqualTo("Death metal");
    }

    @Test
    public void testGet() {
        Integer muzicianId = 7;
        Optional<Muzician> optionalMuzician = repo.findById(muzicianId);
        Assertions.assertThat(optionalMuzician).isPresent();
        System.out.println(optionalMuzician.get());
    }

    @Test
    public void testDelete() {
        Integer muzicianId = 1;
        repo.deleteById(muzicianId);
        Optional<Muzician> optionalMuzician = repo.findById(muzicianId);
        Assertions.assertThat(optionalMuzician).isNotPresent();

    }
}
