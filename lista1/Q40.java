package lista1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q40 {
	
	public static void main(String[] args) {
		
		/* Essa classe serve tanto para codificar quanto para decodificar um arquivo de texto, ja que
		 o padrao de codificacao/decodificacao eh o mesmo */
		
		// Cria uma pasta na mesma pasta do arquivo .java para os arquivos que serao criados
		String pasta = "arquivos/";
		File dir = new File(pasta);
		dir.mkdirs();
		
		// Gera um arquivo de texto e escreve algo nele
		String arquivo = "/arquivo.txt";
		String texto = "arquivo de teste para codificar";
		writeOnFile(pasta + arquivo, texto);
		
		// Le do arquivo e codifica o texto lido
		String textoLido = readFromFile(pasta + arquivo);
		String textoCodificado = codificarDecodificar(textoLido);
		System.out.println("Texto codificado: " + textoCodificado);
		
		// Escreve o texto codificado em outro arquivo e decodifica o texto
		writeOnFile(pasta + "arquivoCodificado.txt", textoCodificado);
		String textoDecodificado = codificarDecodificar(textoCodificado);
		System.out.println("Texto decodificado: " + textoDecodificado);
		
		// Escreve o texto decodificado em um outro arquivo
		writeOnFile(pasta + "arquivoDecodificado.txt", textoDecodificado);
	}
	
	public static void writeOnFile(String path, String text) {
        try (var bw = new BufferedWriter(new FileWriter(path))) {
			bw.append(text);
		} catch (IOException ex) {
			System.err.println("Erro na escrita do arquivo: " + ex);
		}
	}
	
	public static String readFromFile(String path) {
		String texto = "";
		try (var br = new BufferedReader(new FileReader(path))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				texto += linha;
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Erro: Não foi possível encontrar o arquivo " + ex);
		} catch (IOException ex) {
			System.err.println("Erro na leitura do arquivo: " + ex);
		}
		return texto;
	}
	
	public static String codificarDecodificar(String frase) {
		String code = "";
		for (char c : frase.toCharArray()) {
			switch (c) {
				case 'z':
					code += "p";
					break;
				case 'e':
					code += "o";
					break;
				case 'n':
					code += "l";
					break;
				case 'i':
					code += "a";
					break;
				case 't':
					code += "r";
					break;
				case 'p':
					code += "z";
					break;
				case 'o':
					code += "e";
					break;
				case 'l':
					code += "n";
					break;
				case 'a':
					code += "i";
					break;
				case 'r':
					code += "t";
					break;
				default:
					code += c;
			}
		}
		
		return code;
	}
	
}
