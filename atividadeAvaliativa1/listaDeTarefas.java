import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class listaDeTarefas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> listaDeTarefas = new LinkedList<>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n-LISTA DE TAREFAS-");
            System.out.println("1 | CADASTRAR NOVA TAREFA");
            System.out.println("2 | CONCLUIR TAREFA");
            System.out.println("3 | VISUALIZAR PRÓXIMA TAREFA");
            System.out.println("0 | FINALIZAR");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDescreva a tarefa brevemente: ");
                    String tarefa = sc.nextLine();
                    listaDeTarefas.add(tarefa);
                    System.out.println("Tarefa cadastrada com sucesso!");
                    break;
                case 2:
                    if (listaDeTarefas.isEmpty()) {
                        System.out.println("\nNão há mais tarefas a serem concluidas.");
                    } else {
                        System.out.println("\nTarefa concluida: " + listaDeTarefas.remove());
                    }
                    break;
                case 3:
                    if (listaDeTarefas.isEmpty()) {
                        System.out.println("\nNão há mais tarefas cadastradas.");
                    } else {
                        System.out.println("\nPróxima tarefa: " + listaDeTarefas.peek());
                    }
                    break;
                case 0:
                    System.out.println("\nFinalizando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}
