package com.example.trabalhoum;

import android.os.Parcel;
import android.os.Parcelable;
import android.speech.RecognitionListener;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Parcelable, Serializable {
    public int id;
    public String user;
    public String senha;
    public int idade;
    public String profissao;
    public ArrayList<Recomendacao> recomendacoes;

    public Usuario() {

        this.recomendacoes = new ArrayList<>();
    }

    protected Usuario(Parcel in) {
        user = in.readString();
        senha = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public ArrayList<Recomendacao> getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(Recomendacao recomendacao) {
        this.recomendacoes.add(recomendacao);
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user);
        parcel.writeString(senha);
    }
}
