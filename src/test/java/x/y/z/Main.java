package x.y.z;

//import org.junit.runner.JUnitCore;

public class Main {

    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

    Main main = new Main();

    new Thread(new Runnable() {
        
        @Override
        public void run() {
            while (true) {
                synchronized(main.object) {
                    main.object.notifyAll();
                }
            }

        }
    }, "notifier").start();

    new Thread(new Runnable() {
        
        @Override
        public void run() {
            while(true) {
                main.method();

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            
        }
    }, "Bill").start();

    new Thread(new Runnable() {
        
        @Override
        public void run() {
            while(true) {
                main.method();

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }, "Sam").start();

//        JUnitCore core = new JUnitCore();
//        core.run(DevelopmentTestSuite.class);
        //core.run(BaseTestSuite.class);
    }

    private void method() {

        try {

            synchronized (object) {
                System.out.println("begin - " + Thread.currentThread().getName());
                object.wait();
                System.out.println("done - " + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
