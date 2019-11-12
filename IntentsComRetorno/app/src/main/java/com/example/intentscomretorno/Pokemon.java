package com.example.intentscomretorno;

import android.os.Parcelable;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String nome;
    private String tipo;

    public Pokemon(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
