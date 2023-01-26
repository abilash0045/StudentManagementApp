package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public String add_student(Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successfully";
    }

    //Get by admnNo
    public Student get_student(int admnNo){
        if (db.containsKey(admnNo))
            return db.get(admnNo);
        return null;
    }

    //Get by name
    public Student get_student(String name){
        for (Student student : db.values()){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
    public String update_student(int admnNo,int age,String state){
        Student student = db.get(admnNo);
        student.setAge(age);
        student.setState(state);
        db.put(admnNo,student);
        return "Student updated Successfully";
    }

    public String delete_student(int admnNo){
        db.remove(admnNo);
        return "Student deleted successfully";
    }
}
