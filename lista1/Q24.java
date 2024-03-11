package lista1;

import java.util.Scanner;

public class Q24 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        String menu = "[1] Potenciação\n[2] Raiz Quadrada\n[3] Fatorial\n[0] Sair\nEscolha uma opção: ";
        System.out.print(menu);
        
        int opcao;
        while ((opcao = leia.nextInt()) != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o número: ");
                    double n = leia.nextDouble();
                    System.out.print("Digite a potência: ");
                    double pot = leia.nextDouble();
                    System.out.println(n + " ^ " + pot + " = " + Math.pow(n, pot));
                    break;
                case 2:
                    System.out.print("Digite o número: ");
                    double m = leia.nextDouble();
                    System.out.println("?" + m + " = " + Math.sqrt(m));
                    break;
                case 3:
                    System.out.print("Digite o valor para calcular o fatorial: ");
                    int num = leia.nextInt();
                    System.out.println(num + "! = " + fatorial(num));
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.print("\n" + menu);
        }
    }

    public static int fatorial(int n) {
        if (n > 1) {
            return n * fatorial(n - 1);
        }
        return 1;
    }
}
