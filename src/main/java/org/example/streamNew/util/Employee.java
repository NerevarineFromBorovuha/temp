package org.example.streamNew.util;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Employee {
  private String name;
  private String department;
  private boolean isFullTime;
  private double salary;
  private List<String> phones;

}
