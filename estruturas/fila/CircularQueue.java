package estruturas.fila;

import interfaces.MyInterfaceQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<E> implements MyInterfaceQueue<E> {

    private E[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }

        this.capacity = capacity;
        array = (E[]) new Object[capacity];
        rear = front = size = 0;
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
        array[rear] = e;
        rear = (rear + 1) % capacity;
        if (isFull()) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }
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
        E e = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;
        return e;
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
        return array[front];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[(rear + capacity - 1) % capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Elemento nulo.");
        }
        for (E element : array) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        if (!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = front, count = 0; count < size; i = (i + 1) % capacity, count++) {
                sb.append(array[i]).append(", ");
            }
            System.out.println("[" + sb.append("\b\b") + "]");
        } else {
            System.out.println("[]");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int idx = front;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Não há mais elementos para iterar.");
                }
                E element = array[idx];
                idx = (idx + 1) % capacity;
                count++;
                return element;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) array;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[(front + i) % capacity].equals(o)) {
                array[(front + i) % capacity] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains((E) element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            if (!offer(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove((E) element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(array[(front + i) % capacity])) {
                remove(array[(front + i) % capacity]);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[capacity];
        rear = front = size = 0;
    }

}
