package main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco {
    private String nome;
    private List<Cliente> clientes;
    Scanner sc = new Scanner(System.in);

    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(String cpf){
        Cliente clienteRemover = null;
        for (Cliente c : clientes) {
            if (cpf.equals(c.getCpf())) {
                clienteRemover = c;
            }
        }
        clientes.remove(clienteRemover);
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor){
        Optional<Conta> origem= clientes.stream()
                                        .map(Cliente::getContaCliente)
                                        .filter(conta -> conta.getNumero() == numeroOrigem)
                                        .findFirst();
        Optional<Conta> destino= clientes.stream()
                                        .map(Cliente::getContaCliente)
                                        .filter(conta -> conta.getNumero() == numeroDestino)
                                        .findFirst();
        if (origem.isPresent() && destino.isPresent() && valor > 0) {
            origem.get().transferencia(valor, destino.get());
        }
    }

    public List<Cliente> listarClientes(){
        return clientes.stream().toList();
    }

    public Optional<Cliente> encontrarCliente(String cpf){
        return clientes.stream()
                        .filter(conta -> conta.getCpf().equals(cpf))
                        .findFirst();
    }

}
