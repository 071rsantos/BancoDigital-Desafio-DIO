package main;

import java.util.Optional;

import main.entities.Banco;
import main.entities.Cliente;
import main.entities.Conta;
import main.entities.Corrente;
import main.entities.Poupanca;

public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco do RS7"); // criando banco

        Corrente cc1= new Corrente(7774);
        Poupanca cp1 = new Poupanca(7776);

        Cliente cliente1 = new Cliente("Rodrigo", "123.456.789-10", cc1);
        Cliente cliente2 = new Cliente("Melissa", "987.654.321-10", cp1);

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        cc1.deposito(1412.0);
        cp1.deposito(1500.0);

        banco.transferir(7774, 7776, 250);

        System.out.println("Saldo CC: "+cc1.getSaldo());
        System.out.println("Saldo CP: "+cp1.getSaldo());

        banco.listarClientes().forEach(l -> System.out.println(l.getNome()+ ", " +l.getCpf()));

        Optional<Conta> conta = banco.encontrarCliente("123.456.789-10").map(Cliente::getContaCliente);
        conta.ifPresent(c -> System.out.println("Conta encontrada: "+c.getNumero()+ ", Saldo R$ " +c.getSaldo()));
        if (!conta.isPresent()) {
            System.out.println("Cliente não encontrado.");
        }
    }
}
