package com.daniel.to_do_list;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UsersController {

    public ArrayList<User> users;
    public static int loggedUserId;

    public UsersController(){
        users = UsersFileManager.users;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void updateUsers() throws IOException {
        UsersFileManager.readUsers();
    }
}
