package com.example.semanaacademica;

public class Musica {
    //Campos da nossa classe música
    private String nomeMusica;
    private String nomeArtista;
    private String nomeArquivo;

    //Construtor da classe Música
    public Musica(String nomeMusica, String nomeArtista, String nomeArquivo) {
        this.nomeMusica = nomeMusica;
        this.nomeArtista = nomeArtista;
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
