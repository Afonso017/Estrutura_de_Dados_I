package lista1;

import java.util.Scanner;

public class Q22 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite o número inicial do intervalo: ");
        int inicio = leia.nextInt();

        System.out.print("Digite o número final do intervalo: ");
        int fim = leia.nextInt();

        int soma = 0;
        for (int i = inicio; i <= fim; i++) {
            soma += i;
        }

        System.out.println("A soma de todos os inteiros entre " + inicio + " e " + fim + " é igual a " + soma);
    }

}
