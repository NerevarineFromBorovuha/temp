package org.example.testpack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<A> list = new ArrayList<>();
//    list.add(new A("a", null));
    list.add(new A("b", 2));
    list.add(new A("c", 3));
    list.add(new A("a", 5));
    list.add(new A("c", 5));
    list.add(new A("d", 5));
//    list.add(null);
    list.add(new A("te", 15));
    List<A> test = getList(list);
    test.forEach(System.out::println);
//    A a = getMaxStream(list);
//    System.out.println(a);


//    A a = getMax(list);

//    List<A> list1 = new ArrayList<>();
//    list.removeIf(n ->
//        (n != null && n.i != null) && (n.i >= 15 && n.str.equals("a")));
//    list.forEach(System.out::println);

//    List<A> list1 = getList(list);
//    List<A> list2 = getList(list);
//    list2.removeIf(a->a.i>15 && Objects.equals(a.str, "a"));

//    System.out.println(a);

    /**
     !(А && B)=!A || !B

     FISH(ID, NAME)
     CATCH(ID, FISH_ID, DT, QUANTITY)
     вывести все наименования рыб, где кол-во улова меньше N

     SELECT f.NAME FROM FISH f
     JOIN CATCH c ON(c.FISH_ID=f.ID)
     WHERE c.QUANTITY <  10 OR c.QUANTITY IS NULL

     + за определенный день
     SELECT f.NAME FROM FISH f
     JOIN CATCH c ON(c.FISH_ID=f.ID)
     WHERE (c.QUANTITY <  10 OR c.QUANTITY IS NULL) AND c.DT = '2023-02-01'
     */

  }


  public static A getMaxStream(List<A> list) {

    A a = list.stream()
        .filter(n -> n != null && n.i != null)
        .max(Comparator.comparing(n -> n.i))
        .orElse(null);
//    A a = list.stream()
//        .filter(n -> n != null && n.i != null)
//        .max(Comparator.comparing(n -> n.i))
//        .orElse(null);

    return a;
  }


  public static A getMax(List<A> list) {
    if (list == null && list.isEmpty()) {
      throw new IllegalArgumentException();
    }

    A max = null;
    int index = 0;

    while (list.size() - 1 != index) {
      if (list.get(index) != null && list.get(index).i != null) {
        max = list.get(index);
        break;
      }
      index++;
    }
    for (int i = index; i < list.size(); i++) {
      if (list.get(i) != null && list.get(i).i != null) {
        if (list.get(i).i > max.i) {
          max = list.get(i);
        }
      }
    }

    return max;

  }

  public static List<A> getList(List<A> list) {
    if (list == null) {
      throw new RuntimeException();
    }
    List<A> resultList = new ArrayList<>();

    int low = 0;
    int high = list.size() - 1;
    int numberToFind = 5;

    while (low <= high) {
      int middle = low + (high - low) / 2;
      if (numberToFind > list.get(middle).i) {
        low = middle + 1;
      } else if (numberToFind < list.get(middle).i) {
        high = middle - 1;
      } else if (numberToFind == list.get(middle).i) {
        resultList.add(list.get(middle));
        for (int i = middle+1; i < list.size(); i++) {
          if(numberToFind==list.get(i).i){
            resultList.add(list.get(i));
            continue;
          }
          break;
        }
        for (int i = middle-1; i >=0; i--) {
          if(numberToFind==list.get(i).i){
            resultList.add(list.get(i));
            continue;
          }
          break;
        }
        break;
      }


    }
    return resultList;
  }

  static class A {

    public String str;

    public Integer i;

    public A(String str, Integer i) {
      this.str = str;
      this.i = i;
    }

    @Override
    public String toString() {
      return "A{" + "str='" + str + '\'' + ", i=" + i + '}';
    }
  }

}
