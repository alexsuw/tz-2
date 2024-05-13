import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class NumberProcessor {
    public static List<Integer> readNumbersFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return Arrays.stream(content.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int _min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }

    public static int _max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public static long _sum(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }

    public static long _mult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("src/numbers.txt");
            System.out.println("Минимальное: " + _min(numbers));
            System.out.println("Максимальное: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
