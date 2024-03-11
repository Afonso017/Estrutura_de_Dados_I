package estruturas.list;

public class Main {
    
    private static class Carro {
        
        String marca;
        String cor;
        
        public Carro(String marca, String cor) {
            this.marca = marca;
            this.cor = cor;
        }
        
        @Override
        public String toString() {
            return "{ Marca:" + marca + ";Cor:" + cor + " }";
        }
        
    }
    
    public static void main(String[] args) {
        MyInterfaceLinkedList<Carro> carros = new MyLinkedList(new Carro("Volkswagen", "Preto"));
        
        System.out.println(new Carro("Fusca", "Azul"));
        
        Carro fiatVerm = new Carro("Fiat", "Vermelho");
		carros.addLast(fiatVerm);
		
        carros.addFirst(new Carro("Camaro", "Amarelo"));
		
        carros.show();
    }
    
}
