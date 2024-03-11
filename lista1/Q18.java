package lista1;

import java.util.Scanner;

public class Q18 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        String senha;
        
        while (!(senha = leia.nextLine()).equals("teste123")) {
            System.out.print("Senha incorreta! Digite a senha novamente: ");
        }
    }
}
