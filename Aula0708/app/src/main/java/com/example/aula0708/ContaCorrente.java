package com.example.aula0708;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public void passarMes() {
        super.setSaldo(super.getSaldo()-30.0);
    }
}
