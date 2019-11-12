package com.example.aula1;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);
    }

    public ContaCorrente(int numero) {
        super(numero);
    }

    @Override
    public void passarMes() {
        super.setSaldo(super.getSaldo()-30.0);
    }
}
