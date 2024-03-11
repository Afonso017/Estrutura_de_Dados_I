package lista1;

import java.util.Scanner;

public class Q06 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		// Definição dos preços
		final double precoRefrigerante = 1.50;
		final double precoPizza = 3.00;
		final double taxa = 0.1;
		
		// Entrada dos dados
		System.out.print("Digite a quantidade de refrigerantes: ");
		int refrigerantes = leia.nextInt();
		System.out.print("Digite a quantidade de fatias de pizza: ");
		int pizzas = leia.nextInt();
		System.out.print("Digite a quantidade de pessoas na mesa: ");
		int pessoas = leia.nextInt();
		
		// Cálculos
		double totalSemTaxa = refrigerantes * precoRefrigerante + pizzas * precoPizza;
		double totalComTaxa = totalSemTaxa + totalSemTaxa * taxa;
		double rateio = totalComTaxa / pessoas;
		
		// Imprime os resultados
		System.out.printf("\nTotal sem taxa: R$ %.2f\n", totalSemTaxa);
		System.out.printf("Total com taxa: R$ %.2f\n", totalComTaxa);
		System.out.printf("Rateio por pessoa: R$ %.2f\n", rateio);
	}
	
}
