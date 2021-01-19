package tech.bison.arbeitsbuch.demo.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.bison.arbeitsbuch.demo.model.ToDo;

@Data
@NoArgsConstructor
public class ToDoDto {

  private Long id;

  private String name;

  private LocalDate until;

  public ToDoDto(ToDo todo) {
    id = todo.getId();
    name = todo.getName();
    until = todo.getUntil();
  }

}
