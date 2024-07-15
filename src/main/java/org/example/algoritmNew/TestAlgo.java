package org.example.algoritmNew;

import java.util.List;
import java.util.Objects;

public class TestAlgo {

  public static void main(String[] args) {
//    fun(4);
    fun1();


  }

  private static void fun(int i) {
    if(i>0){
      fun(--i);
      System.out.println("i = " + i);
      fun(--i);
    }
  }

  private static void fun1() {
    List<String> ints = List.of("One", "One");
    List raw = ints;
    List<Integer> strings = raw;
    System.out.println(Objects.equals(strings.get(0),strings.get(1)));
  }

}
