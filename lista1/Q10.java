package lista1;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite um número inteiro: ");
		int n = leia.nextInt();
        
		if ((n & 1) == 0) {
			System.out.println(n + " é par");
		} else {
			System.out.println(n + " é ímpar");
		}
	}

}
