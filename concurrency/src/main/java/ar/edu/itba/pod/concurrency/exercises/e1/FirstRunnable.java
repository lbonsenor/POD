package ar.edu.itba.pod.concurrency.exercises.e1;

public class FirstRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new FirstRunnable());
        thread.start();
    }

}
