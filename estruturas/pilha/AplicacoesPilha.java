package estruturas.pilha;

import java.util.Arrays;
import java.util.Scanner;

public class AplicacoesPilha {

    public static class InvalidExpressionException extends RuntimeException {

        public InvalidExpressionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite uma expressão (apenas com inteiros): ");
        String exp = leia.nextLine();

        if (isValidExpression(exp)) {
            System.out.println("\nA expressão " + exp + " é válida.");

            String posfixa = posfixa(exp);
            System.out.println("\nSua expressão na forma pós-fixa: " + posfixa);

            System.out.println("\nO resultado da expressão é " + solve(posfixa));
        } else {
            System.out.println("\nA expressão " + exp + " não é válida.");
        }
    }

    /**
     * Verifica se uma expressão tem os símbolos de parêntesis, colchetes e
     * chaves válidos.
     *
     * @param expression expressão a ser analisada.
     * @return true se a expressão é válida.
     */
    public static boolean isValidExpression(String expression) {
        StackArray<Character> chars = new StackArray<>(expression.length());

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(', '[', '{':
                    chars.push(c);
                    break;

                case ')':
                    if (chars.isEmpty() || chars.pop() != '(') {
                        return false;
                    }
                    break;

                case ']':
                    if (chars.isEmpty() || chars.pop() != '[') {
                        return false;
                    }
                    break;

                case '}':
                    if (chars.isEmpty() || chars.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return chars.isEmpty();
    }

    /**
     * Converte uma expressão da forma infixa para pós-fixa. Essa versão
     * funciona apenas para valores inteiros.
     *
     * @param expressao expressão a ser convertida.
     * @return a expressão na sua forma posfixa.
     * @throws InvalidExpressionException caso a expressão seja inválida.
     */
    public static String posfixa(String expressao) throws InvalidExpressionException {
        if (!isValidExpression(expressao)) {
            throw new InvalidExpressionException("Essa expressão não é válida.");
        }

        StringBuilder saida = new StringBuilder();
        StackArray<Character> stack = new StackArray<>(expressao.length());

        for (char ch : expressao.replace(" ", "").toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;

                case ')':
                    char aux;
                    while ((aux = stack.pop()) != '(') {
                        saida.append(aux);
                    }
                    break;

                case '+', '-':
                    while (!stack.isEmpty() && Arrays.asList('+', '-', '*', '/').contains(stack.peek())) {
                        saida.append(stack.pop());
                    }
                    stack.push(ch);
                    break;

                case '*', '/':
                    while (!stack.isEmpty() && Arrays.asList('*', '/').contains(stack.peek())) {
                        saida.append(stack.pop());
                    }
                    stack.push(ch);
                    break;

                default:
                    saida.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            saida.append(stack.pop());
        }

        return saida.toString();
    }

    /**
     * Resolve uma expressão no formato pós-fixa. Aceita apenas valores
     * inteiros.
     *
     * @param exp expressão a ser resolvida.
     * @return o resultado da expressão.
     * @throws ArithmeticException caso ocorra divisão por zero.
     */
    public static int solve(String exp) {
        StackArray<Integer> stack = new StackArray(exp.length());

        for (char ch : exp.toCharArray()) {
            switch (ch) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;

                case '-':
                    int n = stack.pop();
                    stack.push(stack.pop() - n);
                    break;

                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;

                case '/':
                    n = stack.pop();
                    if (n == 0) {
                        throw new ArithmeticException("Divisão por zero.");
                    }
                    stack.push(stack.pop() / n);
                    break;

                default:
                    stack.push(Character.getNumericValue(ch));
            }
        }

        return stack.pop();
    }

}
