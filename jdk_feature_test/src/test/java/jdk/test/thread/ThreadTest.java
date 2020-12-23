package jdk.test.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest {
    private static Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    @Test
    public void testWaitAndNotify() throws InterruptedException {
        logger.info("start");

        Thread t1 = new Thread(new WaitingTask(1));
        logger.info("t1.state = {}", t1.getState());

        t1.start();

        Thread t2 = new Thread(new WaitingTask(2));
        t2.start();

        Thread.sleep(2000);


        logger.info("t1.state = {}", t1.getState());
        synchronized (t1) {
            logger.info("t1.state = {}", t1.getState());
            logger.info("notify t1");
            t1.notify();
            logger.info("notify t1 done");
            logger.info("t1.state = {}", t1.getState());
        }
        synchronized (t2) {
            logger.info("notify t2");
            t2.notify();
            logger.info("notify t2 done");
        }
        Thread.sleep(3000);

        logger.info("t1.state = {}", t1.getState());

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
                    logger.info("t-{} state = {}", id, currentThread.getState());
                    currentThread.wait();
                    logger.info("t-{} state = {}", id, currentThread.getState());
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

            logger.info("t-{} state = {}", id, currentThread.getState());
        }
    }


    @Test
    public void testWaitAndNotifyAll() throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread t0 = new Thread(new WaitingMainTask(main));
        t0.start();
        Thread t1 = new Thread(new WaitingMainTask(main));
        t1.start();
        Thread t2 = new Thread(new WaitingMainTask(main));
        t2.start();
        Thread t3 = new Thread(new WaitingMainTask(main));
        t3.start();

        Thread.sleep(2000);


        logger.info("t0 state = {}", t0.getState());
        logger.info("t1 state = {}", t1.getState());
        logger.info("t2 state = {}", t2.getState());
        logger.info("t3 state = {}", t3.getState());

        synchronized (main) {
            main.notify();

            Thread.sleep(1000);
            logger.info("t0 state = {}", t0.getState());
            logger.info("t1 state = {}", t1.getState());
            logger.info("t2 state = {}", t2.getState());
            logger.info("t3 state = {}", t3.getState());

        }

        Thread.sleep(2000);
        synchronized (main) {
            main.notifyAll();
            Thread.sleep(1000);
            logger.info("t0 state = {}", t0.getState());
            logger.info("t1 state = {}", t1.getState());
            logger.info("t2 state = {}", t2.getState());
            logger.info("t3 state = {}", t3.getState());
        }

        Thread.sleep(2000);
        logger.info("t0 state = {}", t0.getState());
        logger.info("t1 state = {}", t1.getState());
        logger.info("t2 state = {}", t2.getState());
        logger.info("t3 state = {}", t3.getState());
    }


    class WaitingMainTask implements Runnable {
        private final Thread main;

        public WaitingMainTask(Thread main) {
            this.main = main;
        }

        @Override
        public void run() {
            synchronized (main) {
                try {
                    logger.info("wait main");
                    main.wait();
                    logger.info("wait main done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
