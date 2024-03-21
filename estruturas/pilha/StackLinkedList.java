package estruturas.pilha;

import estruturas.list.MyDoubleLinkedList;
import interfaces.MyInterfaceLinkedList;

public class StackLinkedList<E> {

    public static class StackException extends RuntimeException {

        public StackException(String message) {
            super(message);
        }
    }

    private final MyInterfaceLinkedList<E> stack;

    public StackLinkedList() {
        this.stack = new MyDoubleLinkedList<>();
    }

    public void push(E element) {
        if (isFull()) {
            throw new StackException("Stack is full!");
        }
        stack.addLast(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        return stack.removeLast();
    }

    public E peek() {
        if (isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        return stack.peekLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        stack.showReverse();
        return "";
    }

}
