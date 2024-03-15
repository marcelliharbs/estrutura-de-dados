package exercicio04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> nomes = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = Integer.MAX_VALUE;

        while (opcao != 0) {
            System.out.println("1 | CADASTRAR");
            System.out.println("2 | LISTAR");
            System.out.println("0 | FINALIZAR");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome para cadastrar:");
                    String nome = scanner.nextLine();
                    nomes.add(nome);
                    System.out.println("Nome cadastrado com sucesso!");
                    break;
                case 2:
                    if (nomes.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Nomes cadastrados:");
                        for (String n : nomes) {
                            System.out.println(n);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
