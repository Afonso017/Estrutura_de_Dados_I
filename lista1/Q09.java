package lista1;

import java.util.Scanner;

public class Q09 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite o valor do raio do círculo: ");
		double raio = leia.nextDouble();
		
		// Se o valor do raio for positivo, calcula a área do círculo
		if (raio > 0) {
			double area = Math.PI * raio * raio;
			System.out.println("A área do círculo é igual a " + area);
		} else {
			System.out.println("O valor do raio deve ser maior que 0.");
		}
	}

}
