package lista1;

public class Q27 {

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] inverso = inverterVetor(original);

        for (int i : inverso) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int[] inverterVetor(int[] vet) {
        int tam = vet.length;
        int[] inverso = new int[tam];
        for (int i = 0, j = tam - 1; i < tam; i++, j--) {
            inverso[i] = vet[j];
        }
        return inverso;
    }

}
