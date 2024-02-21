package main;

import aulas.PilhaArray;

public class Main {

    public static void main(String[] args) {
        PilhaArray<Integer> pilha = new PilhaArray<>(5);
        
        System.out.println("is empty? " + pilha.isEmpty());
        
        System.out.println("push 10");
        pilha.push(10);
        System.out.println("push 11");
        pilha.push(11);
        
        System.out.println(pilha);
        
        System.out.println("peek " + pilha.peek());
        
        System.out.println("pop " + pilha.pop());
        
        System.out.println(pilha);
        
        pilha.push(15);
        pilha.push(15);
        pilha.push(15);
        pilha.push(15);
        
        System.out.println(pilha);
        
        System.out.println("is empty? " + pilha.isEmpty());
        System.out.println("is full? " + pilha.isFull());
    }
    
}
