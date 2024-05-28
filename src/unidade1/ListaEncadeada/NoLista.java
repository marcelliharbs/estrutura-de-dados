package unidade1.ListaEncadeada;

public class NoLista<T> {
    private T info;
    private NoLista<T> proximo;

    public NoLista(T info) {
        this.info = info;
        this.proximo = null;
    }

    public NoLista(T info, NoLista<T> proximo) {
        this.info = info;
        this.proximo = proximo;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NoLista{" +
                "info=" + info +
                ", proximo=" + proximo +
                '}';
    }
}
