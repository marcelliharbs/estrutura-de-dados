package exercicio03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opcao = Integer.MAX_VALUE;
        String produtoProcurado = null;

        while (opcao != 0) {
            System.out.println("1 | CADASTRAR PRODUTO");
            System.out.println("2 | SELECIONAR TODOS OS PRODUTOS");
            System.out.println("3 | QUANTIDADE POR SEGMENTO");
            System.out.println("4 | ALTERAR DADOS");
            System.out.println("5 | REMOVER PRODUTO");
            System.out.println("0 | SAIR");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Segmento: ");
                    String segmento = sc.nextLine();
                    System.out.println(cadastrar(produtos, nome, segmento));
                    break;
                case 2:
                    System.out.println(selecionarRegistros(produtos));
                    break;
                case 3:
                    System.out.println(quantidadeSegmentos(produtos));
                    break;
                case 4:
                    System.out.print("Digite o nome do produto que gostaria de alterar: ");
                    produtoProcurado = sc.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Digite o novo segmento: ");
                    String novoSegmento = sc.nextLine();
                    System.out.println(alterarProduto(produtos, produtoProcurado, novoNome, novoSegmento));
                    break;
                case 5:
                    System.out.print("Digite o nome do registro que deseja remover: ");
                    produtoProcurado = sc.nextLine();
                    System.out.println(removerRegistro(produtos, produtoProcurado));
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

    public static String cadastrar(ArrayList<Produto> produtos, String nome, String segmento) {
        if (verificaProduto(produtos, nome)) {
            return "Produto já cadastrado.";
        }
        produtos.add(new Produto(nome, segmento));
        return "Produto cadastrado com sucesso!";
    }

    public static String selecionarRegistros(ArrayList<Produto> produtos) {
        String impressao = "";
        if (produtos.isEmpty()) {
            return "Não há produtos cadastrados.";
        }
        for (Produto p : produtos) {
            impressao += p.toString() + "\n";
        }
        return impressao;
    }

    public static String quantidadeSegmentos(ArrayList<Produto> produtos) {
        String impressao = "";
        Map<String, Integer> segmentoQuantidade = new HashMap<>();

        for (Produto p : produtos) {
            String segmento = p.segmento;
            segmentoQuantidade.put(segmento, segmentoQuantidade.getOrDefault(segmento, 0) + 1);
        }

        impressao += "Quantidade de segmentos:\n";
        for (Map.Entry<String, Integer> entry : segmentoQuantidade.entrySet()) {
            impressao += "Segmento: " + entry.getKey() + "- Quantidade: " + entry.getValue() + "\n";
        }
        return impressao;
    }

    public static String alterarProduto(ArrayList<Produto> produtos, String nome, String novoNome, String novoSegmento) {
        if (produtos.isEmpty()) {
            return "Não há produtos cadastrados.";
        }
        if (!verificaProduto(produtos, nome)) {
            return "Nenhum produto cadastrado com esse nome.";
        }
        if (!nome.equals(novoNome) && verificaProduto(produtos, novoNome)) {
            return "Produto já cadastrado com esse nome.";
        }
        for (Produto p : produtos) {
            if (p.nome.equalsIgnoreCase(nome)) {
                p.nome = novoNome;
                p.segmento = novoSegmento;
                return "Registro alterado com sucesso!";
            }
        }
        return "Não foi possível alterar o registro";
    }

    public static String removerRegistro(ArrayList<Produto> produtos, String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).nome.equals(nome)) {
                produtos.remove(i);
                return "Registro removido com sucesso!";
            }
        }
        return "Registro não encontrado!";
    }

    public static boolean verificaProduto(ArrayList<Produto> produtos, String nome) {
        for (Produto p : produtos) {
            if (p.nome.equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
