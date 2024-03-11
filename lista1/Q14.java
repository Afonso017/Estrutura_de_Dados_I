package lista1;

import java.util.Scanner;

public class Q14 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite os coeficientes da equação de segundo grau (a, b e c): ");
        double a = leia.nextInt();
        double b = leia.nextInt();
        double c = leia.nextInt();

        // Calcula o delta caso o coeficiente 'a' seja diferente de zero
        if (a != 0) {
            // Exibe a equação formatada de acordo com os parâmetros passados
            exibirEquacaoSegundoGrau(a, b, c);

            // Verifica se o valor do delta é positivo, negativo ou zero
            double delta = calcularDelta(a, b, c);
            
            if (delta < 0) {
                
                System.out.println("Não existe solução real para delta negativo.");
                
            } else if (delta > 0) {
                
                double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + raiz1);
                System.out.println("x2 = " + raiz2);
                
            } else {
                
                double raiz = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = x2 = " + raiz);
                
            }
        } else {
            
            System.out.println("Em uma equação do segundo grau, o coeficiente 'a' deve ser diferente de zero!");
            
        }
    }

    public static double calcularDelta(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static void exibirEquacaoSegundoGrau(double a, double b, double c) {
        // Coeficiente a
        if (a == 1.0) {
            System.out.print("x² ");
        } else if (a == -1) {
            System.out.print("-x² ");
        } else {
            System.out.print(a + "x² ");
        }

        // Coeficiente b
        if (b != 0) {
            if (b == 1) {
                System.out.print("+ x ");
            } else if (b == -1) {
                System.out.print("- x ");
            } else if (b > 0) {
                System.out.print("+ " + b + "x ");
            } else {
                System.out.print(b + "x ");
            }
        }

        // Coeficiente c
        if (c != 0) {
            if (c > 0) {
                System.out.print("+ " + c);
            } else {
                System.out.print("- " + Math.abs(c));
            }
        }
        System.out.println();
    }

}
