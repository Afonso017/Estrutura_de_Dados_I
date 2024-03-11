package lista1;

import java.util.Scanner;

public class Q20 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Qual o investimento inicial? R$ ");
        double investimentoInicial = leia.nextDouble();

        System.out.print("Quanto irá investir mensalmente? R$ ");
        double investimentoMensal = leia.nextDouble();

        System.out.print("Em quantos meses vai aplicar o investimento? ");
        int meses = leia.nextInt();

        System.out.print("Qual a taxa de juros mensal? (em %) ");
        double taxaJurosMensal = leia.nextDouble() / 100;

        // Saldo acumulado inicia com o valor do investimento inicial
        double saldoAcumulado = investimentoInicial;

        // Calcula o rendimento mensal para cada mês
        for (int i = 1; i <= meses; i++) {

            // Os juros mensais serão aplicados ao saldo acumulado atual
            double jurosAplicados = saldoAcumulado * taxaJurosMensal;

            // Calcula o rendimento mensal com base nos juros aplicados ao saldo acumulado
            double rendimentoMensal = investimentoMensal + jurosAplicados;

            // O saldo acumula com o rendimento de cada mês
            saldoAcumulado += rendimentoMensal;

            System.out.printf("\nSaldo acumulado no mês %d: R$ %.2f\n", i, saldoAcumulado);
            System.out.printf("Rendimento mensal: R$ %.2f", rendimentoMensal);
        }
        System.out.println("");

    }

}
