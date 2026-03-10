import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArranjoOrdenadoTest {
    @Test
    void deveManterOrdemCrescente() {
        ArranjoOrdenado arr = new ArranjoOrdenado(5, true);
        arr.inserir(50);
        arr.inserir(10);
        arr.inserir(30);
        assertArrayEquals(new int[]{10, 30, 50}, arr.getElementos());
    }

    @Test
    void deveExcluirElementoEReordenar() {
        ArranjoOrdenado arr = new ArranjoOrdenado(5, true);
        arr.inserir(10);
        arr.inserir(20);
        arr.excluir(10);
        assertEquals(1, arr.getTamanho());
        assertEquals(20, arr.getElementos()[0]);
    }
}
