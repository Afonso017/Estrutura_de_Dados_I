package lista1;

import java.util.Scanner;

public class Q25 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int tam = leia.nextInt();

        int[] vetor = new int[tam];
        for (int i = 0; i < tam; i++) {
            System.out.print("Digite o " + (i + 1) + "º elemento: ");
            vetor[i] = leia.nextInt();
        }

        System.out.println("Elementos do vetor:");
        for (int i : vetor) {
            System.out.print(i + " ");
        }
        System.out.println("");

    }

}
