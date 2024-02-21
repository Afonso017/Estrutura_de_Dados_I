package problema;

import aulas.PilhaArray;
import java.util.Scanner;

public class Problema {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite a entrada: ");
        String entrada = leia.nextLine();
        
        if (isValid(entrada)) {
            System.out.println("A entrada é válida");
        } else {
            System.out.println("A entrada é inválida");
        }
    }
    
    public static boolean isValid(String s) {
        var stack = new PilhaArray<Character>(s.length());
        for (var c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    
}
