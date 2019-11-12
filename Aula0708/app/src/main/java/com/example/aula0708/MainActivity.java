package com.example.aula0708;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Conta minhaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criaContaPoupanca(View view) {
        EditText etNumero = findViewById(R.id.et_numConta);
        EditText etSaldo = findViewById(R.id.et_saldoConta);
        int numero = Integer.parseInt(etNumero.getText().toString());
        double saldo = Double.parseDouble(etSaldo.getText().toString());

        minhaConta = new ContaPoupanca(numero,saldo);
    }

    public void criaContaCorrente(View view) {
        EditText etNumero = findViewById(R.id.et_numConta);
        EditText etSaldo = findViewById(R.id.et_saldoConta);
        int numero = Integer.parseInt(etNumero.getText().toString());
        double saldo = Double.parseDouble(etSaldo.getText().toString());

        minhaConta = new ContaCorrente(numero,saldo);
    }

    public void passarMes(View view) {
        minhaConta.passarMes();
        TextView mostraInfo = findViewById(R.id.tvMostraPassarMes);

        String textoQueVaiSerExibido = "O mês foi passado e o novo saldo é :"+
                minhaConta.getSaldo();

        mostraInfo.setText(textoQueVaiSerExibido);
    }
}
