package com.daniel.to_do_list;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/toDoList")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})

public class ToDoListController {

    TasksController tasksController = new TasksController();

    public ToDoListController() throws IOException {
    }

    @RequestMapping("/getTasks")
    public ArrayList<Task> getTask() {
        return tasksController.getTasks();
    }
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable String id) throws IOException {
        tasksController.removeTask(Integer.parseInt(id));
    }

    @PostMapping("/addTask")
    public void addTask(@RequestBody Task dados) throws IOException {
        tasksController.addTask(dados);
    }

    @RequestMapping("/update")
    public void updateTask() throws IOException {
        tasksController.updateTasks();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
