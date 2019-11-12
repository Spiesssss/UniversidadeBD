package com.example.multiplasinterfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Esse método vai mandar o programa para a outra tela sem nenhuma informação
    //adicional atrelada.
    public void vaiParaOutraTela(View view) {
        Intent minhaIntent = new Intent();
        startActivity(minhaIntent);
    }


    //Esse método vai mandar o programa para outra tela junto com o nome digitado.
    public void vaiParaOutraTelaMandandoNome(View view) {
        Intent minhaIntent = new Intent();
        EditText pegaNome = findViewById(R.id.nome);
        minhaIntent.putExtra("nome",pegaNome.getText().toString());
        startActivity(minhaIntent);
    }


}
