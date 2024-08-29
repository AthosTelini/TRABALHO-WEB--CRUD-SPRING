package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Tipo de produto é obrigatório.")
    private String tipoProduto;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Tamanho é obrigatório.")
    private String tamanho;

    @NotNull(message = "Preço é obrigatório.")
    private Double preco;

    @ManyToOne
    @NotNull(message = "Loja é obrigatória.")
    @JoinColumn(name = "loja_id", nullable = false)
    private Loja loja;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}