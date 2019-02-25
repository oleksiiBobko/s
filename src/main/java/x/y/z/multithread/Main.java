package x.y.z.multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private Hook hook = new Hook();
    private Object monitor = new Object();

    private Storage storage = new Storage();
    private SomeService someService = new SomeService();

    Queue<Integer> queue = new LinkedList<>();
    List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {

        new Main().method();

    }

    private void method() {

        for (int i = 0; i < 100; i++) {

//            storage.setValue(storage.getValue() + 1);

            Thread t = new Thread(() -> {

                while (hook.isActive()) {
                    synchronized (monitor) {

                    if (queue.isEmpty()) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            System.err.println(Thread.currentThread().getName() + " was interrupted");
                            e.printStackTrace();
                        }
                    } else {

                        Integer nextValue = queue.poll();

                        storage.setValue(someService.processValue(storage.getValue(), nextValue == null ? 0 : nextValue));

                        // System.out.println(Thread.currentThread().getName() + ":" + storage.getValue() + " I'm off");
                    }
                    }
                }

            }, "collector-" + i);

            t.start();

            threads.add(t);

        }

        new Thread(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 10; i++) {
                    queue.add(1);
                    monitor.notifyAll();
                }
                System.err.println(Thread.currentThread().getName() + " Is about to finish");
            }
        }, "producer").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hook.setActive(false);
//        myNotify();
        interrupt();
        System.err.println("VALUE = " + storage.getValue());

    }

    private void interrupt() {
        threads.stream().forEach(Thread::interrupt);

    }

    private void myNotify() {
        synchronized (monitor) {
            monitor.notifyAll();
        }
        
    }

}
