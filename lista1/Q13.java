package lista1;

import java.util.Scanner;

public class Q13 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Faz a leitura das 3 notas
        System.out.print("Digite a nota da Unidade 1: ");
        double n1 = leia.nextDouble();
        System.out.print("Digite a nota da Unidade 2: ");
        double n2 = leia.nextDouble();
        System.out.print("Digite a nota da Unidade 3: ");
        double n3 = leia.nextDouble();

        // Calcula a m�dia parcial
        double mediaParcial = (n1 + n2 + n3) / 3;

        // Verifica a situa��o do aluno com base na m�dia calculada
        if (mediaParcial < 3.5) {
            
            System.out.printf("Reprovado, m�dia igual a %.2f\n", mediaParcial);
            
        } else if (mediaParcial < 7) {
            
            System.out.println("Avalia��o Final");

            // Calcula quanto o aluno precisa tirar na 4a prova para ser aprovado
            double notaFinal = (25 - 3 * mediaParcial) / 2;
            System.out.printf("Voc� precisa de %.2f para passar na 4� prova.\n", notaFinal);
            
        } else {
            
            System.out.printf("Aprovado com m�dia %.2f\n", mediaParcial);
            
        }

    }

}
