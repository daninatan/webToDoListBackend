package com.daniel.to_do_list;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class loginController {
    private final String username = "adm";
    private final String password = "adm@123";

    @PostMapping("")
    public boolean login(@RequestBody User user){
        if(user.username().equals(username) && user.password().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
