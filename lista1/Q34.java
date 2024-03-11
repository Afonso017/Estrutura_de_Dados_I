package lista1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Q34 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = leia.nextLine();

        // Cria um HashMap para contar quantas strings se repetem em uma frase
        Map<String, Integer> mapa = new LinkedHashMap<>();

        // Divide a frase em palavras usando o espaço como delimitador e itera sobre cada palavra
        for (String s : frase.split(" ")) {

            // Verifica se a palavra já está presente no mapa.
            if (!mapa.containsKey(s)) {
                // Se a palavra não existir, adiciona ela com o valor inicial igual a 1
                mapa.put(s, 1);
            } else {
                // Se a palavra já existir, incrementa a contagem
                mapa.replace(s, mapa.get(s) + 1);
            }
        }

        // Faz um foreach percorrendo cada combinação de chave e valor do mapa e imprime os dados
        System.out.println("Resultado:");
        mapa.entrySet().forEach(System.out::println);
        System.out.println("");

    }

}
