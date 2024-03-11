package lista1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Q33 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = leia.nextLine();

        // Cria um mapa linkado para contar quantos caracteres se repetem em uma palavra
        Map<Character, Integer> mapa = new LinkedHashMap<>();

        // Percorre o array de caracteres da palavra
        for (char c : palavra.toCharArray()) {

            // Se o caractere não existir no mapa, adiciona ele com o valor inicial igual a 1
            if (!mapa.containsKey(c)) {
                mapa.put(c, 1);
            } else {
                // Caso contrário, incrementa o valor do caractere existente em 1
                int valor = mapa.get(c) + 1;
                mapa.replace(c, valor);
            }
        }

        // Percorre o conjunto de chaves do mapa, imprime cada chave e seu respectivo valor
        mapa.keySet().forEach((c) -> {
            System.out.println(c + ": " + mapa.get(c));
        });
    }

}
