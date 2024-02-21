package aulas;

public class Referencia {

    static class Teste {
        public int x = 10;
    }
    
    public static void main(String[] args) {
        System.out.println("Referencia:");
        Teste obj = new Teste();
        
        // Mostra a referencia do objeto original
        System.out.println(obj);
        teste(obj); // Mostra a referencia do mesmo objeto, ou seja, nao faz a copia de objeto
        
        // Mostra o valor do atributo final
        System.out.println("Valor:");
        alterarValor(obj); // Altera o valor do atributo do objeto original, nao faz copia de objeto
        System.out.println(obj.x);
    }
    
    private static void teste(Teste t) {
        System.out.println(t);
    }
    
    private static void alterarValor(Teste t) {
        t.x = 50;
    }
    
}
