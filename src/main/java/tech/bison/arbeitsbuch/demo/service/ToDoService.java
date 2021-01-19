package tech.bison.arbeitsbuch.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.bison.arbeitsbuch.demo.dto.ToDoDto;
import tech.bison.arbeitsbuch.demo.dto.ToDoListDto;
import tech.bison.arbeitsbuch.demo.model.ToDo;
import tech.bison.arbeitsbuch.demo.model.ToDoList;
import tech.bison.arbeitsbuch.demo.repository.ToDoListRepository;
import tech.bison.arbeitsbuch.demo.repository.ToDoRepository;

@Service
@Transactional
public class ToDoService {

  @Autowired
  private ToDoListRepository toDoListRepository;

  @Autowired
  private ToDoRepository toDoRepository;

  public Long createList(ToDoListDto list) {
    ToDoList todoList = toDoListRepository.save(new ToDoList());
    if (list.getItems() != null) {
      for (ToDoDto item : list.getItems()) {
        ToDo todo = toDoRepository.save(
            ToDo.builder().name(item.getName()).until(item.getUntil()).list(todoList).build());
        todoList.getItems().add(todo);
      }
    }
    return todoList.getId();
  }

  public Optional<ToDoListDto> getListDto(Long id) {
    Optional<ToDoList> list = get(id);
    if (list.isPresent()) {
      return Optional.of(convertToDto(list.get()));
    }
    return Optional.empty();
  }

  public void deleteList(Long id) {
    Optional<ToDoList> list = get(id);
    if (list.isPresent()) {
      for (ToDo item : list.get().getItems()) {
        toDoRepository.delete(item);
      }
      toDoListRepository.delete(list.get());
    }
  }

  private Optional<ToDoList> get(Long id) {
    return toDoListRepository.findById(id);
  }

  private ToDoListDto convertToDto(ToDoList todoList) {
    return new ToDoListDto(todoList);
  }

}
