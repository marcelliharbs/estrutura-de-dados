package exercicio03;

public class Produto {
    String nome;
    String segmento;

    public Produto(String nome, String segmento) {
        this.nome = nome;
        this.segmento = segmento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Segmento: " + segmento;
    }
}



