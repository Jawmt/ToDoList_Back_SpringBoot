package com.project.ToDoList.controller;

import com.project.ToDoList.entity.Task;
import com.project.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Read - Retourne l'ensemble des taches
     * @return Un iterable de l'ensemble des taches lie a l'objet task
     */
    @GetMapping("")
    @ResponseStatus(code= HttpStatus.OK)
    public Iterable<Task> getTasks(){
        return taskService.getTasks();
    }

    /**
     * Create - Ajout d'une nouvelle tache
     * @param task l'objet task
     * @return la task sauvegardee
     */
    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        try{
            Task _task = taskService.saveTask(task);
            return new ResponseEntity<>(_task, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete - Supression d'une tache
     * @param id L'id de la tache à supprimer
     *
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") final Long id){
        taskService.deleteTask(id);
    }

    /**
     * Modification d'une tache
     * @param id l'id de la task à modifier
     * @param task la task mis à jour
     * @return la task mis à jour
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> modifyTask(@PathVariable("id") Long id,@RequestBody Task task){
        Optional<Task> taskToModify = taskService.getTask(id);
        if(taskToModify.isPresent()){
            Task _taskToModify = taskToModify.get();
            _taskToModify.setTheTask(task.getTheTask());
            return new ResponseEntity<>(taskService.saveTask(_taskToModify),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
