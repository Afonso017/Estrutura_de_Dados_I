package lista1;

import java.util.Scanner;

public class Q15 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite um n�mero entre 1 e 5: ");
        int num = leia.nextInt();
        
        switch (num) {
            case 1:
                System.out.println("Um");
                break;
            case 2:
                System.out.println("Dois");
                break;
            case 3:
                System.out.println("Três");
                break;
            case 4:
                System.out.println("Quatro");
                break;
            case 5:
                System.out.println("Cinco");
                break;
            default:
                System.out.println("O n�mero est� fora do intervalo.");
        }
    }
}
