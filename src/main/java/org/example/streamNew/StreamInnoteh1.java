package org.example.streamNew;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.example.streamNew.util.Author;
import org.example.streamNew.util.Book;

public class StreamInnoteh1 {

  public static void main(String[] args) {

//    task1();
//    task2();
//    task3();
    task4();
  }

  //1) что выведется на консоль
  private static void task1() {
    Stream.of(new Phone(1, "1"), new Phone(2, "2"))
        .map(Object::toString)
        .peek(System.out::print)
        .peek(System.out::print)
        .filter(s -> s.startsWith("2"))
        .forEach(System.out::print);
  }

  //Вернуть лист <String> без повторений title всех авторов(уникальных названий книг)
  private static void task2() {
    Author author1 = new Author("Ivan",
        Arrays.asList(new Book("A"), new Book("B"), new Book("C"), new Book("A")));
    Author author2 = new Author("Petr",
        Arrays.asList(new Book("A"), new Book("B"), new Book("D")));
    List<Author> authors = List.of(author1, author2);
    List<String> titles = authors.stream()
        .flatMap(n -> n.getBooks().stream())
        .map(Book::getTitle)
        .distinct()
        .toList();
    titles.forEach(System.out::println);


  }

  //Дан лист студентов. Необходимо вычислить среднюю оценку всех студентов, где оценки выше или равны 4
  private static void task3() {
    List<Student> list = new ArrayList<>();
    list.add(new Student(List.of(5, 4, 3, 12, 4, 11)));
    list.add(new Student(List.of(4, 5, 2, 32, 2, 12)));
    list.add(new Student(List.of(3, 4, 5)));

    double number = list.stream()
        .flatMap(n -> n.getMarks().stream())
        .filter(n -> n >= 4)
        .collect(Collectors.averagingInt(n -> n));
    System.out.println(number);
  }

  //10) вывести пары для чисел, которые встрчаются более 2 раз
//<число из списка> <сколько раз число повторяется>
//10->4
  private static void task4() {
    int[] mas = {10, 15, 23, 10, 15, 10, 66, 10, 66, 15};

    Map<Integer, Integer> map = Arrays.stream(mas).boxed()
        .collect(Collectors.toMap(k -> k, v -> 1,Integer::sum));
    map.entrySet().stream()
            .filter(k->k.getValue()>2)
                .forEach(k->System.out.println(k.getKey() + "->" + k.getValue()));

  }


  static class Phone {

    private int code;
    private String number;

    public Phone(int code, String number) {
      this.code = code;
      this.number = number;
    }

    @Override
    public String toString() {
      return number;
    }
  }

  static class Student {

    public List<Integer> marks;

    public List<Integer> getMarks() {
      return marks;
    }

    public void setMarks(List<Integer> marks) {
      this.marks = marks;
    }

    public Student(List<Integer> marks) {
      this.marks = marks;
    }

  }
}
