import java.util.*;

public class Estatistica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> valores = new ArrayList<>();
        System.out.println("Digite os valores (pressione Enter em branco para finalizar):");

        while (true) {
            System.out.print("Valor: ");
            String input = scanner.nextLine();
            if (input.isBlank()) break;

            try {
                double numero = Double.parseDouble(input);
                valores.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }

        if (valores.isEmpty()) {
            System.out.println("Nenhum valor informado.");
        } else {
            System.out.printf("Média: %.3f%n", CalculosEstatisticos.calcularMedia(valores));
            System.out.printf("Moda: %.3f%n", CalculosEstatisticos.calcularModa(valores));
            System.out.printf("Mínimo: %.3f%n", CalculosEstatisticos.calcularMinimo(valores));
            System.out.printf("Máximo: %.3f%n", CalculosEstatisticos.calcularMaximo(valores));
            System.out.printf("Desvio Padrão: %.3f%n", CalculosEstatisticos.calcularDesvioPadrao(valores));
        }
    }
}
