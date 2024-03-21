package estruturas.list;

import interfaces.MyInterfaceLinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyDoubleLinkedList<E> implements MyInterfaceLinkedList<E> {

    private class Node {

        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
        }

        Node(Node next) {
            this.next = next;
        }

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public class ListIterator implements java.util.ListIterator<E> {

        private Node prev;
        private Node p;
        private boolean modified;

        public ListIterator() {
            prev = null;
            p = head;
            modified = false;
        }

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Não há próximo elemento na lista.");
            }

            prev = p;
            p = p.next;
            modified = false;
            return prev.data;
        }

        @Override
        public boolean hasPrevious() {
            return prev != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("Não há elemento anterior na lista.");
            }

            p = prev;
            prev = (p == head) ? null : p.prev;
            modified = false;
            return p.data;
        }

        @Override
        public void add(E element) {
            Node newNode = new Node(element);
            if (p == null) {
                if (tail != null) {
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                } else {
                    head = tail = newNode;
                }
            } else {
                newNode.next = p;
                newNode.prev = prev;
                if (prev != null) {
                    prev.next = newNode;
                } else {
                    head = newNode;
                }
                p.prev = newNode;
            }

            prev = newNode;
            size++;
            modified = true;
        }

        @Override
        public void set(E element) {
            if (modified) {
                throw new IllegalStateException("O método set() não pode ser chamado logo após uma operação que modifique a lista. Chame next() ou previous() antes.");
            }
            if (p == null) {
                throw new IllegalStateException("Nenhum elemento foi retornado por next() ou previous().");
            }
            p.data = element;
        }

        @Override
        public void remove() {
            if (modified) {
                throw new IllegalStateException("O método remove() não pode ser chamado logo após uma operação que modifique a lista. Chame next() ou previous() antes.");
            }

            if (p == null) {
                throw new IllegalStateException("Nenhum elemento foi retornado por next() ou previous().");
            }

            Node nextNode = p.next;
            if (prev != null) {
                prev.next = nextNode;
            } else {
                head = nextNode;
            }

            if (nextNode != null) {
                nextNode.prev = prev;
            } else {
                tail = prev;
            }

            p = nextNode;
            size--;
            modified = true;
        }

        // Métodos nextIndex() e previousIndex() não são suportados em uma lista duplamente encadeada
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Método nextIndex() não é suportado em um ListIterator de uma lista encadeada dupla.");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Método previousIndex() não é suportado em um ListIterator de uma lista encadeada dupla.");
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public MyDoubleLinkedList() {
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void addFirst(E value) {
        if (!isEmpty()) {
            head.prev = new Node(value, head);
            head = head.prev;
        } else {
            head = new Node(value);
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(E value) {
        if (!isEmpty()) {
            Node n = new Node(value);
            n.prev = tail;
            tail.next = n;
            tail = n;
        } else {
            tail = new Node(value);
            head = tail;
        }
        size++;
    }

    @Override
    public E peekFirst() {
        return (head == null ? null : head.data);
    }

    @Override
    public E peekLast() {
        return (tail == null ? null : tail.data);
    }

    @Override
    public boolean remove(Object obj) {
        if (!isEmpty()) {
            E element = (E) obj;
            if (head.data.equals(element)) {
                removeFirst();
                return true;
            } else if (tail.data.equals(element)) {
                removeLast();
                return true;
            } else {
                Node p = head;
                while (p != null && !p.data.equals(element)) {
                    p = p.next;
                }

                if (p == null) {
                    return false;
                }

                Node previousNode = p.prev;
                Node nextNode = p.next;

                previousNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = previousNode;
                } else {
                    tail = previousNode;
                }

                p.prev = null;
                p.next = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            Node p = head;
            if (head != tail) {
                head = head.next;
                head.prev = null;
                p.next = null;
            } else {
                head = null;
                tail = null;
            }
            size--;
            return p.data;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            Node p = tail;
            if (head != tail) {
                tail = tail.prev;
                tail.next = null;
                p.prev = null;
            } else {
                head = null;
                tail = null;
            }
            size--;
            return p.data;
        }
        return null;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            if (head != tail) {
                Node p = head;
                Node n = head.next;
                while (n != null) {
                    n.prev = null;
                    p.next = null;
                    p = n;
                    n = n.next;
                }
            }
            head = tail = null;
            size = 0;
        }
    }

    @Override
    public E update(E oldValue, E newValue) {
        if (!isEmpty()) {
            Node u = head;
            while (u != null && !u.data.equals(oldValue)) {
                u = u.next;
            }

            if (u == null) {
                return null;
            }

            E old = u.data;
            u.data = newValue;
            return old;
        }
        return null;
    }

    @Override
    public void insert(E previousValue, E newValue) {
        if (!isEmpty()) {
            Node p = head;
            while (p != null && !p.data.equals(previousValue)) {
                p = p.next;
            }

            if (p != null) {
                Node n = new Node(newValue, p, p.next);
                p.next = n;
                p = n.next;
                p.prev = n;
            }
        }
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
    public boolean contains(Object o) {
        E obj = (E) o;
        if (isEmpty() || o == null || !(obj instanceof E)) {
            return false;
        }

        if (head == tail) {
            return head.data.equals(obj);
        }

        Node n = head;
        Node p = tail;

        int comparations = (size % 2 == 0 ? (size / 2) - 1 : size / 2);
        for (int i = 0; i <= comparations; i++) {
            if (n.data.equals(obj) || p.data.equals(obj)) {
                return true;
            }
            n = n.next;
            p = p.prev;
        }
        return false;
    }

    @Override
    public E search(E value) {
        if (!isEmpty()) {
            Node n = head;
            Node p = tail;
            int comparations = (size % 2 == 0 ? (size / 2) - 1 : size / 2);
            for (int i = 0; i <= comparations; i++) {
                if (n.data.equals(value)) {
                    return n.data;
                } else if (p.data.equals(value)) {
                    return p.data;
                }
                n = n.next;
                p = p.prev;
            }
        }
        return null;
    }

    @Override
    public void show() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.data);
            if (p != tail) {
                sb.append(" -> ");
            }
            p = p.next;
        }
        System.out.println("[" + sb + "]");
    }

    @Override
    public void showReverse() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            Node p = tail;
            while (p != null) {
                sb.append(p.data);
                if (p.prev != null) {
                    sb.append(" -> ");
                }
                p = p.prev;
            }
        }
        System.out.println("[" + sb + "]");
    }

    @Override
    public Object[] toArray() {
        if (!isEmpty()) {
            int i = 0;
            Object[] array = new Object[size];
            Node p = head;
            while (p != null) {
                array[i++] = p.data;
                p = p.next;
            }
            return array;
        }
        return null;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (!isEmpty() && array != null) {
            int i = 0;
            Node p = head;
            while (p != null && i < array.length) {
                array[i++] = (T) p.data;
                p = p.next;
            }
            return array;
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public List<E> subList(E from, E to) {
        List<E> subLista = new MyDoubleLinkedList<>();

        if (isEmpty()) {
            return subLista;
        }

        Node p = head;
        while (p != null && !p.data.equals(from)) {
            p = p.next;
        }

        if (p == null) {
            return subLista;
        }

        subLista.add(p.data);
        if (p.data.equals(to)) {
            return subLista;
        }

        p = p.next;
        while (p != null && !p.data.equals(to)) {
            subLista.add(p.data);
            p = p.next;
        }

        return subLista;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Set<E> set = new HashSet<>();
        Node p = head;
        while (p != null) {
            set.add(p.data);
            p = p.next;
        }

        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        c.forEach(element -> addLast(element));
        return true;
    }

    @Override
    public void addAll(E after, Collection<? extends E> c) {
        if (!isEmpty()) {
            Node p = head;
            while (p != null && !p.data.equals(after)) {
                p = p.next;
            }

            if (p != null) {
                for (E element : c) {
                    Node newNode = new Node(element);
                    newNode.prev = p;
                    newNode.next = p.next;

                    if (p.next != null) {
                        p.next.prev = newNode;
                    } else {
                        tail = newNode;
                    }

                    p.next = newNode;
                    p = newNode;
                    size++;
                }
            }
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        if (!isEmpty()) {
            Object[] array = toArray();
            for (Object element : array) {
                if (c.contains(element)) {
                    remove((E) element);
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        if (!isEmpty()) {
            Object[] array = toArray();
            for (Object element : array) {
                if (!c.contains(element)) {
                    remove((E) element);
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final Node prev = new Node(head);
            private Node p = prev;

            @Override
            public boolean hasNext() {
                return p.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Não há próximo elemento.");
                }
                p = p.next;
                return p.data;
            }
        };
    }

    @Override
    public java.util.ListIterator<E> listIterator() {
        return new ListIterator();
    }

}
