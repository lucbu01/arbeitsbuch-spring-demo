package tech.bison.arbeitsbuch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.bison.arbeitsbuch.demo.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
