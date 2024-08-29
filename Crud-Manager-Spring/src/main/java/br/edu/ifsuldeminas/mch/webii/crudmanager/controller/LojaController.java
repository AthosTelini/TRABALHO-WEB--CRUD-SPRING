package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Loja;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.LojaRepository;
import jakarta.validation.Valid;

@Controller
public class LojaController {

    @Autowired
    private LojaRepository lojaRepo;

    @GetMapping("/lojas")
    public String listLojas(Model model) {
        List<Loja> lojas = lojaRepo.findAll();
        model.addAttribute("lojas", lojas);
        return "lojas";
    }

    @GetMapping("/lojas/form")
    public String lojaForm(@ModelAttribute("loja") Loja loja) {
        return "lojas_form";
    }

    @PostMapping("/lojas/register")
    public String lojaNew(@Valid @ModelAttribute("loja") Loja loja, BindingResult erros) {
        if (erros.hasErrors()) {
            return "lojas_form";
        }
        lojaRepo.save(loja);
        return "redirect:/lojas";
    }

    @GetMapping("/lojas/update/{id}")
    public String lojaUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Loja> lojaOpt = lojaRepo.findById(id);
        Loja loja = lojaOpt.orElseGet(Loja::new);
        model.addAttribute("loja", loja);
        return "lojas_form";
    }

    @GetMapping("/lojas/delete/{id}")
    public String lojaDelete(@PathVariable("id") Integer id) {
        lojaRepo.deleteById(id);
        return "redirect:/lojas";
    }
}