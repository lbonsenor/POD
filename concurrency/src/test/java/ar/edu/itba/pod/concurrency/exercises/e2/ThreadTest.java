package ar.edu.itba.pod.concurrency.exercises.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.itba.pod.concurrency.exercises.e1.GenericService;
import ar.edu.itba.pod.concurrency.exercises.e1.GenericServiceImpl;

public class ThreadTest {
    private GenericService service;

    @BeforeEach
    public final void before() {
        service = new GenericServiceImpl();
    }

    @Test
    public final void test() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                this.service.addVisit();
            }
            System.out.println(this.service.getVisitCount());
        });

        thread.start();

    }
}
