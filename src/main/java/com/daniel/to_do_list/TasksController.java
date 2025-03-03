package com.daniel.to_do_list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TasksController {
    ArrayList<Task> tasks;

    public TasksController() throws IOException {
        FileManager.readTasks();
        tasks = FileManager.tasks;
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
        FileManager.tasks = tasks;
        FileManager.writeTasks();
    }
}
