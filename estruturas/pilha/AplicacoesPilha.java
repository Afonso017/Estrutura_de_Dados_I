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

        System.out.print("Digite uma express�o (apenas com inteiros): ");
        String exp = leia.nextLine();

        if (isValidExpression(exp)) {
            System.out.println("\nA express�o " + exp + " � v�lida.");

            String posfixa = posfixa(exp);
            System.out.println("\nSua express�o na forma p�s-fixa: " + posfixa);

            System.out.println("\nO resultado da express�o � " + solve(posfixa));
        } else {
            System.out.println("\nA express�o " + exp + " n�o � v�lida.");
        }
    }

    /**
     * Verifica se uma express�o tem os s�mbolos de par�ntesis, colchetes e
     * chaves v�lidos.
     *
     * @param expression express�o a ser analisada.
     * @return true se a express�o � v�lida.
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
     * Converte uma express�o da forma infixa para p�s-fixa. Essa vers�o
     * funciona apenas para valores inteiros.
     *
     * @param expressao express�o a ser convertida.
     * @return a express�o na sua forma posfixa.
     * @throws InvalidExpressionException caso a express�o seja inv�lida.
     */
    public static String posfixa(String expressao) throws InvalidExpressionException {
        if (!isValidExpression(expressao)) {
            throw new InvalidExpressionException("Essa express�o n�o � v�lida.");
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
     * Resolve uma express�o no formato p�s-fixa. Aceita apenas valores
     * inteiros.
     *
     * @param exp express�o a ser resolvida.
     * @return o resultado da express�o.
     * @throws ArithmeticException caso ocorra divis�o por zero.
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
                        throw new ArithmeticException("Divis�o por zero.");
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
