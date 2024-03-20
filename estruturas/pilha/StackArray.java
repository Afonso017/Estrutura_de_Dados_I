package estruturas.pilha;

public class StackArray<E> {

    public static class StackException extends RuntimeException {

        public StackException(String message) {
            super(message);
        }
    }

    private int idx;
    private final int size;
    private final E[] stack;

    public StackArray(int size) {
        this.idx = -1;
        this.size = size;
        this.stack = (E[]) new Object[size];
    }

    public void push(E element) {
        if (isFull()) {
            throw new StackException("Stack is full!");
        }
        stack[++idx] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        return stack[idx--];
    }

    public E peek() {
        if (isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        return stack[idx];
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
            if (i < idx) {
                sb.append(", ");
            }
        }
        return "[" + sb + "]";
    }

}
