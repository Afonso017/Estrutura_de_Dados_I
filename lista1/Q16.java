package lista1;

import java.util.Scanner;

public class Q16 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Entrada dos dados
        System.out.print("Digite um número inicial: ");
        int inicio = leia.nextInt();
        System.out.print("Digite um número final: ");
        int fim = leia.nextInt();

        // Loop While
        int i = inicio;
        while (i <= fim) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println("");

        // Loop Do-While
        int j = inicio;
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= fim);
        System.out.println("");

        // Loop For
        for (int k = inicio; k <= fim; k++) {
            System.out.print(k + " ");
        }
        System.out.println("");
    }

}
