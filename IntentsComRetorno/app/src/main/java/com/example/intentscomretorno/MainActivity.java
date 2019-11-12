package com.example.intentscomretorno;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pokemon> listaPokemons;

    private static final int CADASTRO_POKEMON =0;
    private static final int EDICAO_POKEMON =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPokemons = new ArrayList<Pokemon>();
    }

    public void vaiParaAdicao(View view) {
        Intent minhaIntent = new Intent(this,TelaCadastroPokemon.class);
        //funciona se eu apenas quero ir para outra atividade
        //startActivity(minhaIntent);

        //para ter um retorno eu tenho que usar
        startActivityForResult(minhaIntent,CADASTRO_POKEMON);
    }

    //O que fazer quando voltar para essa tela
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, @Nullable Intent intentResultado) {
        super.onActivityResult(requestCode, resultCode, intentResultado);
        if(requestCode==CADASTRO_POKEMON){
            if(resultCode==RESULT_OK){
                //Código que exibe a lista na tela
                Pokemon novoPokemon =
                        new Pokemon(intentResultado.getStringExtra("nome"),
                                intentResultado.getStringExtra("tipo"));
                listaPokemons.add(novoPokemon);
            }
        }else if(requestCode==EDICAO_POKEMON){

        }
    }

    public void mostraLista(View view) {
        String textoASerExibido="";
        Toast.makeText(this, "Olá", Toast.LENGTH_SHORT).show();
        for (int x=0; x<listaPokemons.size();x++){
            Pokemon estePokemon = listaPokemons.get(x);
            textoASerExibido = textoASerExibido+"Nome: "+ estePokemon.getNome()+
                    " Tipo: "+estePokemon.getTipo()+"\n ";
        }
        TextView mostraTexto = findViewById(R.id.tv_mostraListaPokemon);
        mostraTexto.setText(textoASerExibido);
    }
}
