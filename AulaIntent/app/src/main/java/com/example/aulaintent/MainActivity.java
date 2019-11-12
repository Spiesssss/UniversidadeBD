package com.example.aulaintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int PEGATIPO =0;
    private static final int PEGAEVOLUCAO =1;

    private ArrayList<Usuario> listaDeUsuarios;
    //private static final int CADASTRO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDeUsuarios = new ArrayList<Usuario>();
    }

    public void vaiParaCadastro(View view) {


        String nomePokemom = "Pikachu";

        Intent minhaIntent = new Intent(this, TelaCadastro.class);
        //Considerando que a variável nomePokemon foi extraída de um editText
        minhaIntent.putExtra("nome",nomePokemom);
        //Adicionando o tipo de requisição desejado
        minhaIntent.putExtra("requestCode",PEGATIPO);
        startActivityForResult(minhaIntent,PEGATIPO);

        //minhaIntent.putExtra("listaUsuarios",listSaDeUsuarios);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PEGATIPO){
            Toast.makeText(this, data.getStringExtra("tipo")
                    , Toast.LENGTH_SHORT).show();
        }

        listaDeUsuarios = (ArrayList<Usuario>)data.getSerializableExtra("listaUsuarios");
        System.out.println("aqui: "+listaDeUsuarios.get(0).getNome());
    }
}
