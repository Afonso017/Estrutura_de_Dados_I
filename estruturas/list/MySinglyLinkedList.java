package estruturas.list;

import interfaces.MyInterfaceLinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class MySinglyLinkedList<E> implements MyInterfaceLinkedList<E> {

    private class Node {

        E data;
        Node next;

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

    }

    public class ListIterator implements java.util.ListIterator<E> {

        private final Node prev;
        private Node p;
        private boolean modified;

        public ListIterator() {
            prev = new Node(head);
            p = prev;
            modified = false;
        }

        @Override
        public boolean hasNext() {
            return p.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Não há próximo elemento na lista.");
            }
            p = p.next;
            modified = false;
            return p.data;
        }

        @Override
        public boolean hasPrevious() {
            return p != prev;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("Não há elemento anterior na lista.");
            }
            modified = false;
            if (p == head) {
                p = prev;
                return head.data;
            }
            Node temp = head;
            while (temp.next != p) {
                temp = temp.next;
            }
            p = temp;
            return p.next.data;
        }

        @Override
        public void add(E element) {
            if (p == null) {
                throw new IllegalStateException("O método add() não pode ser chamado quando não há elemento atual.");
            }
            Node n = new Node(element);
            if (p == prev) {
                n.next = head;
                head = n;
            } else if (p == tail) {
                tail = n;
            }
            p.next = n;
            p = n;
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
            if (p == head) {
                if (p == tail) {
                    head = tail = null;
                } else {
                    Node temp = head;
                    head = head.next;
                    prev.next = head;
                    temp.next = null;
                }
                p = prev;
            } else if (p == tail) {
                p = head;
                tail = head;
            } else {
                Node temp = p.next;
                p.data = temp.data;
                temp.next = null;
                if (temp == tail) {
                    tail = p;
                }

                temp = head;
                while (temp.next != p) {
                    temp = temp.next;
                }
                p = temp;
            }

            modified = true;
            size--;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Método nextIndex() não é suportado em um ListIterator de uma lista encadeada simples.");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Método previousIndex() não é suportado em um ListIterator de uma lista encadeada simples.");
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public MySinglyLinkedList() {
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void addFirst(E value) {
        if (!isEmpty()) {
            Node newNode = new Node(value, head);
            head = newNode;
        } else {
            head = new Node(value);
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(E value) {
        if (!isEmpty()) {
            tail.next = new Node(value);
            tail = tail.next;
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
            } else if (tail.data.equals(element)) {
                removeLast();
            } else {
                Node p = head;
                while (p != null && !p.data.equals(element)) {
                    p = p.next;
                }

                if (p == null) {
                    return false;
                }

                Node d = p.next;
                p.next = d.next;
                d.next = null;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E removed = head.data;
            if (head != tail) {
                Node p = head;
                head = head.next;
                p.next = null;
            } else {
                head = null;
                tail = null;
            }
            size--;
            return removed;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E removed = tail.data;
            if (head != tail) {
                Node p = head;
                while (p.next != tail) {
                    p = p.next;
                }
                tail = p;
                p.next = null;
            } else {
                head = null;
                tail = null;
            }
            size--;
            return removed;
        }
        return null;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            Node p = head;
            while (p != null) {
                Node next = p.next;
                p.next = null;
                p = next;
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
                Node newNode = new Node(newValue);
                newNode.next = p.next;
                p.next = newNode;
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
        if (o == null || !(obj instanceof E)) {
            return false;
        }
        Node p = head;
        while (p != null) {
            if (p.data.equals(obj)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public E search(E value) {
        if (head != null) {
            Node p = head;
            while (p != null) {
                if (value.equals(p.data)) {
                    return p.data;
                }
                p = p.next;
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
            Node r = new Node(head.data);
            Node reverse = r;
            Node p = head.next;

            while (p != null) {
                reverse.next = new Node(p.data);
                reverse = reverse.next;
                p = p.next;
            }

            p = head;
            while (p != null) {
                sb.append(r.data);
                if (p != tail) {
                    sb.append(" -> ");
                }
                p = p.next;
                r = r.next;
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
        List<E> subLista = new MySinglyLinkedList<>();

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
                    newNode.next = p.next;
                    p.next = newNode;
                    if (p == tail) {
                        tail = newNode;
                    }
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
