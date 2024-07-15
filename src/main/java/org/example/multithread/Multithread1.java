package org.example.multithread;

import java.util.concurrent.TimeUnit;

public class Multithread1 {
  //что будет ?
  private static volatile Boolean stopRequsted = false;

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(()->{
      int i =0;
      while(!stopRequsted){
        i++;
      }
      System.out.println(i);
    });
    thread.start();
    TimeUnit.SECONDS.sleep(1);
    stopRequsted = true;
  }

}
