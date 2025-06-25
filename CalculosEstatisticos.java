import java.util.*;

public class CalculosEstatisticos {
    public static double calcularMedia(List<Double> lista) {
        return lista.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public static double calcularModa(List<Double> lista) {
        Map<Double, Integer> frequencia = new HashMap<>();
        for (double num : lista) {
            frequencia.put(num, frequencia.getOrDefault(num, 0) + 1);
        }
        int maxFreq = Collections.max(frequencia.values());
        return frequencia.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq)
                .map(Map.Entry::getKey)
                .findFirst().orElse(Double.NaN);
    }

    public static double calcularMinimo(List<Double> lista) {
        return Collections.min(lista);
    }

    public static double calcularMaximo(List<Double> lista) {
        return Collections.max(lista);
    }

    public static double calcularDesvioPadrao(List<Double> lista) {
        double media = calcularMedia(lista);
        double somaQuadrados = lista.stream()
                .mapToDouble(v -> Math.pow(v - media, 2)).sum();
        return Math.sqrt(somaQuadrados / lista.size());
    }
}
