package lista1;

import java.util.Scanner;

public class Q36 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int num = leia.nextInt();
        
        System.out.println(num + "! = " + fatorial(num));
    }
    
    public static int fatorial(int n) {
        if (n > 1) {
            return n * fatorial(n - 1);
        }
        return 1;
    }
    
}
