package lista1;

import java.util.Scanner;

public class Q04 {
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite tr�s n�meros inteiros");
		int n1 = leia.nextInt();
		int n2 = leia.nextInt();
		int n3 = leia.nextInt();
		
		int media = (n1 + n2 + n3) / 3;
		System.out.println("A m�dia dos n�meros � igual a " + media);
	}

}
