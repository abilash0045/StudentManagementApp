package com.avengers.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    // function to add students
    @PostMapping("/add_student")
    public String add_student(@RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successfully";
    }

    // function to get student by admnNo
    @GetMapping("/get_student")
    public Student get_student(@RequestParam("q") int admnNo){
        return db.get(admnNo);
    }
    // function to get student by name
    @GetMapping("/get_student/{name}")
    public Student get_student(@PathVariable("name") String name){
        for (Student student : db.values()){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
    // function to update student
    @PutMapping("/update_student")
    public String update_student(@RequestParam("admnNo") int admnNo,@RequestParam("age") int age,@RequestParam("state") String state){
        Student student = db.get(admnNo);
        student.setAge(age);
        student.setState(state);
        db.put(admnNo,student);
        return "Student updated Successfully";
    }
    // function to delete student
    @DeleteMapping("/delete_student")
    public String delete_student(@RequestParam("admnNo") int admnNo){
        db.remove(admnNo);
        return "Student deleted successfully";
    }
}
