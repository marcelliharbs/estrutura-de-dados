/*
Usei a Fila para este exercício pois ela funciona de uma forma em que o primeiro elemento inserido,
vai ser o primeiro a ser removido. Dessa forma, ele é prático para usar em situações
como a que o enunciado pedia. Assim pude aproveitar os métodos específicos da coleção Queue.
* */

package exercicio4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> filaAtendimento = new LinkedList<>();
        int opcao = Integer.MAX_VALUE;

        while (opcao != 0) {

            System.out.println("-ATENDIMENTO-");
            System.out.println("1 | Cadastrar atendimento");
            System.out.println("2 | Remover atendimento");
            System.out.println("0 | Encerrar sistema");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    filaAtendimento.add(nome);
                    break;
                case 2:
                    if (filaAtendimento.isEmpty()) {
                        System.out.println("Não há mais elementos a serem removidos.");
                    } else {
                        System.out.println("Elemento removido: " + filaAtendimento.remove());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}
