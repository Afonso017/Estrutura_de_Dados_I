package lista1;

import java.util.Scanner;

public class Q09 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite o valor do raio do c�rculo: ");
		double raio = leia.nextDouble();
		
		// Se o valor do raio for positivo, calcula a �rea do c�rculo
		if (raio > 0) {
			double area = Math.PI * raio * raio;
			System.out.println("A �rea do c�rculo � igual a " + area);
		} else {
			System.out.println("O valor do raio deve ser maior que 0.");
		}
	}

}
