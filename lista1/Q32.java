package lista1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q32 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int qtdPessoas = leia.nextInt();

        Pessoa[] pessoas = new Pessoa[qtdPessoas];
        for (int i = 0; i < qtdPessoas; i++) {
            pessoas[i] = new Pessoa();
            System.out.print("Informe os dados da pessoa " + (i + 1) + ":\nnome: ");
            leia.nextLine();
            pessoas[i].nome = leia.nextLine();
            System.out.print("cpf: ");
            pessoas[i].cpf = leia.nextLine();
            System.out.print("idade: ");
            pessoas[i].idade = leia.nextInt();
            System.out.print("sexo: ");
            pessoas[i].sexo = leia.next().charAt(0);
            System.out.print("peso: ");
            pessoas[i].peso = leia.nextDouble();
            System.out.print("altura: ");
            pessoas[i].altura = leia.nextDouble();
        }

        // Chama os métodos para leitura e escrita de um arquivo binário com os dados do array de pessoas
        escreverNoArquivo(pessoas);
        lerArquivo();
    }

    private static void escreverNoArquivo(Pessoa[] pessoas) {
        // Cria um arquivo binário chamado "pessoas" no diretório src
        try (FileOutputStream file = new FileOutputStream("src\\pessoas.bin")) {

            // Escreve cada pessoa do array de pessoas no arquivo binário
            for (Pessoa p : pessoas) {
                file.write(("Nome: " + p.nome + "\n").getBytes()); // Transforma a string em bytes
                file.write(("CPF: " + p.cpf + "\n").getBytes());
                file.write(("Idade: " + String.valueOf(p.idade) + "\n").getBytes());
                file.write(("Sexo: " + String.valueOf(p.sexo) + "\n").getBytes());
                file.write(("Peso: " + String.valueOf(p.peso) + "kg\n").getBytes());
                file.write(("Altura: " + String.valueOf(p.altura) + "m\n").getBytes());
                file.write(("IMC: " + String.format("%.2f", p.calcularIMC()) + "\n\n").getBytes());
            }
        } catch (IOException e) {
            System.out.println("Não foi possível escrever no arquivo.\n" + e.getMessage());
        }
    }

    private static void lerArquivo() {
        // Abre, se existir, um arquivo binário chamado "pessoas" para realizar a leitura dos dados
        try (FileInputStream file = new FileInputStream("src\\pessoas.bin")) {

            // Instancia um array de bytes com tamanho suficiente para guardar cada byte lido do arquivo
            byte[] dados = new byte[file.available()];

            // Realiza a leitura dos bytes
            int bytesRead = file.read(dados);

            // Se houver ao menos um byte no arquivo, converte os bytes em String e imprime no console
            if (bytesRead > 0) {
                String conteudo = new String(dados, "ISO-8859-1"); // Faz a leitura com a codificação especificada
                System.out.print(conteudo);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo.\n" + e.getMessage());
        }
    }

}
