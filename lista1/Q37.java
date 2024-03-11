package lista1;

import java.util.Scanner;

public class Q37 {
    
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite um intervalo: ");
        int a = leia.nextInt();
        int b = leia.nextInt();
        
        int soma = 0;
        for (int i = a; i <= b; i++) {
            soma += i;
        }
        System.out.println("Soma iterativa: " + soma);
        
        System.out.println("Soma recursiva: " + somatorio(a, b));
    }
    
    public static int somatorio(int a, int b) {
        if (a < b) {
            return a + somatorio(a+1, b);
        }
        return a;
    }
    
}
