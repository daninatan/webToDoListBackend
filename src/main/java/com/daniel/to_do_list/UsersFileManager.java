package com.daniel.to_do_list;

import java.io.*;
import java.util.ArrayList;

public class UsersFileManager {
    public static ArrayList<User> users = new ArrayList<>();
    public static File file = new File("users.csv");

    static{
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readUsers() throws IOException {
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
            User newUser = new User(data[0], data[1], Integer.parseInt(data[2]));
            users.add(newUser);
        }
        reader.close();
    }


}
