package lista1;

import java.util.Scanner;

public class Q12 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite a média parcial: ");
        double media = leia.nextDouble();

        // Verifica a situação do aluno caso a média informada esteja entre 0 e 10
        if (media >= 0 && media <= 10) {

            if (media < 3.5) {
                System.out.println("Reprovado");
            } else if (media < 7) {
                System.out.println("Avaliação Final");
            } else {
                System.out.println("Aprovado");
            }

        } else {
            System.out.println("Média inválida");
        }
    }

}
