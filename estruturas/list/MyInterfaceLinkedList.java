package estruturas.list;

import java.util.List;

public interface MyInterfaceLinkedList<E> extends List<E> {
    
    @Override
    void addFirst(E value);
    
    @Override
    void addLast(E value);
    
    E peekFirst();
    E peekLast();
    
    E search(E value);
    
    @Override
    E removeFirst();
    
    @Override
    E removeLast();
    
    void show();
    void showReverse();
    
} 
