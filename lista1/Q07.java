package lista1;

import java.util.Scanner;

public class Q07 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
        
		System.out.print("Digite um n�mero real: ");
		double x = leia.nextDouble();
        
		System.out.print("Digite mais um n�mero real: ");
		double y = leia.nextDouble();
        
		// Faz a divis�o caso o segundo n�mero seja diferente de zero
		if (y != 0) {
			System.out.println(x + " / " + y + " = " + (x / y));
		} else {
			System.err.println("N�o � poss�vel dividir por 0.");
		}
	}
    
}
