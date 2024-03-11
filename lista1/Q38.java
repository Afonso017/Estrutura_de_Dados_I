package lista1;

import java.util.Scanner;

public class Q38 {
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		System.out.print("Digite uma frase: ");
		String objeto = leia.nextLine();
		
		exibirObjeto(objeto);
		
		exibirVetor(new Integer[]{1, 2, 3, 4, 5});
	}
	
	public static <T> void exibirObjeto(T objeto) {
		System.out.println(objeto.toString());
	}
	
	public static <V> void exibirVetor(V[] vetor) {
		for (V elemento : vetor) {
			System.out.print(elemento + " ");
		}
		System.out.println("");
	}
	
}
