package ar.edu.itba.pod.concurrency.exercises.e1;

public class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hola desde un thread");
    }

    public static void main(String[] args) {
        final Thread thread = new FirstThread();

        System.out.println("Antes del thread");
        thread.start();
        System.out.println("Despues del thread");
    }
}
