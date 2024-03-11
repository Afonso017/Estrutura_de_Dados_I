package estruturas.list;

public class ArrayList {
    
    /**
     * This is a generic array list implementation.
     * 
     * @param <T> Generic type element of the array.
     */
    static class Lista<T> {
        
        private final T[] array;
        private int size;
        
        public Lista(int initialSize) {
            this.array = (T[]) new Object[initialSize];
            this.size = -1;
        }
        
        public void add(T element) {
            if (size < array.length) {
                array[++size] = element;
            } else {
                System.err.println("List is full.");
            }
        }
        
        public T get(int idx) {
            if (idx >= 0 && idx <= size) {
                return array[idx];
            }
            System.err.println("Error on get method:");
            System.err.println("Index out of bounds for size: " + (size + 1));
            return null;
        }
        
        public int size() {
            return size + 1;
        }
        
        public void set(int idx, T element) {
            if (idx >= 0 && idx <= size) {
                array[idx] = element;
            } else {
                System.err.println("Error on set method:");
                System.err.println("Index out of bounds for size: " + (size + 1));
            }
        }
        
        public void remove(T element) {
            int i = 0;
            while (array[i] != element && i < size) i++;
            if (array[i] == element) {
                for (int j = i + 1; j <= size; j++) {
                    array[i++] = array[j];
                }
                size--;
            } else {
                System.err.println("Element " + element + " not found in list.");
            }
        }
        
        @Override
        public String toString() {
            StringBuilder elem = new StringBuilder();
            for (int i = 0; i <= size; i++) {
                elem.append(array[i]);
                if (i < size) {
                    elem.append(", ");
                }
            }
            return "[" + elem + "]";
        }
        
    }
    
    public static void main(String[] args) {
        Lista list = new Lista(5);
        list.add(1);
        list.set(0, 5);
        list.remove(9);
        
        System.out.println(list);
    }
    
}
