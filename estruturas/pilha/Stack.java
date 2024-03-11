package estruturas.pilha;

public class Stack {
    
    /**
     * This is a LIFO (Last-In-First-Out) Stack
     * 
     * @param <T> 
     */
    static class Pilha<T> {
        
        private final T[] array;
        private int tam = 10;
        private int stackCounter = 0;
        
        public Pilha() {
            array = (T[]) new Object[tam];
        }
        
        public void push(T element) {
            if (stackCounter < tam) {
                array[stackCounter++] = element;
            } else {
                // instantiates a new array with 2 * lenght
            }
        }
        
        public T pop() {
            array[stackCounter--] = null;
            return array[stackCounter];
        }
        
        public T peek() {
            return array[stackCounter-1];
        }
        
        public boolean isEmpty() {
            return stackCounter == 0;
        }
        
        public int search(T element) {
            return 0;
        }
        
        @Override
        public String toString() {
            String stk = "Stack:\n{\n";
            for (int i = stackCounter-1; i >= 0; i--) {
                stk += "\t" + array[i] + "\n";
            }
            return stk + "}";
        }
        
    }
    
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha();
        
        p.push(1);
        p.push(2);
        p.push(3);
        
        System.out.println(p);
        
        p.pop();
        
        System.out.println(p);
    }
    
}
