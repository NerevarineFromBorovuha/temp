package org.example.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    Callable<String> callable = () -> Thread.currentThread().getName();

//    ExecutorService service = Executors.newFixedThreadPool(10);
//    ExecutorService service = Executors.newSingleThreadExecutor();
//    ExecutorService service = Executors.newCachedThreadPool();
//
//    for (int i = 0; i < 10; i++) {
//      Future<String> future = service.submit(callable);
//      System.out.println(future.get());
//    }
//    service.shutdown();
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
    Callable<String> task = () -> {
      System.out.println(Thread.currentThread().getName());
      return Thread.currentThread().getName();
    };
    scheduledExecutorService.schedule(task, 1, TimeUnit.MINUTES);
    scheduledExecutorService.shutdown();




//    Runnable runnable = () -> {
//      for (int i = 0; i < 10; i++) {
//        System.out.println(Thread.currentThread().getName());
//      }
//    };
//    Executor executor=n->{new Thread(n).start();};
//    executor.execute(runnable);


  }


}
