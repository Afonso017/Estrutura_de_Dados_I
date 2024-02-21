package aulas;

import java.util.ArrayList;
import java.util.Collections;

public class Collection {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        
        // Ordena em ordem crescente
        // Collections.sort(list, (o1, o2) -> {
        //     return o1 - o2;
        // });
        Collections.sort(list, (o1, o2) -> o1 - o2);
        System.out.println(list);
        
        // Ordena em ordem decrescente
        // Collections.sort(list, (o1, o2) -> {
        //     return o2 - o1;
        // });
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);
    }
    
}
