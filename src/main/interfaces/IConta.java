package main.interfaces;

import main.entities.Conta;

public interface IConta {
    public abstract void deposito(double valor);
    public abstract void saque(double valor);
    public abstract void transferencia(double valor, Conta conta);
}
