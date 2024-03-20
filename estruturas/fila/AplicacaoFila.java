package estruturas.fila;

import interfaces.MyInterfaceQueue;
import java.util.Random;

public class AplicacaoFila {

    // Este é um exemplo hipotético de uso de fila circular.
    // Simula uma fila de processos que serão escalonados pelo Sistema Operacional.
    public static void main(String[] args) {
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
}
