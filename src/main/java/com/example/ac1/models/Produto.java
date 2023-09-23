package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 400, nullable = false)
    private String nome;
    @Column(nullable = false)
    private int prod_qtd;

    @ManyToOne
    @JoinColumn(name = "CategoriaProdutos_id")
    private CategoriaProdutos categoriaProdutos;

    public Produto() {

    }

    public Produto(Long id, String nome, int prod_qtd) {
        this.id = id;
        this.nome = nome;
        this.prod_qtd = prod_qtd;
    }

    public Long getId_produto() {
        return id;
    }

    public void setId_produto(Long prod_id) {
        this.id = prod_id;
    }

    public String getProd_nome() {
        return nome;
    }

    public void setProd_nome(String prod_nome) {
        this.nome = prod_nome;
    }

    public int getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }

    public CategoriaProdutos getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public void setCategoriaProduto(CategoriaProdutos categoriaProdutos) {
        this.categoriaProdutos = categoriaProdutos;
    }

    @Override
    public String toString() {
        return "Produtos [id= " + id + ", nome= " + nome + ", prod_qtd= " + prod_qtd
                + ", categoriaProdutos=" + categoriaProdutos + "]";
    }
}
