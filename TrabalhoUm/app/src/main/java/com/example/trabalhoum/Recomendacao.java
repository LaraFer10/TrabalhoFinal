package com.example.trabalhoum;

public class Recomendacao {
    public String nome;
    public String classificacao;
    public String descricao;
    public String ondeAssistir;

    public Recomendacao(String nome, String classificacao, String descricao, String ondeAssistir) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.descricao = descricao;
        this.ondeAssistir = ondeAssistir;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }
}
