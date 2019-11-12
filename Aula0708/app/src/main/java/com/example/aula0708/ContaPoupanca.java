package com.example.aula0708;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void passarMes() {
        super.setSaldo((super.getSaldo()*0.005)+super.getSaldo());
    }
}
