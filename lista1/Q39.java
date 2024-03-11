package lista1;

import java.util.ArrayList;
import java.util.List;

class Pessoa {

    private final String nome;
    private final int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{"
                + "nome='" + nome + "', "
                + "idade=" + idade 
                + "}";
    }
    
}

class Crud<T> {

    private final List<T> lista;

    public Crud() {
        this.lista = new ArrayList<>();
    }

    public void create(T item) {
        if (item != null) {
            lista.add(item);
        } else {
            System.err.println("Elemento nulo");
        }
    }

    public T read(int idx) {
        if (idx >= 0 && idx < lista.size()) {
            return lista.get(idx);
        }
        System.err.println("Índice " + idx + " inválido");
        return null;
    }

    public void update(int idx, T newItem) {
        if (idx >= 0 && idx < lista.size()) {
            lista.set(idx, newItem);
        } else {
            System.err.println("Índice " + idx + " inválido");
        }
    }

    public T delete(int idx) {
        if (idx >= 0 && idx < lista.size()) {
            return lista.remove(idx);
        }
        System.err.println("Índice " + idx + " inválido");
        return null;
    }
    
    public List<T> readAll() {
        return lista;
    }
    
}

public class Q39 {

    public static void main(String[] args) {
        // Exemplo de uso para a classe String
        Crud<String> crudString = new Crud<>();
        crudString.create("String 1");
        crudString.create("String 2");

        System.out.println("Lista de strings:");
        System.out.println(crudString.read(0));
        System.out.println(crudString.read(1));

        System.out.println("\nAtualizando a string 1...");
        crudString.update(0, "String 1 atualizada");
        System.out.println(crudString.read(0));

        System.out.println("\nDeletando a string 2...");
        crudString.delete(1);
        System.out.println("Lista de strings:");
        System.out.println(crudString.read(0));

        // Exemplo de uso para a classe Pessoa
        Crud<Pessoa> pessoaCrud = new Crud<>();
        pessoaCrud.create(new Pessoa("Carlinhos", 22));
        pessoaCrud.create(new Pessoa("João", 30));

        System.out.println("\nLista de pessoas:");
        System.out.println(pessoaCrud.read(0));
        System.out.println(pessoaCrud.read(1));
    }
    
}
