package com.nest.ComplaintAppBackend.controller;

import com.nest.ComplaintAppBackend.dao.ComplaintDao;
import com.nest.ComplaintAppBackend.model.ComplaintsModel;
import com.nest.ComplaintAppBackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {
    @Autowired
    private ComplaintDao cdao;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addComplaint", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> AddComplaint(@RequestBody ComplaintsModel cm){
        LocalDateTime now = LocalDateTime.now();
        cm.setDate(dtf.format(now));
        cdao.save(cm);
        HashMap<String ,String > hm = new HashMap<>();
        hm.put("status","success");
        return hm;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewComplaint")
    public List<Map<String, String>> ViewComplaint(){
        return (List<Map<String, String>>) cdao.GetComplaints();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewUserComplaint", consumes = "application/json", produces = "application/json")
    public List<Map<String, String>> ViewUserComplaint(@RequestBody UserModel um){
        return (List<Map<String, String>>) cdao.GetUserComplaint(um.getId());
    }

}
