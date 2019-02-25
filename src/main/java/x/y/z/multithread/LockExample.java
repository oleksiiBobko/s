package x.y.z.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    final ReentrantLock reentrantLock = new ReentrantLock();

    public void performTask() {

        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
            System.out.println("Processing...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Lock released.");
            reentrantLock.unlock();
        }
    }
}