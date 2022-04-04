package com.musicdb.melodie;

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
public class MelodieController {
    @Autowired
    private MelodieService service;
    @GetMapping("/melodii")
    public String showMelodiiList(Model model) {
        List<Melodie> melodieList = service.listAll();
        model.addAttribute("melodieList", melodieList);
        return "melodii";
    }

    @GetMapping("/melodii/add")
    public String showAddForm(Model model) {
        model.addAttribute("melodie", new Melodie());
        return "melodie_form";
    }

    @PostMapping("/melodii/save")
    public String addMelodie(Melodie melodie) {
        service.save(melodie);
        return "redirect:/melodii";
    }

    @GetMapping("/melodii/delete/{idmelodie}")
    public String deleteMelodie(@PathVariable("idmelodie") Integer idmelodie) {
        service.delete(idmelodie);
        return "redirect:/melodii";
    }

    @GetMapping("/melodii/edit/{idmelodie}")
    public String showEditForm(@PathVariable("idmelodie") Integer idmelodie, Model model) {
        Melodie melodie = service.get(idmelodie);
        model.addAttribute("melodie", melodie);
        return "editare_melodie_form";
    }


}
