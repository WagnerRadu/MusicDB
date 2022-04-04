package com.musicdb.muzician;

import com.musicdb.melodie.Melodie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MuzicianController {
    @Autowired private MuzicianService service;
    @GetMapping("/muzicieni")
    public String showMuzicieniList(Model model) {
        List<Muzician> muzicianList = service.listAll();
        model.addAttribute("muzicianList", muzicianList);
        return "muzicieni";
    }

    @GetMapping("/muzicieni/add")
    public String showAddForm(Model model) {
        model.addAttribute("muzician", new Muzician());
        return "muzician_form";
    }

    @PostMapping("/muzicieni/save")
    public String addMuzician(Muzician muzician) {
        service.save(muzician);
        return "redirect:/muzicieni";
    }

    @GetMapping("muzicieni/delete/{idmuzician}")
    public String deleteMuzician(@PathVariable ("idmuzician") Integer idmuzician) {
        service.delete(idmuzician);
        return "redirect:/muzicieni";
    }

    @GetMapping("/muzicieni/edit/{idmuzician}")
    public String showEditForm(@PathVariable("idmuzician") Integer idmuzician, Model model) {
        Muzician muzician = service.get(idmuzician);
        model.addAttribute("muzician", muzician);
        return "editare_muzician_form";
    }
}
