package br.com.duty.controllers;

import br.com.duty.models.User;
import br.com.duty.repositories.UserRepository;
import br.com.duty.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register/user")
    public String resgisterUser(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password){
        userService.createUser(name,email,password);
        return name +" "+email+" "+ password;
    }

    @PostMapping(path="/update/user/email")
    public String changeEmail(@RequestParam("userId") Integer userId,
                              @RequestParam("email") String email){
       userService.updateUserEmail(userId,email);
        return email;
    }

    @PostMapping(path="/update/user/password")
    public String changePassword( @RequestParam("userId") Integer userId,
                                  @RequestParam("password") String password){
        userService.updateUserPassword(userId,password);
        return password;
    }

    @GetMapping(path="/user/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserInfo( @RequestParam(value = "userId", required = false) Integer userId){
        return userService.getUser(Optional.ofNullable(userId));
    }





}
