package com.example.universidadebd;

public class Curso {
    private String nome;
    private String descricao;
    private int codigo;
    private int duracao;

    public Curso(String nome, String descricao, int codigo, int duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
