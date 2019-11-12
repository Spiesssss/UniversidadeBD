package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Conta c1 = new ContaCorrente(1,5000);
        c1.passarMes();

        EditText et1 = findViewById(R.id.nomePessoa);
        String nomePessoa = et1.getText().toString();

        TextView exibeNome = findViewById(R.id.exibeNome);
        exibeNome.setText("Olá cliente "+nomePessoa+ " seja bem vindo!");

        TextView texto = findViewById(R.id.caixaTexto);
        texto.setText(String.valueOf(c1.getSaldo()));


    }
}
