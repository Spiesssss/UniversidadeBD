package com.example.aulaintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity {
    private ArrayList<Usuario> listaDeUsuarios;
    private Intent estaIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        estaIntent = getIntent();
    }
     public void fechar(View View){
        Intent intentRecebida = getIntent();
        String tipo = "";
        int codigo = intentRecebida.getIntExtra("requestCode",0);
        if(codigo==0){
            Intent novaIntent = new Intent();
            //Considerando que o valor adequado para o tipo foi pesquisado
            novaIntent.putExtra("tipo",tipo);
            setResult(RESULT_OK,novaIntent);
        }
     }

    public void cadastraUsuario(View view) {
        EditText pegaUsuario = findViewById(R.id.et_cadastraUsuario);
        EditText pegaSenha = findViewById(R.id.et_cadastraSenha);
        listaDeUsuarios = (ArrayList<Usuario>)getIntent().getSerializableExtra("listaUsuarios");

        Usuario novoUsuario = new Usuario(pegaUsuario.getText().toString(),
                pegaSenha.getText().toString());

        System.out.println("criei um usuário: "+novoUsuario.getNome()+" "+novoUsuario.getSenha());
        Intent novaIntent = new Intent();
        listaDeUsuarios.add(novoUsuario);
        novaIntent.putExtra("listaUsuarios",listaDeUsuarios);
        setResult(Activity.RESULT_OK,novaIntent);
        finish();
    }
}
