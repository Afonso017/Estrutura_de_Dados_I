package lista1;

import java.util.Scanner;

public class Q26 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        // Entrada dos dados
        System.out.print("Digite a quantidade de linhas da matriz: ");
        int linhas = leia.nextInt();
        
        System.out.print("Digite a quantidade de colunas da matriz: ");
        int colunas = leia.nextInt();
        
        // Cria uma matriz e preenche com os valores
        int[][] matriz = new int[linhas][colunas];
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                matriz[i][j] = leia.nextInt();
            }
        }

        // Imprime a matriz
        System.out.print("\nMatriz\nx ");
        for (int i = 0; i < linhas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
