package com.daniel.to_do_list;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

public class TasksController {
    public ArrayList<Task> tasks;
    FileManager fileManager;

    public TasksController() throws IOException {
        fileManager = new FileManager();
        fileManager.readTasks();
        tasks = fileManager.getTasks();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) throws IOException {
        tasks.add(task);
        updateTasks();
    }

    public void removeTask(int id) throws IOException {
        for(Task task : tasks){
            if(task.id() == id){
                tasks.remove(task);
                break;
            }
        }
        updateTasks();
    }

    public void updateTasks() throws IOException {
        fileManager.tasks = tasks;
        fileManager.writeTasks();
    }
}
