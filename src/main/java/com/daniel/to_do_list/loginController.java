package com.daniel.to_do_list;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class loginController {

    public UsersController usersController = new UsersController();

    @PostMapping("")
    public boolean login(@RequestBody User user) throws IOException {
        usersController.updateUsers();
        for(User savedUser : usersController.getUsers()) {
            if (user.username().equals(savedUser.username()) && user.password().equals(savedUser.password())) {
                UsersController.loggedUserId = savedUser.id();
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/getUsers")
    public ArrayList<User> getUsers() throws IOException {
        usersController.updateUsers();
        return usersController.getUsers();
    }
}
