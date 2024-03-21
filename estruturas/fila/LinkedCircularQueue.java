package estruturas.fila;

import estruturas.list.MyDoubleLinkedList;
import interfaces.MyInterfaceLinkedList;
import interfaces.MyInterfaceQueue;
import java.util.Collection;
import java.util.Iterator;

public class LinkedCircularQueue<E> implements MyInterfaceQueue<E> {

    private final MyInterfaceLinkedList<E> queue;

    public LinkedCircularQueue() {
        queue = new MyDoubleLinkedList<>();
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Elemento nulo.");
        }
        queue.addLast(e);
        return true;
    }

    @Override
    public E remove() {
        return poll();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    @Override
    public E element() {
        return peek();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.peekFirst();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return queue.peekLast();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Elemento nulo.");
        }
        return queue.contains(o);
    }

    @Override
    public void show() {
        queue.show();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) queue.toArray();
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }

}
