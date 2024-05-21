package unidade1.ListaEstatica.questao1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEstaticaTest {

    private ListaEstatica lista = new ListaEstatica();

    @Test //1
    public void testeMetodoInclusao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test //2
    public void testeMetodoObtencaoTamanho() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test //3
    public void testeMetodoBuscar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));

    }

    @Test //4
    public void testeBuscarElementoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test //5
    public void testeMetodoRetirar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());

        assertEquals(3, lista.getTamanho());
    }

    @Test //6
    public void testeInclusaoRedimensionamento() {
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());

        assertEquals(15, lista.getTamanho());
    }

    @Test //7
    public void testeObterElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    @Test //8
    public void testeLancamentoExcecao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try {
            lista.obterElemento(5);
            fail();
        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test //9
    public void testeLiberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertEquals(true, lista.estaVazia());
    }
}