package lista1;

import java.util.Scanner;

public class Q07 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
        
		System.out.print("Digite um número real: ");
		double x = leia.nextDouble();
        
		System.out.print("Digite mais um número real: ");
		double y = leia.nextDouble();
        
		// Faz a divisão caso o segundo número seja diferente de zero
		if (y != 0) {
			System.out.println(x + " / " + y + " = " + (x / y));
		} else {
			System.err.println("Não é possível dividir por 0.");
		}
	}
    
}
