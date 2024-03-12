package exercicio02;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Registro> registros = new Vector<>();
        Scanner sc = new Scanner(System.in);

        int opcao = Integer.MAX_VALUE;
        int indice = 0;
        String nomeProcurado = null;
        int tamanho = 0;

        while (opcao != 0) {
            System.out.println("1 | CADASTRAR");
            System.out.println("2 | SELECIONAR TODOS OS REGISTROS");
            System.out.println("3 | PESQUISAR POR TERMO");
            System.out.println("4 | ALTERAR DADOS");
            System.out.println("5 | REMOVER REGISTRO");
            System.out.println("0 | SAIR");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.println(cadastrar(registros, nome, email));
                    break;
                case 2:
                    System.out.println(selecionarRegistros(registros));
                    break;
                case 3:
                    System.out.print("Digite o termo que procura: ");
                    nomeProcurado = sc.nextLine();
                    System.out.println(procurarTermo(registros, nomeProcurado));
                    break;
                case 4:
                    System.out.print("Digite o nome do registro que gostaria de alterar: ");
                    nomeProcurado = sc.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Digite o novo email: ");
                    String novoEmail = sc.nextLine();
                    System.out.println(alterarRegistro(registros, nomeProcurado, novoNome, novoEmail));
                    break;
                case 5:
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

    public static String cadastrar(Vector<Registro> registros, String nome, String email) {
        if (verificarRegistro(registros, nome)) {
            return "Registro já existe.";
        }
        registros.add(new Registro(nome, email));
        return "Registro cadastrado com sucesso!";
    }

    public static String selecionarRegistros(Vector<Registro> registros) {
        String impressao = "";
        if (registros.isEmpty()) {
            return "Não há registros cadastrados.";
        }
        for (Registro r : registros) {
            impressao += r.toString() + "\n";
        }
        return impressao;
    }

    public static String procurarTermo(Vector<Registro> registros, String termo) {
        boolean encontrado = false;
        String impressao = "";
        if (registros.isEmpty()) {
            return "Não há registros cadastrados.";
        }
        for (Registro r : registros) {
            if (r.nome.toLowerCase().contains(termo.toLowerCase())) {
                impressao += r.toString() + "\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "Nenhum registro existente com esse termo";
        }
        return impressao;
    }

    public static String alterarRegistro(Vector<Registro> registros, String nome, String novoNome, String novoEmail) {
        if (registros.isEmpty()) {
            return "Não há registros cadastrados.";
        }
        if (!verificarRegistro(registros, nome)) {
            return "Nenhum registro existente com esse nome";
        }
        if (!nome.equals(novoNome) && verificarRegistro(registros, novoNome)) {
            return "Novo nome já existe!";
        }
        for (Registro r : registros) {
            if (r.nome.equalsIgnoreCase(nome)) {
                r.nome = novoNome;
                r.email = novoEmail;
                return "Registro alterado com sucesso!";
            }
        }
        return "Não foi possível alterar o registro";
    }

    public static String removerRegistro(Vector<Registro> registros, String nome) {
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).nome.equals(nome)) {
                registros.remove(i);
                return "Registro removido com sucesso!";
            }
        }
        return "Registro não encontrado!";
    }

    public static boolean verificarRegistro(Vector<Registro> registros, String nome) {
        for (Registro r : registros) {
            if (r.nome.equals(nome)) {
                return true;
            }
        }
        return false;
    }
}