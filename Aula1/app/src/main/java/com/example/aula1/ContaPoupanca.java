package com.example.aula1;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo);
    }

    public ContaPoupanca(int numero) {
        super(numero);
    }

    @Override
    public void passarMes() {
        /*double valorSaldo = super.getSaldo();
        double valorASerAdicionado = valorSaldo*0.005;
        double novoValor = valorSaldo+valorASerAdicionado;
        super.setSaldo(novoValor);*/

        super.setSaldo((super.getSaldo()*0.005)+super.getSaldo());
    }
}
