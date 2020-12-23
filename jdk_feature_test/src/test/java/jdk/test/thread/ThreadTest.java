package jdk.test.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest {
    private static Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    @Test
    public void testWait() throws InterruptedException {
        logger.info("start");

        Thread t1 = new Thread(new WaitingTask(1));
        t1.start();

        Thread t2 = new Thread(new WaitingTask(2));
        t2.start();

        Thread.sleep(2000);


        synchronized (t1) {
            System.out.println("notify t1");
            t1.notify();
            System.out.println("notify t1 done");
        }
        synchronized (t2) {
            System.out.println("notify t2");
            t2.notify();
            System.out.println("notify t2 done");
        }
        Thread.sleep(3000);

        System.out.println("all done");
    }

    class WaitingTask implements Runnable {
        private final int id;

        public WaitingTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread currentThread = Thread.currentThread();
            logger.info("t-{} locking currentThread: {}", id, currentThread);
            synchronized (currentThread) {
                logger.info("t-{} locked", id);
                try {
                    logger.info("t-{} wait", id);
                    currentThread.wait();
                    logger.info("t-{} wait done", id);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("t-{} leave", id);

        }
    }


}
