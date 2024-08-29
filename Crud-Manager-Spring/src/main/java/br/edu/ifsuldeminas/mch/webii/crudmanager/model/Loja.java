package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Nome da loja é obrigatório.")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório.")
    private String endereco;

    @NotBlank(message = "Nome do gerente é obrigatório.")
    private String nomeGerente;

    @NotBlank(message = "Telefone da loja é obrigatório.")
    private String telefoneDaLoja;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public String getTelefoneDaLoja() {
        return telefoneDaLoja;
    }

    public void setTelefoneDaLoja(String telefoneDaLoja) {
        this.telefoneDaLoja = telefoneDaLoja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}