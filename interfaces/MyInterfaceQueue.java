package interfaces;

import java.util.Queue;

public interface MyInterfaceQueue<E> extends Queue<E> {

    boolean isFull();

    void show();

    E peekLast();

}
