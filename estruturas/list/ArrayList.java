package estruturas.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {
    
    private int idx;
    private final int size;
    private E[] array;
    
    public ArrayList() {
        idx = -1;
        size = 10;
        array = (E[]) new Object[size];
    }
    
    public ArrayList(int size) {
        this.size = size;
        idx = -1;
        array = (E[]) new Object[size];
    }
    
    @Override
    public boolean add(E element) {
        if (idx == size - 1) {
        	array = growArray(array, 2);
        } else
            array[++idx] = element;
        
        return true;
    }
    
    @Override
    public void add(int index, E element) {
        if (idx == size - 1) {
        	array = growArray(array, 2);
        } else
            array[++idx] = element;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i <= idx; i++)
            array[i] = null;
        idx = -1;
    }
    
    @Override
    public boolean contains(Object element) {
        for (int i = 0; i <= idx; i++)
            if (element.equals((E) array[i]))
                return true;
        return false;
    }
    
    @Override
    public E get(int index) {
        if (!isEmpty() && index > -1 && index <= idx)
            return array[index];
        return null;
    }
    
    @Override
    public E set(int index, E element) {
        return null;
    }
    
    @Override
    public int size() {
        return idx + 1;
    }
    
    @Override
    public int indexOf(Object element) {
        return -1;
    }
    
    @Override
    public boolean isEmpty() {
        return idx == -1;
    }
    
    @Override
    public boolean remove(Object element) {
        if (contains((E) element)) {
            int i = indexOf(element);
            while (i <= idx)
                array[i++] = array[i];
            idx--;
            return true;
        }
        return false;
    }
    
    @Override
    public E remove(int index) {
        E element = null;
        if (index > -1 && index <= idx) {
            element = array[index];
            int i = 0;
            while (i <= idx)
                array[i++] = array[i];
            idx--;
        }
        return element;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append((i < size - 1 ? ", " : ""));
        }
        return "[" + sb + "]";
    }
    
    public static <E> E[] growArray(E[] originalArray, int additionalSize) {
        // Criar um novo array com o tamanho original vezes o tamanho adicional
        E[] newArray = Arrays.copyOf(originalArray, originalArray.length * additionalSize);
        
        return newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < size - 1;
            }

            @Override
            public E next() {
                return array[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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
