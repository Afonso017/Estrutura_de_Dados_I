package lista1;

import java.util.Scanner;

public class Q08 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite sua altura (em metros): ");
		double altura = leia.nextDouble();
		
		System.out.print("Digite seu peso (em quilos): ");
		double peso = leia.nextDouble();
		
		// Calcula o IMC caso os dados forem válidos
		if (altura > 0 && peso > 0) {
			final double IMC = peso / (altura * altura);
			
			// Verifica em qual intervalo o IMC está
			if (IMC < 16) {
				System.out.println("Magreza Grave");
			} else if (IMC < 17) {
				System.out.println("Magreza Moderada");
			} else if (IMC < 18.5) {
				System.out.println("Magreza Leve");
			} else if (IMC < 25) {
				System.out.println("Saudável");
			} else if (IMC < 30) {
				System.out.println("Sobrepeso");
			} else if (IMC < 35) {
				System.out.println("Obesidade Grau I");
			} else if (IMC < 40) {
				System.out.println("Obesidade Grau II (severa)");
			} else {
				System.out.println("Obesidade Grau III (mórbida)");
			}
		}
		
	}

}
