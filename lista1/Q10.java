package lista1;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite um n�mero inteiro: ");
		int n = leia.nextInt();
        
		if ((n & 1) == 0) {
			System.out.println(n + " � par");
		} else {
			System.out.println(n + " � �mpar");
		}
	}

}
