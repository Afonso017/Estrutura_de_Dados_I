package lista1;

import java.util.Scanner;

public class Q03 {
    
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
	
	System.out.print("Digite um número: ");
	int x = leia.nextInt();
	
	System.out.print("Digite mais um número: ");
	int y = leia.nextInt();
	
	System.out.println("Soma = " + (x + y));
	System.out.println("Subtração = " + (x - y));
	System.out.println("Multiplicação = " + (x * y));
	System.out.printf("Divisão = %.2f\n", ((double)x / y));
	System.out.println("Resto da divisão = " + (x % y));
    }
    
}
