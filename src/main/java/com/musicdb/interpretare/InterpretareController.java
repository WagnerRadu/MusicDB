package com.musicdb.interpretare;

import com.musicdb.melodie.Melodie;
import com.musicdb.melodie.MelodieService;
import com.musicdb.muzician.Muzician;
import com.musicdb.muzician.MuzicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InterpretareController {
    @Autowired
    private InterpretareService service;

    @Autowired
    private MuzicianService muzicianService;

    @Autowired
    private MelodieService melodieService;

    @GetMapping("/interpretari")
    public String showMuzicieniList(Model model) {
        List<Interpretare> interpretareList = service.listAll();
        model.addAttribute("interpretareList", interpretareList);
        return "interpretari";
    }

    @GetMapping("/interpretari/add")
    public String showAddForm(Model model) {
        List<Muzician> muzicieniList = muzicianService.listAll();
        List<Melodie> melodiiList = melodieService.listAll();
        model.addAttribute("interpretare", new Interpretare());
        model.addAttribute("muzicieniList", muzicieniList);
        model.addAttribute("melodiiList", melodiiList);
        return "interpretare_form";
    }

    @PostMapping("/interpretari/save")
    public String addInterpretare(Interpretare interpretare) {
        service.save(interpretare);
        return "redirect:/interpretari";
    }

    @GetMapping("/interpretari/delete/{idinterpretare}")
    public String deleteInterpretare(@PathVariable("idinterpretare") Integer idinterpretare) {
        service.delete(idinterpretare);
        return "redirect:/interpretari";
    }

    @GetMapping("/interpretari/edit/{idinterpretare}")
    public String showEditForm(@PathVariable("idinterpretare") Integer idinterpretare, Model model) {
        Interpretare interpretare = service.get(idinterpretare);
        List<Muzician> muzicieniList = muzicianService.listAll();
        List<Melodie> melodiiList = melodieService.listAll();
        model.addAttribute("interpretare", interpretare);
        model.addAttribute("muzicieniList", muzicieniList);
        model.addAttribute("melodiiList", melodiiList);
        return "editare_interpretare_form";
    }
}