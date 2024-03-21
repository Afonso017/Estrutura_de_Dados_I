package estruturas.list;

import java.util.ListIterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.MyInterfaceLinkedList;

public class AplicacoesLinkedList {

    public static class Carro implements Comparable<Carro>, Serializable {

        private String placa;
        private String nome;
        private double preco;

        public Carro(String placa) {
            this.placa = placa;
        }

        public Carro(String placa, String marca, double preco) {
            this.placa = placa;
            this.nome = marca;
            this.preco = preco;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        @Override
        public String toString() {
            return "{Placa:\"" + getPlaca() + "\";Marca:\"" + getNome() + "\";Preço:\"R$ " + String.format("%.2f", getPreco()) + "\"}";
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this == o || Objects.equals(this.getPlaca(), ((Carro) o).getPlaca());
        }

        @Override
        public int hashCode() {
            return 203 + Objects.hashCode(this.getPlaca());
        }

        @Override
        public int compareTo(Carro o) {
            return Double.compare(preco, o.preco);
        }
    }
    
    public static class Token implements Serializable {
        public final String palavra;
        private int quantidade;

        public Token(String palavra) {
            this.palavra = palavra;
            this.quantidade = 1;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void incrementarQuantidade() {
            quantidade++;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Token token = (Token) o;
            return Objects.equals(this.palavra, token.palavra);
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 79 * hash + Objects.hashCode(this.palavra);
            return hash;
        }
    }

    public static void main(String[] args) {
        // Testando métodos de lista encadeada simples
        var carros = new MySinglyLinkedList<Carro>();
        aplicarMetodos(carros);
        
        // Contar palavras de um arquivo de texto com lista encadeada simples
        String texto = lerArquivoTexto("src/arquivos/contarPalavras.txt");
        
        List<Token> palavras = contarPalavras(texto);
        
        System.out.println("\nContagem de palavras:");
        palavras.forEach(tk -> {
            System.out.println(tk.palavra + ": " + tk.getQuantidade());
        });
        
        // Salvando em arquivo binário
        String arquivoBin = "src/arquivos/palavrasContadas.bin";
        String arquivoTxt = "src/arquivos/palavrasContadas.txt";
        escreverArquivoBin(palavras, arquivoBin);
        
        // Lendo o arquivo binário
        List<Token> listaBin = lerArquivoBin(arquivoBin);
        
        StringBuilder txt = new StringBuilder();
        System.out.println();
        listaBin.forEach(tk -> {
            txt.append(tk.palavra).append(": ").append(tk.getQuantidade()).append("\n");
            System.out.println(tk.palavra + ": " + tk.getQuantidade());
        });
        
        // Salvando em arquivo de texto
        excreverArquivoTexto(txt.toString(), arquivoTxt);
    }

    public static void aplicarMetodos(List<Carro> lista) {
        // Testando o addAll
        Collection<Carro> colecao = new HashSet<>();
        colecao.add(new Carro("GTA6X2", "Mustang GT 500", 1490000));
        colecao.add(new Carro("SPTUNL", "Ferrari 488 Pista", 8250000));
        colecao.add(new Carro("BLCKDV", "Lamborghini Aventador SVJ", 11550000));
        colecao.add(new Carro("ELEC21", "Tesla Model S Plaid", 770000));
        colecao.add(new Carro("LSQ7SU", "Mercedes-AMG Project One", 14850000));
        colecao.add(new Carro("HYP3RS", "Bugatti Chiron Super Sport 300+", 21450000));

        MyInterfaceLinkedList carros = (MyInterfaceLinkedList) lista;

        carros.addAll(colecao);
        carros.show();
        System.out.println();

        Carro meuCarro = new Carro("AKS2K03", "Fusquinha dourado rebaixado", 49000);
        carros.addFirst(meuCarro);
        carros.show();
        System.out.println();

        // Testando iterator
        System.out.println("Iterator:");
        Iterator<Carro> it = carros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            if (it.hasNext()) {
                System.out.print(" -> ");
            }
        }

        // Testando ListIterator
        System.out.println("\nList Iterator:");
        ListIterator<Carro> listIt = carros.listIterator();
        while (listIt.hasNext()) {
            Carro atual = listIt.next();

            if (atual.equals(meuCarro)) {
                System.out.println("Removendo meu carro do lista iterator...");
                listIt.remove();
            } else {
                System.out.println(atual);
                if (listIt.hasNext()) {
                    System.out.print(" -> ");
                }
            }
        }
        listIt.add(new Carro("COL8BA", "Toyota Corolla Cross", 110000));

        System.out.println("\nExibindo como array");
        for (Object carro : carros.toArray()) {
            System.out.println((Carro) carro);
        }
    }

    public static String lerArquivoTexto(String arquivo) {
        String texto = "";
        try (var br = new BufferedReader(new FileReader(arquivo))) {
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

    public static void excreverArquivoTexto(String texto, String arquivo) {
        try (var bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.append(texto);
        } catch (IOException ex) {
            System.err.println("Erro na escrita do arquivo: " + ex);
        }
    }

    public static <E> List<E> lerArquivoBin(String arquivo) {
        List<E> objetos = new MySinglyLinkedList<>();

        try (var ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            while (true) {
                try {
                    E objeto = (E) ois.readObject();
                    objetos.add(objeto);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro na leitura do arquivo binário: " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe não encontrada ao ler o arquivo binário: " + ex);
        }

        return objetos;
    }

    public static <E> void escreverArquivoBin(List<E> lista, String arquivo) {
        try (var oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            for (E objeto : lista) {
                oos.writeObject(objeto);
            }
            System.out.println("Lista de carros foi escrita no arquivo binário com sucesso.");
        } catch (IOException ex) {
            Logger.getLogger(AplicacoesLinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Token> contarPalavras(String texto) {
        var contagemPalavras = new MySinglyLinkedList<Token>();

        String txt = texto.replaceAll("[.,();]", "").toLowerCase();
        for (String palavra : txt.split(" ")) {
            if (palavra.isEmpty()) continue;
            Token token = new Token(palavra);

            if (contagemPalavras.contains(token)) {
                contagemPalavras.search(token).incrementarQuantidade();
            } else {
                contagemPalavras.addLast(token);
            }
        }

        return contagemPalavras;
    }

}
