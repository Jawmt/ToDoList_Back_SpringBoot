package com.project.ToDoList.repository;

import com.project.ToDoList.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<Task, Long> {
}
