package lista1;

import java.util.Scanner;

public class Q19 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite um n�mero inteiro: ");
        int n = leia.nextInt();

        System.out.println("\nTabuada do n�mero " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + n + " = " + (i * n));
        }
    }

}
