package tech.bison.arbeitsbuch.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.bison.arbeitsbuch.demo.model.ToDoList;

@Data
@NoArgsConstructor
public class ToDoListDto {

  private Long id;

  private List<ToDoDto> items;

  public ToDoListDto(ToDoList list) {
    id = list.getId();
    items = list.getItems().stream().map(ToDoDto::new).collect(Collectors.toList());
  }

}
