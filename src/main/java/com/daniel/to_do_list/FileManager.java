package com.daniel.to_do_list;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public ArrayList<Task> tasks = new ArrayList<>();
    public File file;

    public FileManager() {
        file  = new File("tasks" + UsersController.loggedUserId + ".csv");
        createFile();
    }

    public void createFile(){
        file = new File("tasks" + UsersController.loggedUserId + ".csv");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void readTasks() throws IOException {
        BufferedReader reader;

        {
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        
        String line;
        while((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Task newTask = new Task(data[0], Integer.parseInt(data[1]));
            tasks.add(newTask);
        }
        reader.close();
    }

    public void writeTasks() throws IOException {
        BufferedWriter writer;

        {
            try{
                writer = new BufferedWriter(new FileWriter(file, false));
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }

        for(Task task : tasks) {
            writer.write(task.name() + "," + task.id() + "\n");
        }

        writer.close();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
