package com.nest.ComplaintAppBackend.controller;

import com.nest.ComplaintAppBackend.dao.UserDao;
import com.nest.ComplaintAppBackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {
    @Autowired
    private UserDao udao;

    @GetMapping("/")
    public String HomePage(){
        return "Welcome Page";
    }

    @PostMapping(path = "/userReg", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserRegistration(@RequestBody UserModel um){
        udao.save(um);
        HashMap<String, String> hm = new HashMap<>();
        hm.put("status","success");
        return hm;
    }

}
