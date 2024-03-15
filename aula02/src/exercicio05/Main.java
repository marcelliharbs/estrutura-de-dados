package exercicio05;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Double> listaAlunos = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int opcao = Integer.MAX_VALUE;
        double notaMinima = 0;
        char escolha = 'e';

        while (opcao != 0) {
            System.out.println("1 | CADASTRAR ALUNO");
            System.out.println("2 | PROCURAR ALUNO");
            System.out.println("3 | ALTERAR DADOS");
            System.out.println("4 | REMOVER ALUNO");
            System.out.println("5 | ESTATISTICAS");
            System.out.println("0 | SAIR");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (notaMinima == 0) {
                        System.out.print("Digite a média para aprovação: ");
                        notaMinima = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.print("Digite  o nome do aluno: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a média do aluno: ");
                    double media = sc.nextDouble();
                    System.out.println(cadastrarAluno(listaAlunos, nome, media));
                    break;
                case 2:
                    System.out.print("Digite o nome do aluno procurado: ");
                    nome = sc.nextLine();
                    System.out.println(procurarAluno(listaAlunos, nome));
                    break;
                case 3:
                    System.out.print("Digite o nome do aluno que deseja alterar os dados: ");
                    nome = sc.nextLine();
                    if (listaAlunos.containsKey(nome)) {
                        System.out.print("Digite a nova média do aluno: ");
                        media = sc.nextDouble();
                        System.out.println(alterarDados(listaAlunos, nome, media));
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do aluno que deseja remover: ");
                    nome = sc.nextLine();
                    System.out.println(removerAluno(listaAlunos, nome));
                    break;
                case 5:
                    while (escolha != 's') {
                        System.out.println("\nDigite 'm' para média aritmética da turma.");
                        System.out.println("Digite 'a' para total de aprovados da turma.");
                        System.out.println("Digite 'r' para total de reprovados da turma.");
                        System.out.println("Digite 's' para sair de estatísticas.");
                        escolha  = sc.nextLine().toLowerCase().charAt(0);
                        int totalAlunos = listaAlunos.size();
                        double somaNotas = 0;
                        int aprovados = 0;
                        int reprovados = 0;
                        for (double nota : listaAlunos.values()) {
                            somaNotas += nota;
                            if (nota >= notaMinima) {
                                aprovados++;
                            } else {
                                reprovados++;
                            }
                        }
                        double mediaNotas = somaNotas / totalAlunos;
                        switch (escolha) {
                            case 'm' -> {
                                System.out.print("Média artimética da turma: " + mediaNotas);
                            }
                            case 'a' -> {
                                System.out.print("Alunos aprovados: " + aprovados);
                            }
                            case 'r' -> {
                                System.out.print("Alunos reprovados: " + reprovados);
                            }
                            case 's' -> {
                                System.out.println("Saindo de 'Estatísticas'");
                            }
                            default -> {
                                System.out.println("Opção inválida.");
                            }
                        }
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

    public static String cadastrarAluno(HashMap<String, Double> listaAlunos, String nome, double media) {
        if (listaAlunos.containsKey(nome)) {
            return "Aluno já cadastrado";
        }
        listaAlunos.put(nome, media);
        return "Aluno cadastrado com sucesso!";
    }

    public static String procurarAluno(HashMap<String, Double> listaAlunos, String nome) {
        if (listaAlunos.containsKey(nome)) {
            double media = listaAlunos.get(nome);
            return "Aluno encontrado. Média: " + media;
        } else {
            return "Aluno não encontrado.";
        }
    }

    public static String alterarDados(HashMap<String, Double> listaAlunos, String nome, double novaMedia) {
        listaAlunos.put(nome, novaMedia);
        return "Dados do aluno atualizados com sucesso!";
    }

    public static String removerAluno(HashMap<String, Double> listaAlunos, String nome) {
        if (listaAlunos.containsKey(nome)) {
            listaAlunos.remove(nome);
            return "Aluno removido com sucesso!";
        } else {
            return "Aluno não encontrado.";
        }
    }
}

