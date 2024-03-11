package lista1;

import java.util.Scanner;

public class Q30 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = leia.nextLine();

        char[] s = frase.toCharArray();
        int tam = frase.length();
        char aux;
        for (int i = 0, j = tam - 1; i < j; i++, j--) {
            aux = s[i];
            s[i] = s[j];
            s[j] = aux;
        }
        frase = String.copyValueOf(s);
        System.out.println(frase);
    }

}
