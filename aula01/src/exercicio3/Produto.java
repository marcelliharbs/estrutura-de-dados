package exercicio3;

public class Produto {
    String nome;
    double valor;


    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome + " - Valor: R$" + valor;
    }
}
