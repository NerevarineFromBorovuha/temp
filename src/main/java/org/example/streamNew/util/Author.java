package org.example.streamNew.util;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public class Author {
  private String name;
  private final List<Book> books;

  public Author(String name, List<Book> books) {
    this.name = name;
    this.books = books;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }
}
