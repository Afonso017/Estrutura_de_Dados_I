package estruturas.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements MyInterfaceLinkedList<E> {
    
    @Override
    public E search(E value) {
        if (head != null) {
            Node p = head;
            while (p != tail) {
                if (p.data.equals(value)) {
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
        if (head != null) {
            sb.append(" ");
            Node p = head;
            while (p != tail) {
                sb.append(p.data);
                if (p.next != tail) {
                    sb.append(", ");
                }
                p = p.next;
            }
            sb.append(" ");
        }
        System.out.println("[" + sb + "]");
    }
    
    @Override
    public void showReverse() {
        StringBuilder sb = new StringBuilder();
        
        System.out.println("[" + sb + "]");
    }
    
    private class Node {
        
        Node next;
        E data;
        
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
	 
    private int size;
    private Node head;
    private Node tail;
    
	public MyLinkedList () {
		this.size = 0;
        this.head = null;
        this.tail = null;
	}
    
    public MyLinkedList (E value) {
		this.size = 1;
        this.head = new Node(value);
        this.tail = head;
	}
    
    @Override
    public void addFirst(E value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    @Override
    public void addLast(E value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }
    
    @Override
    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    
    @Override
    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }
    
    @Override
    public E removeFirst() {
        
        return null;
    }
    
    @Override
    public E removeLast() {
        
        return null;
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
        Node p = head;
        while (p != tail) {
            if (p.data.equals(o)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    
    @Override
    public Iterator<E> iterator() {
        return null;
    }
    
    @Override
    public Object[] toArray() {
        if (size > 0) {
            int i = 0;
            Object[] array = new Object[size];
            Node p = head;
            while (p != tail) {
                array[i++] = p.data;
                p = p.next;
            }
            return array;
        }
        return null;
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        if (size > 0) {
            int i = 0;
            T[] array = (T[]) new Object[size];
            Node p = head;
            while (p != tail) {
                array[i++] = (T) p.data;
                p = p.next;
            }
            return array;
        }
        return null;
    }
    
    @Override
    public boolean add(E e) {
        
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public void clear() {
        if (head != null) {
            Node p = head.next;
            while (p != tail) {
                head.next = null;
                head = p;
                p = head.next;
            }
        }
    }
    
    @Override
    public E get(int index) {
        return null;
    }
    
    @Override
    public E set(int index, E element) {
        return null;
    }
    
    @Override
    public void add(int index, E element) {
        
    }
    
    @Override
    public E remove(int index) {
        return null;
    }
    
    @Override
    public int indexOf(Object o) {
        return 0;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
    
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    
}
