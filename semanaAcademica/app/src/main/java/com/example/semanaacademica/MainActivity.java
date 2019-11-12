package com.example.semanaacademica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Criar uma playlist (vetor de músicas)
    private ArrayList<Musica> playlist;
    //controla qual música está tocando
    private int musicaAtual;
    //objeto de manipulação de midias
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializa os campos
        playlist = new ArrayList<Musica>();
        musicaAtual=0;
        mediaPlayer = MediaPlayer.create(this,R.raw.musica1);

        inicializaPlaylist();
    }

    public void inicializaPlaylist() {
        //Cria música e coloca ela dentro da playlist
        //Criou e adicionou a primeira música
        Musica estaMusica =
                new Musica("Hit em Up (Dirty)",
                        "2 Pac","musica1");
        playlist.add(estaMusica);

        estaMusica = new Musica("Boate Azul",
                "Milionário e José Rico","musica2");
        playlist.add(estaMusica);

        estaMusica = new Musica("Who Shot Ya","Notorious BIG",
                "musica3");
        playlist.add(estaMusica);

        estaMusica = new Musica("sanfona mix", "desconhecido",
                "musica4");
        playlist.add(estaMusica);

        estaMusica= new Musica("Deixa em off", "turma do pagonde",
                "musica5");
        playlist.add(estaMusica);

    }

    //Este método é chamado quando eu apertar no play
    public void tocar(View view){
        tocarMusica();
    }

    //Método que manipula a interface gráfica
    public void tocarMusica(){
        mediaPlayer.stop();
        //Cria os objetos da interface gráfica
        TextView tv_mostraNome = findViewById(R.id.tv_mostraNomeMusica);
        TextView tv_mostraArtista = findViewById(R.id.tv_mostraNomeArtista);
        //variável música que está tocando
        Musica estaMusica = playlist.get(musicaAtual);
        //Coloca o texto na interface
        tv_mostraNome.setText(estaMusica.getNomeMusica());
        tv_mostraArtista.setText(estaMusica.getNomeArtista());

        //pegar o id do arquivo da música atual
        int idArquivoMusica = getResources()
                .getIdentifier(estaMusica.getNomeArquivo(),"raw",
                        getPackageName());
        mediaPlayer = MediaPlayer.create(this,idArquivoMusica);
        mediaPlayer.start();
    }

    public  void passarFrente(View view){
        mediaPlayer.stop();
        if(musicaAtual==playlist.size()-1){
            musicaAtual=0;
            tocarMusica();
        }else{
            musicaAtual++;
            tocarMusica();
        }


    }

    public void passarTras(View view){
        mediaPlayer.stop();
        if (musicaAtual==0){
            musicaAtual=playlist.size()-1;
            tocarMusica();
        }else {
            musicaAtual--;
            tocarMusica();
        }
    }

}
