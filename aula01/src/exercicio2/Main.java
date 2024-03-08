package exercicio2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] listaNomes = new String[10];

        int opcao = Integer.MAX_VALUE;
        int indice = 0;
        String nomeProcurado = null;
        boolean encontrado = false;

        while (!(opcao == 0)) {
            System.out.println("1 | Cadastrar");
            System.out.println("2 | Listar");
            System.out.println("3 | Alterar");
            System.out.println("4 | Remover");
            System.out.println("0 | Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome que deseja cadastrar: ");
                    String nome = sc.nextLine();
                    if (indice < 10) {
                        listaNomes[indice] = nome;
                        System.out.println("Nome cadastrado com sucesso.");
                        indice++;
                    } else {
                        System.out.println("Limite atingido.");
                    }
                    break;
                case 2:
                    for (int i = 0; i < indice; i++) {
                        System.out.println(listaNomes[i]);
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome que você gostaria de alterar: ");
                    nomeProcurado = sc.nextLine();
                    encontrado = false;
                    for (int i = 0; i < indice; i++) {
                        if (nomeProcurado.equalsIgnoreCase(listaNomes[i])) {
                            System.out.println("Digite o novo nome: ");
                            String novoNome = sc.nextLine();
                            listaNomes[i] = novoNome;
                            System.out.println("Nome alterado com sucesso.");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nome não econtrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome que você gostaria de remover: ");
                    nomeProcurado = sc.nextLine();
                    encontrado = false;
                    for (int i = 0; i < indice; i++) {
                        if (nomeProcurado.equalsIgnoreCase(listaNomes[i])) {
                            for (int j = i; j < indice - 1; j++) {
                                listaNomes[j] = listaNomes[j + 1];
                            }
                            listaNomes[indice - 1] = null;
                            indice--;
                            System.out.println("Nome removido com sucesso.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nome não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}
