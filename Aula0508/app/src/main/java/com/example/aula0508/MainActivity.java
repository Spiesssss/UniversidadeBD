package com.example.aula0508;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criaPessoa(View view) {
        //variáveis que vão armazenar os valores digitados pela pessoa
        String nome;
        int idade;

        //cria um objeto editText para pegar o que o usuário digitou
        EditText et1 = findViewById(R.id.et_nome);
        //pega a string digitada no editText
        nome = et1.getText().toString();

        //cria o editText que foi digitada a idade
        EditText et2 = findViewById(R.id.et_idade);
        idade = Integer.parseInt(et2.getText().toString());

        Pessoa novaPessoa = new Pessoa(nome,idade);

        TextView mostra = findViewById(R.id.tv_mostraPessoa);

        mostra.setText("A pessoa de nome : "+novaPessoa.getNome()+" e idade : "+
                novaPessoa.getIdade()+ " foi cadastrada com sucesso ");

    }
}
