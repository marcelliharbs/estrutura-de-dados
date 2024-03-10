package exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vetor vetor = new Vetor();

        int opcao = Integer.MAX_VALUE;
        boolean encontrado = false;
        String produtoProcurado = null;

        while (opcao != 0) {
            System.out.println("1 | Cadastrar produto");
            System.out.println("2 | Listar todos os produtos");
            System.out.println("3 | Pesquisar produto");
            System.out.println("4 | Alterar");
            System.out.println("5 | Remover");
            System.out.println("0 | Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o valor do produto: ");
                    double valor = sc.nextDouble();
                    vetor.cadastrar(new Produto(nome, valor));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Produtos: ");
                    for (Produto p : vetor.produtos) {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    System.out.print("Digite o produto que procura: ");
                    produtoProcurado = sc.nextLine();
                    for (Produto p : vetor.produtos) {
                        if (p.nome.equalsIgnoreCase(produtoProcurado)) {
                            System.out.println(p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Não foi encontrado nenhum produto.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o produto que deseja alterar: ");
                    produtoProcurado = sc.nextLine();
                    for (Produto p : vetor.produtos) {
                        if (p.nome.equalsIgnoreCase(produtoProcurado)) {
                            System.out.println("Produto encontrado: " + p);
                            System.out.print("Informe novo nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Informe novo valor: ");
                            double novoValor = sc.nextDouble();
                            p.nome = novoNome;
                            p.valor = novoValor;
                            System.out.println("Produto alterado com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Não foi encontrado nenhum produto.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o produto que deseja remover: ");
                    produtoProcurado = sc.nextLine();
                    for (int i = 0; i < vetor.produtos.length; i++) {
                        Produto p = vetor.produtos[i];
                        if (p.nome.equalsIgnoreCase(produtoProcurado)) {
                            System.out.println("Produto encontrado: " + p);
                            vetor.remover(i);
                            System.out.println("Produto removido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Não foi encontrado nenhum produto.");
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
    }
}