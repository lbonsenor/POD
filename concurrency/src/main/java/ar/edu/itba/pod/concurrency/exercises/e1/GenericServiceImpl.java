package ar.edu.itba.pod.concurrency.exercises.e1;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Basic implementation of {@link GenericService}.
 */
public class GenericServiceImpl implements GenericService {
    private int visit = 0;
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();

    @Override
    public String echo(String message) {
        return message;
    }

    @Override
    public String toUpper(String message) {
        return Optional.ofNullable(message)
                .map(m -> m.toUpperCase())
                .orElse(null);
    }

    @Override
    public void addVisit() {
        visit++;
    }

    @Override
    public int getVisitCount() {
        return visit;
    }

    @Override
    public boolean isServiceQueueEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void addToServiceQueue(String name) {
        queue.add(name);
    }

    @Override
    public String getFirstInServiceQueue() {
        return Optional.ofNullable(queue.poll())
                .orElseThrow(() -> new IllegalStateException("No one in queue"));
    }
}
