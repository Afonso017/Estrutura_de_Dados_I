package lista1;

import java.util.Scanner;

public class Q05 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		System.out.println("Digite três números reais:");
		double n1 = leia.nextDouble();
		double n2 = leia.nextDouble();
		double n3 = leia.nextDouble();

		double media = (n1 + n2 + n3) / 3;
		System.out.printf("A média dos números é igual a %.2f\n", media);
	}

}
