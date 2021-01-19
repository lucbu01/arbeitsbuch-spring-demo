package tech.bison.arbeitsbuch.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.bison.arbeitsbuch.demo.dto.ToDoListDto;
import tech.bison.arbeitsbuch.demo.service.ToDoService;

@RestController
@RequestMapping( //
    path = "${spring.data.rest.base-path}/todo")
public class ToDoController {

  @Autowired
  private ToDoService toDoService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Long createList(@RequestBody ToDoListDto list) {
    return toDoService.createList(list);
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ToDoListDto> getList(@PathVariable Long id) {
    return ResponseEntity.of(toDoService.getListDto(id));
  }

  @DeleteMapping(path = "/{id}")
  public void deleteList(@PathVariable Long id) {
    toDoService.deleteList(id);
  }
}
