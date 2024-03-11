package lista1;

import java.util.*;

public class Q41 {
	
    public static void main(String[] args) {
        //  a) List
		//  1. ArrayList
		// Implementa��o de uma lista baseada em array. Boa para acesso r�pido aos elementos pela posi��o, mas menos eficiente em opera��es de inser��o/remo��o no meio da lista, pois ele reordena todos os elementos.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
		
        // 2. Vector
		// Similar ao ArrayList, mas � sincronizado, o que implica em um desempenho um pouco mais lento.
        List<String> vector = new Vector<>();
        vector.add("Item 1");
        vector.add("Item 2");
		
        // 3. LinkedList
		// Implementa��o de lista duplamente encadeada. Eficiente para inser��es/remo��es no meio, mas menos eficiente em acesso direto aos elementos.
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Item 1");
        linkedList.add("Item 2");
		
        // b) Set
        // 1. HashSet
		// Implementa��o de conjunto sem ordem, usando uma tabela hash. N�o permite elementos duplicados.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Elemento 1");
        hashSet.add("Elemento 2");
		
        // 2. LinkedHashSet
		// O mesmo que HashSet, mas mantendo a ordem de inser��o dos elementos.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Elemento 1");
        linkedHashSet.add("Elemento 2");
		
        // 3. TreeSet
		// Implementa��o baseada em �rvore, mantendo os elementos ordenados.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Elemento 1");
        treeSet.add("Elemento 2");
		
        // c) Queue
        // 1. PriorityQueue
		// Implementa��o de fila de prioridade, onde os elementos s�o recuperados pela prioridade.
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Elemento 1");
        priorityQueue.add("Elemento 2");
		
        // 2. LinkedList (como Queue)
		// LinkedList pode ser usada como uma fila.
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.add("Elemento 1");
        linkedListQueue.add("Elemento 2");
		
        // d) Deque
        // 1. LinkedList (como Deque)
		// LinkedList pode ser usada como uma deque (double-ended queue).
        Deque<String> linkedListDeque = new LinkedList<>();
        linkedListDeque.addFirst("Elemento 1");
        linkedListDeque.addLast("Elemento 2");
		
        // e) Map
        // 1. HashMap
		// Implementa��o de mapa baseada em tabela hash. N�o garante ordem dos elementos.
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Valor 1");
        hashMap.put(2, "Valor 2");
		
        // 2. LinkedHashMap
		// Mesmo que HashMap, mas mantendo a ordem de inser��o dos elementos.
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Valor 1");
        linkedHashMap.put(2, "Valor 2");
		
        // 3. TreeMap
		// Implementa��o baseada em �rvore, mantendo os elementos ordenados pelo comparador.
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Valor 1");
        treeMap.put(2, "Valor 2");
	}

}
