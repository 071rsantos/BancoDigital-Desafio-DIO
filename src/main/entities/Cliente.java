package main.entities;

public class Cliente {
    private String nome;
    private String cpf;
    private Conta contaCliente;

    public Cliente(String nome, String cpf, Conta contaCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.contaCliente = contaCliente;
    }

    public String getNome() {
        return nome;
    }


    public String getCpf() {
        return cpf;
    }

    public Conta getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(Conta contaCliente) {
        this.contaCliente = contaCliente;
    }
    
}
