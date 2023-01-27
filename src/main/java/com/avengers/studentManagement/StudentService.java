package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //service layer want to talk with repository layer

    @Autowired  //Autowired is used to create object ,of layers.
    StudentRepository studentRepository;   //object of StudentRepository class

    public String addStudent(Student student){
        return studentRepository.addStudent(student);   //here i will call the function of StudentRepository class using studentRepository object name
    }

    public Student getStudent(int rollNo){
        return studentRepository.getStudent(rollNo);
    }

    public String deleteStudent(int rollNo){
        return studentRepository.deleteStudent(rollNo);
    }

    public String updateStudent(int rollNo,String name){
        return studentRepository.updateStudent(rollNo,name);
    }

}
