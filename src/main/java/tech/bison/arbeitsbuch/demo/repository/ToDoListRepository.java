package tech.bison.arbeitsbuch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.bison.arbeitsbuch.demo.model.ToDoList;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
