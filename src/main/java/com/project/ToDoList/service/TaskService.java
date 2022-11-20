package com.project.ToDoList.service;

import com.project.ToDoList.entity.Task;
import com.project.ToDoList.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TodoListRepository todoListRepository;

    public Optional<Task> getTask(final long id){
        return todoListRepository.findById(id);
    }

    public Iterable<Task> getTasks() {
        return todoListRepository.findAll();
    }

    public void deleteTask(final long id){
        todoListRepository.deleteById(id);
    }

    public Task saveTask(Task task){
        Task taskSaved = todoListRepository.save(task);
        return taskSaved;
    }

}
