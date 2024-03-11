package lista1;

import java.util.Scanner;

public class Q21 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Esse é um algoritmo bem eficiente para identificar se um número é primo
        
        System.out.print("Digite um número inteiro: ");
        int n = leia.nextInt();
        boolean primo = true;

        // Verifica se o número é diferente de 2 e par, caso seja, não é primo
        if (n != 2 && n % 2 == 0) {
            primo = false;
        } else {
            // Calcula a raíz e usa o resultado para o for, verificando apenas divisores ímpares
            double raiz = Math.sqrt(n);
            for (int i = 3; i <= raiz; i += 2) {
                if (n % i == 0) {
                    primo = false; // Caso encontre algum divisor, não é primo e sai do loop
                    break;
                }
            }
        }

        // Um número é primo caso seja diferente de 0 e 1 e atenda às condições iniciais
        if (primo && n != 0 && n != 1) {
            System.out.println(n + " é primo.");
        } else {
            System.out.println(n + " não é primo.");
        }
    }

}
