package ar.edu.itba.pod.concurrency.iii.e3;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Benchmark to compare between {@link Arrays#parallelSort(int[])} and
 * {@link Arrays#sort(int[])}
 */
public class SortBenchmark {
    static final int MULTIPLIER = 100000;

    @Test
    public void benchmark_all() {
        final Consumer<int[]> serial = Arrays::sort;
        final Consumer<int[]> parallel = Arrays::parallelSort;

        final Random random = new Random();

        final int[] small = random.ints(10*MULTIPLIER, 0, Integer.MAX_VALUE).toArray();
        final int[] medium = random.ints(25*MULTIPLIER, 0, Integer.MAX_VALUE).toArray();
        final int[] large = random.ints(100*MULTIPLIER, 0, Integer.MAX_VALUE).toArray();

        benchmark(small, serial, "serial SMALL");
        benchmark(medium, serial, "serial MEDIUM");
        benchmark(large, serial, "serial LARGE");
        benchmark(small, parallel, "parallel SMALL");
        benchmark(medium, parallel, "parallel MEDIUM");
        benchmark(large, parallel, "parallel LARGE");

    }

    public void benchmark(final int[] array, final Consumer<int[]> order, final String message) {
        long accumulate = 0;
        for (int i = 0; i < 4; i++) {
            final int[] cp = Arrays.copyOf(array, array.length);
            final long startTime = System.currentTimeMillis();
            order.accept(cp);
            final long finishTime = System.currentTimeMillis();
            accumulate += finishTime - startTime;
        }
        System.out.println(message + "\ttook " + (accumulate/4)+" ms");
    }

}
