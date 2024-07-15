package org.example.streamNew;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.streamNew.util.Employee;
import org.example.streamNew.util.Item;
import org.example.streamNew.util.User;
import org.example.streamNew.util.Worker;

public class Stream1 {

  public static void main(String[] args) {
//    test1();
//    test2();
//    test3();
//    test4();
//    test5();
//    test6();
//    test7();
//    test8();
//    test9();
//    test10();
//    test11();
//    test12();
//    test13();
//    test14();
//    test16();
//    test17();
//    test18();
//    test19();
//    test20();
//    test21();
//    test22();
    test23();

  }


  /*
   * У вас есть список целых чисел.
   * Объедините их, затем отфильтруйте уникальные значения и выведите результаты
   * */
  static void test1() {
    List<Integer> list1 = List.of(1, 2, 3, 4, 5);
    List<Integer> list2 = List.of(3, 4, 5, 6, 7);

    Stream.concat(list1.stream(), list2.stream())
        .distinct()
        .forEach(System.out::println);
  }

  /*
   * Посчитайте сумму всех чисел
   * */
  static void test2() {
    List<Integer> list1 = List.of(1, 2, 3, 4, 5);
    long l = list1.stream()
        .collect(Collectors.summingInt(n -> n));
    long x = list1.stream().reduce((a, b) -> a + b).get();
    System.out.println(l);
    System.out.println(x);
  }

  /*
   * Найдите первое четное число в списке целых чисел
   * */
  static void test3() {
    List<Integer> list1 = List.of(1, 2, 3, 4, 5);
    int l = list1.stream()
        .filter(n -> n % 2 == 0)
        .findFirst()
        .get();
    System.out.println(l);
  }

  /*
   * Преобразуйте список строк в одну строку, разделяя элементы запятой
   * */
  static void test4() {
    List<String> list = List.of("apple", "banana", "orange", "pear", "grape");
    String str1 = list.stream()
        .reduce((n, k) -> n + "," + k)
        .orElseThrow(() -> new RuntimeException("элемента нет"));
    String str2 = list.stream().collect(Collectors.joining(","));

    System.out.println(str1);
    System.out.println(str2);
  }

  /*
   * Отсортируйте список строк по длине и выведите отсортированный список
   * */
  static void test5() {
    List<String> list = List.of("apple", "banana", "orange", "pear", "grape");
    list.stream()
        .sorted(Comparator.comparing(String::length))
        .forEach(System.out::println);
  }

  /*
   * Получить список уникальных букв из списка слов
   * */
  static void test6() {
    List<String> list = List.of("apple", "banana", "orange", "pear", "grape");
    list.stream()
        .flatMap(n -> Arrays.stream(n.split("")))
        .distinct()
        .peek(n -> System.out.print(n))
        .collect(Collectors.toList());

    List<Character> kek = list.stream()
        .map(String::chars)
        .distinct()
        .flatMap(n -> n.boxed())
        .map(n -> Character.forDigit(n, 10))
        .collect(Collectors.toList());
    kek.forEach(System.out::println);
  }

  /*
   * Получить количество уникальных букв из списка слов
   * */
  static void test7() {
    List<String> list = List.of("apple", "banana", "orange", "pear", "grape");
    long l = list.stream()
        .map(String::chars)
        .distinct()
        .count();
    System.out.println(l);
  }

  /**
   * Вывести на экран отсортированный по возрастанию список городов в Uppercase начинающихся с М
   */
  static void test8() {
    List<String> myList = Arrays.asList("Moscow", "Madrid", "Saint-Petersburg", "Barcelona",
        "Milan", "Minsk");

    myList.stream()
        .filter(n -> n.startsWith("M"))
        .map(n -> n.toUpperCase())
        .sorted()
        .forEach(System.out::println);
  }

  /**
   * Получить 30 рандомных чисел в диапазоне до 100, Убрать все нечётные числа, Оставить только
   * уникальные, Отсортировать по убыванию, Результат поместить в лист
   */

  static void test9() {
    List<Integer> myList = Stream.generate(() -> new Random().nextInt(30))
        .limit(30)
        .filter(n -> n % 2 == 0)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .peek(System.out::println)
        .collect(Collectors.toList());
  }

  static void test10() {
    List<Worker> list = List.of(
        new Worker("Tom", 22, 100, "Manager"),
        new Worker("Max", 33, 100, "DevOps"),
        new Worker("Anna", 44, 150, "Top manager"),
        new Worker("Ted", 19, 122, "QA"),
        new Worker("Vladislav", 25, 500, "PM"));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("1) группировка списка рабочих по их должности(деление на списки)");
    // группировка списка рабочих по их должности(деление на списки)
    Map<String, List<Worker>> map1 = list.stream()
        .collect(Collectors.groupingBy(n -> n.getPosition()));
    map1.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("2) группировка списка рабочих по их должности(деление на множества)");
    Map<String, Set<Worker>> map2 = list.stream()
        .collect(Collectors.groupingBy(n -> n.getPosition(), Collectors.toSet()));
    map2.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("3) Подсчет количества рабочих занимаемых конкретную должность)");
    Map<String, Long> map3 = list.stream()
        .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));
    map3.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println(
        "4) группировка списка рабочих по их должности но нас интересуют только имена)");
    Map<String, Set<String>> map4 = list.stream()
        .collect(Collectors.groupingBy(Worker::getPosition,
            Collectors.mapping(Worker::getName, Collectors.toSet())));
    map4.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("5) Расчет средней зп для данной должности)");
    Map<String, Double> map5 = list.stream()
        .collect(Collectors.groupingBy(Worker::getPosition,
            Collectors.averagingDouble(n -> n.getSalary())));
    map5.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println(
        "6) группировка списка рабочих по их должности, рабочие представлены только именами единой строкой)");
    Map<String, String> map6 = list.stream()
        .collect(Collectors.groupingBy(Worker::getPosition,
            Collectors.mapping(Worker::getName, Collectors.joining(","))));

    map6.forEach((k, v) -> System.out.println(k + "  " + v));
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("7) группировка списка рабочих по их должности и возрасту)");
    Map<String, Map<Integer, List<Worker>>> map7 = list.stream()
        .collect(Collectors.groupingBy(Worker::getPosition, Collectors.groupingBy(Worker::getAge)));

    map7.forEach((k, v) -> System.out.println(k + "  " + v));
  }

  /*
сумма квадратов четных чисел
*/
  static void test11() {
    List<Integer> list = List.of(1, 2, 5, 7, 9, 4, 8, 9, 0, 4, 53, 23, 87);
    long l = list.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n)
        .reduce((a, b) -> a + b)
        .orElseThrow(() -> new RuntimeException("loh"));
    System.out.println(l);
  }

  /*
собрать в мапу четные и нечетные числа раздельно, в значениях просуммировать их
*/
  static void test12() {
    List<Integer> list = List.of(1, 2, 5, 7, 9, 4, 8, 9, 0, 4, 53, 23, 87);
    Map<String, Integer> map1 = list.stream()
        .collect(Collectors.groupingBy(n -> {
          if (n % 2 == 0) {
            return "четные";
          } else {
            return "нечетные";
          }
        }, Collectors.summingInt(x -> x)));
    map1.forEach((k, v) -> System.out.println(k + " = " + v));
  }

  /*
Вернуть количество уникальных слов
*/
  static void test13() {
    List<String> sentences = Arrays.asList("Hello, how are you?",
        "I hope you are doing well.",
        "Hello, again!",
        "You are welcome.");
    long l = sentences.stream()
        .flatMap(str -> Arrays.stream(str.split(" ")))
        .map(str -> str.toUpperCase())
        .distinct()
        .count();
    System.out.println(l);
  }

  /*
  filter>10, отсортировать по убыванию, положить в лист
  */
  static void test14() {
    int[] arr1 = {2, 5, 8, 6, 54, 67, 8, 9, 1, 3, 5, 7, 8, 5, 34, 48, 12, 34, 90};
    List<Integer> list = Arrays.stream(arr1)
        .boxed()
        .filter(n -> n > 10)
        .sorted(Comparator.reverseOrder())
        .peek(System.out::println)
        .collect(Collectors.toList());
  }

  /*
  вернуть список user у которых группа начинается на "x"
  */
  static void test15() {
    Stream<User> userStream = Stream.generate(() -> new User()).limit(10);
    List<User> list = userStream.
        filter(n -> n.getGroups().stream()
            .anyMatch(x -> x.getName().startsWith("х")))
        .toList();
  }

  /*
Группируем элементы по категориям и вычисляем сумму значений в каждой категории
*/
  static void test16() {
    List<Item> items = Arrays.asList(
        new Item("A", 10),
        new Item("B", 20),
        new Item("A", 30),
        new Item("B", 40),
        new Item("C", 50));
    Map<String, Integer> map = items.stream()
        .collect(
            Collectors.groupingBy(n -> n.getCategory(), Collectors.summingInt(n -> n.getValue())));
    map.forEach((k, v) -> System.out.println(k + " = " + v));
  }

  /*
 из списка Employee вернуть список Employee департамента "IT" с полным временем работы
 */
  static void test17() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    List<Employee> emp = items.stream()
        .filter(n -> n.getDepartment().startsWith("IT") & n.isFullTime())
        .peek(System.out::println)
        .toList();
  }

  /*
вернуть отдельные списки сотрудников по каждому департаменту
 */
  static void test18() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    Map<String, List<Employee>> map = items.stream()
        .collect(Collectors.groupingBy(n -> n.getDepartment()));
    map.forEach((k, v) -> System.out.println(k + " = " + v));
  }

  /*
выбрать сотрудника с max зарплатой
*/
  static void test19() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    Employee emp = items.stream()
        .max(Comparator.comparing(n -> n.getSalary()))
        .get();
    System.out.println(emp);


  }

  /*
вывести среднюю зарплату работников по заданному отделу
*/
  static void test20() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    Double double1 = items.stream()
        .filter(e -> e.getDepartment().equals("Бухгалтерия"))
        .collect(Collectors.averagingDouble(n -> n.getSalary()));
    System.out.println(double1);
  }

  /*
вывести все телефоны всех работников, в списке должны быть отсортированы по уменьшению длины номера
*/
  static void test21() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    List<String> list = items.stream()
        .flatMap(n -> n.getPhones().stream())
        .sorted(Comparator.comparing(String::length).reversed())
        .toList();
    System.out.println(list);
  }

  /*
задача собрать их email если он не пустой, вернуть группируя по  department
*/
  static void test22() {
    List<Employee> items = Arrays.asList(
        new Employee("Иван Петров", "Отдел продаж", true, 50000, List.of("+380 67 999 12 34 ")),
        new Employee("Мария Сидорова", "Бухгалтерия", false, 30000, List.of("+91 852 456 78 90")),
        new Employee("Сергей Иванов", "IT-отдел", true, 70000, List.of("+7 926 555 123 45 ")),
        new Employee("Елена Смирнова", "Маркетинг", true, 60000, List.of("+44 20 333 111 22 ")),
        new Employee("Дмитрий Васильев", "Производство", true, 80000, List.of("+1 555 432 1234")),
        new Employee("Анна Петрова", "HR-отдел", false, 40000, List.of("+86 135 000 1234")),
        new Employee("Александр Смирнов", "Логистика", true, 90000, List.of("+61 412 312 123")));
    Map<String, List<String>> map = items.stream()
        .filter(n -> n.getName() != null)
        .collect(
            Collectors.groupingBy(n -> n.getDepartment(),
                Collectors.mapping(n -> n.getName(), Collectors.toList())));
    // System.out.println(map);

    Map<String, List<Employee>> map2 = items.stream()
        .collect(Collectors.toMap(n -> n.getDepartment(), n -> List.of(n)));
    map2.forEach((k, v) -> System.out.println(k + " = " + v));

  }

  public static void test23() {
    List<Integer> list = Stream.generate(() -> new Random().nextInt(100))
        .limit(30)
        .filter(n -> n % 2 == 0)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    System.out.println(list);


  }


}





