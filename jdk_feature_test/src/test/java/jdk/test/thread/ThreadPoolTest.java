package jdk.test.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPoolTest {



    @Test
    public void whySingleThread() throws InterruptedException, ExecutionException, TimeoutException {
//      - 'new Thread(()->{...}).start();' can't return a result
//      - and a new thread is create for once

        // a thread pool with only one thread with an unbounded queue, which only executes one task at a time
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future2 = executor.submit(() -> {
            System.out.println("start sleep in task2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep done2 in task2");
            return "sleep done2";
        });
        Future<?> future1 = executor.submit(() -> {
            System.out.println("start sleep in task1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep done1 in task1");
            return "sleep done1";
        });
        // there is only a thread to run 2 task
        // these 2 task will be executed in order

        System.out.println("keep going..");
        Object result = future1.get(5, TimeUnit.SECONDS);
        System.out.println("result2: "+ future2.get());
        System.out.println("result1: "+ result);
    }


    @Test
    public void newFixedThreadPool() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 30; i++) {
            executor.execute(new SleepTask(i));
        }
        Thread.sleep(20000);
    }

    class SleepTask implements Runnable {
        private int id;
        public SleepTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("start sleep in task"+id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep done in task"+id);
        }
    }

    @Test
    public void newCachedThreadPool() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            executor.execute(new SleepTask(i));
        }
        Thread.sleep(3000);
    }



    @Test
    public void scheduleAtFixedRate() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.scheduleWithFixedDelay(new SleepTask(i), 0, 100, TimeUnit.MILLISECONDS);
        }

        Thread.sleep(20000);
        Thread.sleep(20000);

    }

}
