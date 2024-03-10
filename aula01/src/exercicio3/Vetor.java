package exercicio3;

public class Vetor {
    Produto[] produtos;

    public Vetor() {
        this.produtos = new Produto[0];
    }

    public void cadastrar(Produto produto) {
        int tamanho = this.produtos.length;
        tamanho += 1;

        Produto[] vetorTemp = new Produto[tamanho];

        for (int i = 0; i < this.produtos.length; i++) {
            vetorTemp[i] = this.produtos[i];
        }

        vetorTemp[tamanho - 1] = produto;

        this.produtos = vetorTemp;
    }

    public void remover(int indice) {
        Produto[] novoArray = new Produto[produtos.length - 1];
        int novoIndice = 0;

        for (int i = 0; i < produtos.length; i++) {
            if (i != indice) {
                novoArray[novoIndice] = produtos[i];
                novoIndice++;
            }
        }

        produtos = novoArray;
    }
}
