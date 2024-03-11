package lista1;

import java.util.Scanner;

public class Q21 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Esse � um algoritmo bem eficiente para identificar se um n�mero � primo
        
        System.out.print("Digite um n�mero inteiro: ");
        int n = leia.nextInt();
        boolean primo = true;

        // Verifica se o n�mero � diferente de 2 e par, caso seja, n�o � primo
        if (n != 2 && n % 2 == 0) {
            primo = false;
        } else {
            // Calcula a ra�z e usa o resultado para o for, verificando apenas divisores �mpares
            double raiz = Math.sqrt(n);
            for (int i = 3; i <= raiz; i += 2) {
                if (n % i == 0) {
                    primo = false; // Caso encontre algum divisor, n�o � primo e sai do loop
                    break;
                }
            }
        }

        // Um n�mero � primo caso seja diferente de 0 e 1 e atenda �s condi��es iniciais
        if (primo && n != 0 && n != 1) {
            System.out.println(n + " � primo.");
        } else {
            System.out.println(n + " n�o � primo.");
        }
    }

}
