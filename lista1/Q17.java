package lista1;

import java.util.Scanner;

public class Q17 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite o número inicial de um intervalo: ");
        int inicio = leia.nextInt();
        System.out.print("Digite o número final do intervalo: ");
        int fim = leia.nextInt();

        // Loop While
        int i = inicio;
        while (i <= fim) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();

        // Loop Do-While
        int j = inicio;
        do {
            if (j % 2 == 1) {
                System.out.print(j + " ");
            }
            j++;
        } while (j <= fim);
        System.out.println();

        // Loop For
        for (int k = inicio; k <= fim; k++) {
            if (k % 2 == 1) {
                System.out.print(k + " ");
            }
        }
        System.out.println();
    }
}
