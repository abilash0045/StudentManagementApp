package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String add_student(Student student){
        return studentRepository.add_student(student);
    }

    public Student get_student(int admnNo){
        return studentRepository.get_student(admnNo);
    }
    public Student get_student(String name){
        return studentRepository.get_student(name);
    }

    public String update_student(int admnNo,int age,String state){
        return studentRepository.update_student(admnNo,age,state);
    }

    public String delete_student(int admnNo){
        return studentRepository.delete_student(admnNo);
    }
}
