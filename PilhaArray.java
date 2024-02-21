package aulas;

import exception.StackException;

public class PilhaArray<E> {

    private int idx;
    private final int size;
    private final E[] stack;

    public PilhaArray(int size) {
        this.idx = -1;
        this.size = size;
        this.stack = (E[]) new Object[size];
    }

    public void push(E element) {
        try {
            if (!isFull()) {
                stack[++idx] = element;
            } else {
                throw new StackException("Stack is full!");
            }
        } catch (StackException s) {
            System.err.println(s);
        }
    }

    public E pop() {
        E last = null;
        try {
            if (!isEmpty()) {
                last = stack[idx--];
            } else {
                throw new StackException("Stack is empty!");
            }
        } catch (StackException s) {
            System.err.println(s);
        }
        return last;
    }

    public E peek() {
        try {
            if (!isEmpty()) {
                return stack[idx];
            } else {
                throw new StackException("Stack is empty!");
            }
        } catch (StackException s) {
            System.err.println(s);
        }
        return null;
    }

    public boolean isEmpty() {
        return idx == -1;
    }

    public boolean isFull() {
        return idx == size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            sb.append(stack[i]);
            if (i < idx) sb.append(", ");
        }
        return "[" + sb + "]";
    }
    
}
