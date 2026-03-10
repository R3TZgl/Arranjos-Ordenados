import java.util.Arrays;

public class ArranjoOrdenado {
    private int[] elementos;
    private int tamanho;
    private final boolean crescente;

    public ArranjoOrdenado(int capacidade, boolean crescente) {
        this.elementos = new int[capacidade];
        this.tamanho = 0;
        this.crescente = crescente;
    }

    public void inserir(int valor) {
        if (tamanho >= elementos.length) return;

        int pos = encontrarPosicaoParaInserir(valor);
        
        // Deslocamento (Shift) para a direita: O(n)
        for (int i = tamanho; i > pos; i--) {
            elementos[i] = elementos[i - 1];
        }
        
        elementos[pos] = valor;
        tamanho++;
    }

    public void excluir(int valor) {
        int pos = buscarIndice(valor);
        if (pos == -1) return;

        // Deslocamento (Shift) para a esquerda: O(n)
        for (int i = pos; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }

    private int encontrarPosicaoParaInserir(int valor) {
        int inicio = 0, fim = tamanho - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (crescente) {
                if (elementos[meio] < valor) inicio = meio + 1;
                else fim = meio - 1;
            } else {
                if (elementos[meio] > valor) inicio = meio + 1;
                else fim = meio - 1;
            }
        }
        return inicio;
    }

    public int buscarIndice(int valor) {
        int inicio = 0, fim = tamanho - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (elementos[meio] == valor) return meio;
            if (crescente) {
                if (elementos[meio] < valor) inicio = meio + 1;
                else fim = meio - 1;
            } else {
                if (elementos[meio] > valor) inicio = meio + 1;
                else fim = meio - 1;
            }
        }
        return -1;
    }

    public int getTamanho() { return tamanho; }
    public int[] getElementos() { return Arrays.copyOf(elementos, tamanho); }
}
