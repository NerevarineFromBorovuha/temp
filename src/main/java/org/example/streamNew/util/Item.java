package org.example.streamNew.util;

public class Item {

  private String category;
  private int value;

  public Item(String category, int value) {
    this.category = category;
    this.value = value;
  }

  public String getCategory() {
    return category;
  }

  public int getValue() {
    return value;
  }
}
