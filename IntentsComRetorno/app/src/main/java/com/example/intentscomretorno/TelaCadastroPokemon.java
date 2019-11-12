package com.example.intentscomretorno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TelaCadastroPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_pokemon);
    }

    public void cadastraPokemon(View view){
        EditText pegaNome = findViewById(R.id.et_nomePokemon);
        EditText pegaTipo = findViewById(R.id.et_tipoPokemon);
        String nomePokemon = pegaNome.getText().toString();
        String tipoPokemon = pegaTipo.getText().toString();
        Intent minhaIntent = new Intent();
        minhaIntent.putExtra("nome",nomePokemon);
        minhaIntent.putExtra("tipo",tipoPokemon);
        setResult(RESULT_OK,minhaIntent);
        finish();
    }
}
