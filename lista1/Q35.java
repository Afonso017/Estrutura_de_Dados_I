package lista1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q35 {

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

        try {
            FileOutputStream file = new FileOutputStream("src\\arquivo.csv");
            mapa.entrySet().forEach(e -> {
                try {
                    file.write(e.toString().getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(Q35.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q35.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
