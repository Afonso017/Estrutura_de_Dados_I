package aulas;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {

    public static void main(String[] args) {
        System.out.println("LinkedList");
        Queue<String> list = new LinkedList<>();
        
        list.add("zzz");
        list.add("aaa");
        list.add("ttt");
        list.add("ttt");
        list.add("bbb");
        list.add(null);
        list.add("ccc");
        
        System.out.println(list);
        System.out.println(list.size());
    }
    
}
