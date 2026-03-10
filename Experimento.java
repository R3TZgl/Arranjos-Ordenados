import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Experimento {
    private static final int CAPACIDADE = 100_000;
    private static final int EXECUCOES = 100;

    public static void main(String[] args) {
        executarTeste("INSERÇÃO", true);  // Crescente
        executarTeste("INSERÇÃO", false); // Decrescente
    }

    private static void executarTeste(String operacao, boolean tipoCrescente) {
        long[] tempos = new long[EXECUCOES];
        Random random = new Random();

        for (int i = 0; i < EXECUCOES; i++) {
            ArranjoOrdenado arr = new ArranjoOrdenado(CAPACIDADE, tipoCrescente);
            long t1 = System.nanoTime();
            
            for (int j = 0; j < CAPACIDADE; j++) {
                // Aqui você alternaria entre j, (CAPACIDADE-j) ou random.nextInt()
                arr.inserir(random.nextInt()); 
            }
            
            long t2 = System.nanoTime();
            tempos[i] = t2 - t1;
        }

        double media = calcularMedia(tempos);
        double desvio = calcularDesvioPadrao(tempos, media);

        System.out.printf("Resultado [%s]: Média: %.2f ns | Desvio: %.2f ns%n", 
                          tipoCrescente ? "Crescente" : "Decrescente", media, desvio);
    }

    private static double calcularMedia(long[] dados) {
        double soma = 0;
        for (long d : dados) soma += d;
        return soma / dados.length;
    }

    private static double calcularDesvioPadrao(long[] dados, double media) {
        double somaQuadrados = 0;
        for (long d : dados) somaQuadrados += Math.pow(d - media, 2);
        return Math.sqrt(somaQuadrados / dados.length);
    }
}
