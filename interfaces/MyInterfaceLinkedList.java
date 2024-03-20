package interfaces;

import java.util.Collection;
import java.util.List;

public interface MyInterfaceLinkedList<E> extends List<E> {

    E update(E oldValue, E newValue);

    void insert(E after, E newValue);

    E peekFirst();

    E peekLast();

    E search(E value);

    void show();

    void showReverse();

    List<E> subList(E from, E to);

    void addAll(E after, Collection<? extends E> c);

    /**
     * M�todos que dependem de �ndice n�o ser�o usados por LinkedList
     */
    @Override
    default boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("M�todo addAll(int index, Collection<? extends E> c) n�o � suportado em uma lista encadeada simples.\n"
                + "Use addAll(E after, Collection<? extends E> c).");
    }

    @Override
    default E get(int index) {
        throw new UnsupportedOperationException("M�todo get(int index) n�o � suportado em uma lista encadeada simples.\n"
                + "Use get(E element).");
    }

    @Override
    default E set(int index, E element) {
        throw new UnsupportedOperationException("M�todo set(int index, E element) n�o � suportado em uma lista encadeada simples.\n"
                + "Use update(E oldValue, E newValue).");
    }

    @Override
    default void add(int index, E element) {
        throw new UnsupportedOperationException("M�todo add(int index, E element) n�o � suportado em uma lista encadeada simples.\n"
                + "Use insert(E after, E element).");
    }

    @Override
    default E remove(int index) {
        throw new UnsupportedOperationException("M�todo remove(int index) n�o � suportado em uma lista encadeada simples.\n"
                + "Use remove(E element).");
    }

    @Override
    default int indexOf(Object o) {
        throw new UnsupportedOperationException("M�todo indexOf(Object o) n�o � suportado em uma lista encadeada simples.");
    }

    @Override
    default int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("M�todo lastIndexOf(Object o) n�o � suportado em uma lista encadeada simples.");
    }

    @Override
    default java.util.ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("M�todo listIterator(int index) n�o � suportado em uma lista encadeada simples.");
    }

    @Override
    default List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("M�todo subList(int fromIndex, int toIndex) n�o � suportado em uma lista encadeada simples.\n"
                + "Use subList(E from, E to).");
    }

}
