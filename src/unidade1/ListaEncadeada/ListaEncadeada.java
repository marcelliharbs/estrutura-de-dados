package unidade1.ListaEncadeada;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novoNo = new NoLista<T>(valor);
        novoNo.setProximo(primeiro);
        primeiro = novoNo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                atual.setProximo(atual.getProximo().getProximo());
            }
            atual = atual.getProximo();
        }
    }

    public int obterComprimento() {
        int count = 0;
        NoLista<T> atual = primeiro;
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }

    public NoLista<T> obterNo(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> atual = primeiro;
        int count = 0;

        while (atual != null) {
            if (count == index) {
                return atual;
            }
            count++;
            atual = atual.getProximo();
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        String impressao = "";
        NoLista<T> atual = primeiro;
        while (atual != null) {
            impressao += atual.toString() + ", ";
        }
        return impressao;
    }
}
