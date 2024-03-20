package estruturas.list;

import interfaces.MyInterfaceLinkedList;

public class TesteListIterator {

    public static void main(String[] args) {
        javaIterator();
        System.out.println("");
        meuIterator();
    }
    
    public static void javaIterator() {
        java.util.List<Integer> lista = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4));
        java.util.ListIterator<Integer> it = lista.listIterator();
        while (it.hasNext()) {
            it.add(5);
            System.out.print(it.next() + " ");
        }
        System.out.println("");
        
        System.out.println(lista);
    }
    
    public static void meuIterator() {
        MyInterfaceLinkedList<Integer> lista = new MyLinkedList<>();
        lista.addAll(java.util.Arrays.asList(1, 2, 3, 4));
        
        java.util.ListIterator<Integer> it = lista.listIterator();
        while (it.hasNext()) {
            it.add(5);
            System.out.print(it.next() + " ");
        }
        System.out.println("");
        
        System.out.println(lista);
    }
    
}
