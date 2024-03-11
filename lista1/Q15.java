package lista1;

import java.util.Scanner;

public class Q15 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite um número entre 1 e 5: ");
        int num = leia.nextInt();
        
        switch (num) {
            case 1:
                System.out.println("Um");
                break;
            case 2:
                System.out.println("Dois");
                break;
            case 3:
                System.out.println("TrÃªs");
                break;
            case 4:
                System.out.println("Quatro");
                break;
            case 5:
                System.out.println("Cinco");
                break;
            default:
                System.out.println("O número está fora do intervalo.");
        }
    }
}
