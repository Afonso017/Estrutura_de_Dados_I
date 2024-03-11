package lista1;

import java.util.Arrays;
import java.util.Scanner;

public class Q29 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int tam = leia.nextInt();

        int[] vetor = new int[tam];
        for (int i = 0; i < tam; i++) {
            System.out.print("Digite o " + (i + 1) + "º elemento: ");
            vetor[i] = leia.nextInt();
        }

        System.out.println(Arrays.toString(vetor));
        for (int i = tam - 1, aux; i > 0; i--) {
            aux = vetor[i]; // Variável auxiliar armazena o valor atual
            // Troca os valores
            vetor[i] = vetor[i - 1];
            vetor[i - 1] = aux;

            System.out.println(Arrays.toString(vetor));
        }
    }

}
