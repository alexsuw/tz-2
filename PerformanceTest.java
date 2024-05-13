import java.util.*;

public class PerformanceTest {

    private static final int TRIALS = 20; // Количество тестов для каждого размера данных

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000, 10000000};
        for (int size : sizes) {
            runPerformanceTests(size);
        }
    }

    private static void runPerformanceTests(int size) {
        List<Long> timesMin = new ArrayList<>();
        List<Long> timesMax = new ArrayList<>();
        List<Long> timesSum = new ArrayList<>();
        List<Long> timesMult = new ArrayList<>();

        for (int trial = 0; trial < TRIALS; trial++) {
            List<Integer> numbers = generateRandomNumbers(size);

            timesMin.add(measureTime(() -> NumberProcessor._min(numbers)));
            timesMax.add(measureTime(() -> NumberProcessor._max(numbers)));
            timesSum.add(measureTime(() -> NumberProcessor._sum(numbers)));
            timesMult.add(measureTime(() -> NumberProcessor._mult(numbers)));
        }

        System.out.printf("Average time to find min for %d elements: %d ms\n", size, average(timesMin));
        System.out.printf("Average time to find max for %d elements: %d ms\n", size, average(timesMax));
        System.out.printf("Average time to sum %d elements: %d ms\n", size, average(timesSum));
        System.out.printf("Average time to multiply %d elements: %d ms\n", size, average(timesMult));
    }

    private static List<Integer> generateRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(size));
        }
        return numbers;
    }

    private static long measureTime(Runnable function) {
        long startTime = System.currentTimeMillis();
        function.run();
        return System.currentTimeMillis() - startTime;
    }

    private static long average(List<Long> times) {
        long total = 0;
        for (long time : times) {
            total += time;
        }
        return total / times.size();
    }
}
