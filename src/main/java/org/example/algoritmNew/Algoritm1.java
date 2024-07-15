package org.example.algoritmNew;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Algoritm1 {

  public static void main(String[] args) {
//    task1();
//    task2();
//    task3();
//    task4();
//    task5();
//    task6();
//    task7();
//    task8();
//    task9();
//    task10();
//    task11();
//    task12();
//    task13();
//    task14();
//    task15();
//    task16();
//    task17();
//    task18();
    task19();
  }

  /**
   * Напишите класс, который принимает с клавиатуры два целых положительных числа: N и М
   * (неизвестно, какое из введенных чисел больше). Класс должен вывести на экран все целые числа
   * между наименьшим и наибольшим значениями, введенными с клавиатуры.
   */
  public static void task1() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите число 1");
    int m = scanner.nextInt();
    System.out.println("Введите число 2");
    int n = scanner.nextInt();
    if (n > m) {
      int temp = n;
      n = m;
      m = temp;
    }
    n++;
    do {
      System.out.println(n++);
    } while (m > n);
  }

  /**
   * Учитывая целочисленный массив nums, возвращайте значение true, если какое-либо значение
   * встречается в массиве хотя бы дважды, и возвращайте значение false, если каждый элемент
   * различен.
   */
  private static void task2() {
    int[] array1 = new int[]{1, 2, 3, 1};//true
    int[] array2 = new int[]{1, 2, 3, 4};//false
    Set<Integer> set = new HashSet<>();
    boolean flag = false;
    for (int i = 0; i < array2.length; i++) {
      if (!set.add(array2[i])) {
        flag = true;
      }
    }
    System.out.println(flag);
  }

  /**
   * Учитывая две строки s и t, верните, true если t является анаграммой s, и false в противном
   * случае . Анаграмма — это слово или фраза , образованная путем перестановки букв другого слова
   * или фразы, обычно с использованием всех исходных букв ровно один раз.
   */
  private static void task3() {
    String s = "anagram";
    String t = "anargam";
    char[] char1 = s.toCharArray();
    char[] char2 = t.toCharArray();
    Arrays.sort(char1);
    Arrays.sort(char2);
    boolean isAnagram = Arrays.equals(char1, char2);
    System.out.println(isAnagram);
  }

  /**
   * Учитывая две строки s и t, верните, true если t является полиндромом s, и false в противном
   * случае .
   */
  private static void task4() {
    String s = "anagram";
    String t = "margana";
    char[] char1 = s.toCharArray();
    char[] char2 = t.toCharArray();
    boolean isPolyndrom = false;
    if (char1.length == char2.length) {
      for (int i = 0; i < char1.length / 2; i++) {
        if (char1[i] != char2[char1.length - i - 1]) {
          System.out.println(isPolyndrom);
          return;
        }
      }
    }
    isPolyndrom = true;
    System.out.println(isPolyndrom);
  }

  /**
   * Найдите первое не дублирующееся число
   */
  private static void task5() {
    int[] arr = {1, 4, 9, -1, 0, 6, 7, 4, 5, -1, 0};
    //ключ = число, значение = количество совпадений
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (Integer i : arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    Integer i = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        i = entry.getKey();
        break;
      }
    }
    System.out.println(i);
  }

  /**
   * Задача: Напишите программу, которая выводит на экран числа через пробел от 1 до 100
   * включительно. При этом вместо чисел, кратных 3, программа должна выводить слово «Fizz», а
   * вместо чисел, кратных 5 — слово «Buzz». Если число кратно и 3, и 5, то программа должна
   * выводить слово «FizzBuzz».
   */
  private static void task6() {
    Random rnd = new Random();
    int n = rnd.nextInt(100);
    System.out.println(n);
    String str = "";
    if (n % 3 == 0) {
      str = "Fizz";
    }
    if (n % 5 == 0) {
      str += "Buzz";
    }
    if (str.isEmpty()) {
      System.out.println(n);
      return;
    }
    System.out.println(str);
  }

  /**
   * Дано натуральное число n, определяющее возраст человека (в годах). Дать для этого числа
   * наименования «год», «года» или «лет»: например, 1 год, 23 года, 45 лет и т. д./
   */
  private static void task7() {
    Random rnd = new Random();
    int age = rnd.nextInt(100);
    System.out.println(age);
    StringBuilder result = new StringBuilder();
    result.append(age).append(' ');
    if (age >= 11 && age <= 14) {
      result.append("лет");
    } else if (age % 10 == 1) {
      result.append("год");
    } else if (age % 10 >= 2 && age % 10 <= 4) {
      result.append("года");
    } else {
      result.append("лет");
    }
    System.out.println(result);
  }

  /**
   * Написать метод поиска в массиве ближайшего к 10 числа
   */
  private static void task8() {
    int[] ints = new int[]{21, -100, 200, 11, 19, 78};
    int closed = 0;
    int temp = Integer.MAX_VALUE;
    for (int i = 0; i < ints.length; i++) {
      int length = Math.abs(ints[i] - 10);
      if (length < temp) {
        temp = length;
        closed = ints[i];
      }
    }
    System.out.println(closed);
  }

  /**
   * Написать метод "переворачивания" integer Примеры: 123 -> 321, -698 -> -896, 120 -> 21
   */
  private static void task9() {
    Random rnd = new Random();
    int number = rnd.nextInt(1000);
    System.out.println(number);
    int finalNumber = 0;
    while (number % 10 != 0) {
      finalNumber = finalNumber * 10 + number % 10;
      number /= 10;
    }
    System.out.println(finalNumber);
  }

  /**
   * написать сортировку пузырьком
   */
  private static void task10() {
    int[] arr = {1, 4, 9, -1, 0, 6, 7, 4, 5, -1, 0, 23, -5, 43, 12};
    boolean sorted = false;
    int temp = 0;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          sorted = false;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Remove Element Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_] Input: nums =
   * [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3,_,_,_]
   */
  private static void task11() {
    int[] arr = {3, 2, 2, 3, 3};
    int value = 3;
    int count = 0;
    for (int i : arr) {
      if (i == value) {
        count++;
      }
    }
    System.out.println(count);
  }


  /**
   * Given an array nums of size n, return the majority element. Input: nums = [3,2,3] Output: 3
   * Input: nums = [2,2,1,1,1,2,2] Output: 2
   */
  private static void task12() {
    int[] arr = {3, 2, 92, 2, 3, 6};
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.println(max);
  }

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target. Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
   * Because nums[0] + nums[1] == 9, we return [0, 1]. Input: nums = [3,2,4], target = 6 Output:
   * [1,2]
   */
  private static void task13() {
    int[] arr = {3, 2, 4};
    int[] newArr = new int[2];
    int target = 6;
    int temp;

    for (int i = 0; i < arr.length; i++) {
      temp = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (temp + arr[j] == target) {
          newArr[0] = i;
          newArr[1] = j;
          break;
        }
      }
    }
    System.out.println(Arrays.toString(newArr));
  }

  /**
   * Given an integer x, return true if x is a palindrome , and false otherwise. Input: x = 121
   * Output: true Explanation: 121 reads as 121 from left to right and from right to left. Input: x
   * = -121 Output: false Explanation: From left to right, it reads -121. From right to left, it
   * becomes 121-. Therefore it is not a palindrome.
   */
  private static void task14() {
    int x = 1001;
    int newNumber = 0;
    int temp = x;
    if (x < 0) {
      System.out.println("false");
    }
    while (temp > 0) {
      newNumber = newNumber * 10 + temp % 10;
      temp /= 10;
      System.out.println(temp);
    }
    System.out.println(x == newNumber);
  }

  /**
   * программа перевода римских цифр в обычные
   */
  private static void task15() {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    String romanNumber = "MCMXCIV";
    romanNumber = romanNumber.replace("IV", "IIII");
    romanNumber = romanNumber.replace("IX", "VIIII");
    romanNumber = romanNumber.replace("XL", "XXXX");
    romanNumber = romanNumber.replace("XC", "LXXXX");
    romanNumber = romanNumber.replace("CD", "CCCC");
    romanNumber = romanNumber.replace("CM", "DCCCC");
    int finalNumber = 0;
    System.out.println(romanNumber);
    for (int i = 0; i < romanNumber.length(); i++) {
      finalNumber += map.get(romanNumber.charAt(i));
    }
    System.out.println(finalNumber);
  }

  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
   * the input string is valid.
   */
  private static void task16() {
    //используем стэк
    String s = "({})";
    boolean flag;
    Stack<Character> leftSymbols = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        leftSymbols.push(c);
      } else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
        leftSymbols.pop();
      } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
        leftSymbols.pop();
      } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
        leftSymbols.pop();
      } else {
        flag = false;
        System.out.println(flag);
      }
    }
    System.out.println(leftSymbols.isEmpty());
  }

  /**
   * приходит отсортированный массив с дубликатами, нужно убрать дубликаты и вернуть число
   * недублирующихся элементов
   */
  private static void task17() {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
        continue;
      }
      nums[count] = nums[i];
      count++;
    }
    System.out.println(count);
  }

  /**
   * приходит массив и k, нужно убрать все совпадения k и переписать массив
   */
  private static void task18() {
    int[] nums = {3,2,2,3};
    int val = 3;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        continue;
      }
      nums[count] = nums[i];
      count++;
    }
    System.out.println(count);
    System.out.println(Arrays.toString(nums));
  }

  /**
   * Given two strings needle and haystack, return the index of the first occurrence
   * of needle in haystack, or -1 if needle is not part of haystack.
   */
  private static void task19() {
    String haystack = "leetcode", needle = "leeto";

    int i = haystack.indexOf(needle);
    System.out.println(i);


  }


}



