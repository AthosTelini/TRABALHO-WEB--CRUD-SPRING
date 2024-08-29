package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Produto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.LojaRepository;
import jakarta.validation.Valid;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private LojaRepository lojaRepo;

    @GetMapping("/produtos")
    public String listProdutos(Model model) {
        List<Produto> produtos = produtoRepo.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/produtos/form")
    public String produtoForm(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("lojas", lojaRepo.findAll());
        return "produtos_form";
    }

    @PostMapping("/produtos/register")
    public String produtoNew(@Valid @ModelAttribute("produto") Produto produto, BindingResult erros, Model model) {
        if (erros.hasErrors()) {
            model.addAttribute("lojas", lojaRepo.findAll());
            return "produtos_form";
        }
        produtoRepo.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/produtos/update/{id}")
    public String produtoUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Produto> produtoOpt = produtoRepo.findById(id);
        Produto produto = produtoOpt.orElseGet(Produto::new);
        model.addAttribute("produto", produto);
        model.addAttribute("lojas", lojaRepo.findAll());
        return "produtos_form";
    }

    @GetMapping("/produtos/delete/{id}")
    public String produtoDelete(@PathVariable("id") Integer id) {
        produtoRepo.deleteById(id);
        return "redirect:/produtos";
    }
}