package org.example.streamNew.util;

import java.util.List;
import lombok.Data;

@Data
public class User {

  private String name;
  private Integer age;
  private List<Groups> groups;

}
