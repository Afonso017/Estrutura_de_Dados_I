package lista1;

import java.util.Scanner;

public class Q03 {
    
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
	
	System.out.print("Digite um n�mero: ");
	int x = leia.nextInt();
	
	System.out.print("Digite mais um n�mero: ");
	int y = leia.nextInt();
	
	System.out.println("Soma = " + (x + y));
	System.out.println("Subtra��o = " + (x - y));
	System.out.println("Multiplica��o = " + (x * y));
	System.out.printf("Divis�o = %.2f\n", ((double)x / y));
	System.out.println("Resto da divis�o = " + (x % y));
    }
    
}
