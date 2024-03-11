package lista1;

import java.util.Scanner;

public class Q31 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int qtdPessoas = leia.nextInt();

        // Cria um array de pessoas, com o tamanho especificado pelo usuário
        Pessoa[] pessoas = new Pessoa[qtdPessoas];

        // Loop para percorrer e preencher o array com as informações passadas
        for (int i = 0; i < qtdPessoas; i++) {

            // Instancia uma nova pessoa e atribui a uma posição do array
            pessoas[i] = new Pessoa();
            System.out.print("Informe os dados da pessoa " + (i + 1) + ":\nnome: ");

            // Limpa o buffer para a leitura dos dados
            leia.next();

            pessoas[i].nome = leia.nextLine();
            System.out.print("cpf: ");
            pessoas[i].cpf = leia.nextLine();
            System.out.print("idade: ");
            pessoas[i].idade = leia.nextInt();
            System.out.print("sexo: ");
            pessoas[i].sexo = leia.next().charAt(0);
            System.out.print("peso: ");
            pessoas[i].peso = leia.nextDouble();
            System.out.print("altura: ");
            pessoas[i].altura = leia.nextDouble();
        }

        // Percorre novamente o array de pessoas para imprimir os dados lidos
        for (int i = 0; i < qtdPessoas; i++) {
            System.out.println("Pessoa " + (i + 1) + ":");
            System.out.println("Nome: " + pessoas[i].nome);
            System.out.println("CPF: " + pessoas[i].cpf);
            System.out.println("Idade: " + pessoas[i].idade);
            System.out.println("Sexo: " + pessoas[i].sexo);
            System.out.println("Peso: " + pessoas[i].peso);
            System.out.println("Altura: " + pessoas[i].altura);
            System.out.println("IMC: " + pessoas[i].calcularIMC());
        }

        leia.close();
    }

}

class Pessoa {
    String nome, cpf;
    int idade;
    char sexo;
    double peso, altura;

    public double calcularIMC() {
        return peso / (altura * altura);
    }
}
