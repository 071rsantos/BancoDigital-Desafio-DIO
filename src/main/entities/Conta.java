package main.entities;

import main.interfaces.IConta;

public class Conta implements IConta{

    private String agencia;
    private int numero;
    private double saldo;

    public Conta( int numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }


    public String getAgencia() {
        return agencia;
    }



    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }



    public int getNumero() {
        return numero;
    }



    public void setNumero(int numero) {
        this.numero = numero;
    }



    public double getSaldo() {
        return saldo;
    }



    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void deposito(double valor) {
        setSaldo(getSaldo()+valor);
    }

    @Override
    public void saque(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo()-valor);
        } else throw new RuntimeException("Saldo Insuficiente");
    }

    @Override
    public void transferencia(double valor, Conta destino) {
        if (valor > 0 && valor <= saldo) {
            saque(valor);
            destino.deposito(valor);
        }
    }

}
