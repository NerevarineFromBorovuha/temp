package org.example.algoritmNew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Algoritm2 {

  public static void main(String[] args) {
    task1();
//    task2();
//    System.out.println(task3());
  }


  /*3) массив с уникальными числами Int найти элемент,
  который меньше максимума, но больше всех остальных*/
  private static void task1() {
    int[] mas = {10, 15, 23, 11, 44, 13, 66, 1, 6, 17};
    int max = -1;
    int preMax = -1;
/*    for (int i = 0; i < mas.length; i++) {
      if (mas[i] > max) {
        max = mas[i];
      }
    }
    for (int i = 0; i < mas.length; i++) {
      if (mas[i] < max && mas[i] > preMax) {
        preMax = mas[i];
      }
    }*/

    for(int i = 0;i<mas.length;i++){
      if(mas[i]>max){
        preMax = max;
        max = mas[i];
      }else if(mas[i]>preMax){
        preMax = mas[i];
      }
    }
    System.out.println(max);
    System.out.println(preMax);
  }

  /**
   * 3)  удалить все строки коллекции, начинающиеся на abc не используя фичи java8
   */
  private static void task2() {
    Collection<String> strings = new ArrayList<>();
    strings.add("abcas");
    strings.add("ab1c2asd");
    strings.add("bca");
    Iterator<String> iterator = strings.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().startsWith("abc")) {
        iterator.remove();
      }
    }
    System.out.println(strings);
  }

  /**
   * 3)  определить что строка является регистронезависимым и пробельнвм полиндромом без создания
   * новых строк
   */
  private static boolean task3() {
    String str = "A bc Ba";
    int start = 0;
    int last = str.length()-1;
    boolean flag = true;
    while (start==last) {
      char char1 = str.charAt(start);
      char char2 = str.charAt(last);
      if(!Character.isLetterOrDigit(char1)){
        start++;
        continue;
      }
      if(!Character.isLetterOrDigit(char2)){
        last--;
        continue;
      }
      if (Character.toUpperCase(char1) != Character.toUpperCase(char2)) {
        flag = false;
        return flag;
      }
      start++;
      last--;
    }
    return flag;
  }

}
