package ar.edu.itba.pod.concurrency.iii.pubsub;

import jdk.jfr.Unsigned;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    public void run() {
        long sum = 0;
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    System.out.println(Thread.currentThread().getName() + ":\tTotal Sum: " + sum);
                    return;
                }
                sum += number;
                 System.out.println(Thread.currentThread().getName() + ":\tresult: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}