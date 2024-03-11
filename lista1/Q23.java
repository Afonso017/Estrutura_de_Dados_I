package lista1;

import java.util.Scanner;

public class Q23 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int n = leia.nextInt();
        
        System.out.println(n + "! = " + fatorial(n));
    }

    public static int fatorial(int n) {
        if (n > 1) {
            return n * fatorial(n - 1);
        }
        return 1;
    }
}
