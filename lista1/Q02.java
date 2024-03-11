package lista1;

import java.util.Scanner;

public class Q02 {
    
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = leia.nextLine();
        
        System.out.print("Digite sua idade: ");
        int idade = leia.nextInt();
        
        System.out.print("Digite sua altura: ");
        double altura = leia.nextDouble();
        char primeiraLetra = nome.charAt(0);
        
        System.out.println("Nome: " + nome + "\n"
				+ "Idade: " + idade + "\n"
				+ "Altura: " + altura + " m\n"
				+ "Primeira letra do nome: " + primeiraLetra);
    }
}
