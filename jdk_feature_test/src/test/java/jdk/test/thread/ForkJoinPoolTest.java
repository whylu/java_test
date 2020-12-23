package jdk.test.thread;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// see: http://www.h-online.com/developer/features/The-fork-join-framework-in-Java-7-1762357.html
public class ForkJoinPoolTest {

    @Test
    public void test() throws InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.execute(new MyTask("hello workd, ming01. are you ok?"));
        Thread.sleep(3000);
    }

    class MyTask extends RecursiveTask<String> {
        private final String string;

        public MyTask(String string) {
            this.string = string;
        }

        @Override
        protected String compute() {
            if(string.indexOf(",")!=-1) {
                split(string, ",");
            } else if(string.indexOf(" ")!=-1) {
                split(string, " ");
            } else {
                System.out.println("done "+string);
            }
            return null;
        }

        private void split(String string, String spliter) {
            System.out.println("split "+string);
            String[] strings = string.split(spliter);
            List<MyTask> myTasks = Stream.of(strings).map(MyTask::new).collect(Collectors.toList());
            ForkJoinTask.invokeAll(myTasks);
        }
    }
}
