package lista1;

import java.util.Scanner;

public class Q11 {

    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        System.out.print("Você tem R$ " + c1.saldo + " depositados na sua conta 1, "
                + "quanto deseja transferir para a conta 2? R$ ");
        Scanner leia = new Scanner(System.in);

        c1.transferir(leia.nextDouble(), c2);

        System.out.println("Saldo atual da conta 1: R$ " + c1.saldo);
        System.out.println("Saldo atual da conta 2: R$ " + c2.saldo);
    }

}

class Conta {

    double saldo = 100.00;

    public void transferir(double valor, Conta destino) {
        if (valor <= saldo) {

            this.saldo -= valor;
            destino.receber(valor);
            System.out.println("Trasferência realizada com sucesso!");

        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void receber(double valor) {
        this.saldo += valor;
    }

}
