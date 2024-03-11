package lista1;

import java.util.Scanner;

public class Q28 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int tam = leia.nextInt();

        int[] vetor = new int[tam];
        for (int i = 0; i < tam; i++) {
            System.out.print("Digite o " + (i + 1) + "� elemento: ");
            vetor[i] = leia.nextInt();
        }

        // Define o menor e maior elementos como os primeiros elementos do vetor, para compar�-los com os demais
        int menor = vetor[0], maior = vetor[0];
        for (int i = 0; i < vetor.length; i++) {

            // Verifica se o elemento atual � menor que o �ltimo menor elemento encontrado
            if (vetor[i] < menor) {
                menor = vetor[i];
            }

            // Verifica se o elemento atual � o maior que o �ltimo maior elemento encontrado
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        System.out.println("\nMenor elemento = " + menor);
        System.out.println("Maior elemento = " + maior);
    }

}
