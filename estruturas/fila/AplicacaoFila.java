package estruturas.fila;

import interfaces.MyInterfaceQueue;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AplicacaoFila {

    public static void main(String[] args) {
        System.out.println("SIMULANDO COMPORTAMENTO DE UM ESCALONADOR DE PROCESSOS");
        testarFilaCircular();

        Scanner leia = new Scanner(System.in);
        System.out.print("Digite a quantidade de cidades que deseja calcular: ");
        int cidades = leia.nextInt();

        System.out.print("Digite os valores da matriz de distâncias:\n  ");
        int[][] matriz = new int[cidades][cidades];
        for (int i = 0; i < cidades; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < cidades; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cidades; j++) {
                matriz[i][j] = leia.nextInt();
            }
        }

        System.out.print("\nDigite qual é a cidade inicial: ");
        int cidadeInicial = leia.nextInt();

        int[] vetorResultado = calcularDistancias(matriz, cidadeInicial);

        System.out.println("\nVetor com as distâncias:");
        for (int i = 0; i < vetorResultado.length; i++) {
            System.out.println("Cidade " + i + ": " + vetorResultado[i]);
        }
    }

    // Este é um exemplo hipotético de uso de fila circular.
    // Simula uma fila de processos que serão escalonados pelo Sistema Operacional.
    public static void testarFilaCircular() {
        MyInterfaceQueue<String> fila = new CircularQueue<>(5);

        // Adicionando processos à fila
        fila.offer("Processo 1");
        fila.offer("Processo 2");
        fila.offer("Processo 3");
        fila.offer("Processo 4");
        fila.offer("Processo 5");

        fila.show();

        // Removendo um processo da fila, irá remover o primeiro processo adicionado
        String removedProcess = fila.poll();
        System.out.println("\nProcesso removido: " + removedProcess + "\n");

        fila.show();

        // Sobrescrevendo o primeiro processo
        fila.offer("Processo 6");

        fila.show();

        // Simulando a chegada de novos processos aleatórios
        Random random = new Random();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("\nProcesso a ser escalonado: " + fila.poll());

                System.out.print("\nAdicionando novo processo na fila... ");
                String novoProcesso = "Processo " + (random.nextInt(50) + 1);
                System.out.println(novoProcesso);
                fila.offer(novoProcesso);

                fila.show();
                Thread.sleep(3000);
            }

            // Caso hipotético em que não cheguem mais processos
            while (!fila.isEmpty()) {
                System.out.println("\nProcesso a ser escalonado: " + fila.poll());

                fila.show();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static int[] calcularDistancias(int[][] matriz, int cidadeInicial) {
        int[] vetorResultado = new int[matriz.length];

        Arrays.fill(vetorResultado, -1);
        vetorResultado[cidadeInicial] = 0;

        MyInterfaceQueue<Integer> fila = new LinkedCircularQueue<>();
        fila.add(cidadeInicial);

        while (!fila.isEmpty()) {
            int cidadeAtual = fila.poll();

            for (int cidadeVisitada = 0; cidadeVisitada < matriz.length; cidadeVisitada++) {
                int distancia = matriz[cidadeAtual][cidadeVisitada];

                if (distancia > 0 && vetorResultado[cidadeVisitada] == -1) {
                    vetorResultado[cidadeVisitada] = vetorResultado[cidadeAtual] + distancia;
                    fila.add(cidadeVisitada);
                }
            }
        }

        return vetorResultado;
    }

}
