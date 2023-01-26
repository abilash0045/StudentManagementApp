package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity add_student(@RequestBody Student student){
        String response =  studentService.add_student(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_student")
    public ResponseEntity get_student(@RequestParam("q") int admnNo){
        Student response = studentService.get_student(admnNo);
        if (response == null){
            return new ResponseEntity<>("Invalid admnNo",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @GetMapping("/get_student/{name}")
    public ResponseEntity get_student(@PathVariable("name") String name){
        Student response = studentService.get_student(name);
        if (response == null){
            return new ResponseEntity<>("Invalid admnNo",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @PutMapping("/update_student")
    public ResponseEntity update_student(@RequestParam("admnNo") int admnNo,@RequestParam("age") int age,@RequestParam("state") String state){
        String response = studentService.update_student(admnNo,age,state);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete_student")
    public ResponseEntity delete_student(@RequestParam("admnNo") int admnNo){
        String response = studentService.delete_student(admnNo);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
