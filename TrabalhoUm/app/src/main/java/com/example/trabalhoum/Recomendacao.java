package com.example.trabalhoum;

public class Recomendacao {
    public int id;
    public int usuarioId;
    public String nome;
    public String categoria;
    public String descricao;
    public String ondeEncontrar;

    public Recomendacao() {
    }

    public Recomendacao(String nome, String categoria, String descricao, String ondeEncontrar) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.ondeEncontrar = ondeEncontrar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOndeEncontrar() {
        return ondeEncontrar;
    }

    public void setOndeEncontrar(String ondeEncontrar) {
        this.ondeEncontrar = ondeEncontrar;
    }
}
