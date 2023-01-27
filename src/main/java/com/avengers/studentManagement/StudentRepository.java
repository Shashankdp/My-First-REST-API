package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    //repository layer is related to Database
    Map<Integer,Student> db=new HashMap<>();  //this is my db

    //now i implement a 4 methods here(adding,getting,deleting,updating).
    public String addStudent(Student student){
        int id=student.getRollNo();
        db.put(id,student);

        return "Added successfully";
    }

    public Student getStudent(int rollNo){
        return db.get(rollNo);
    }

    public String deleteStudent(int rollNo){
        if(!db.containsKey(rollNo)){
            return "Invalid rollNo";
        }

        db.remove(rollNo);
        return "Deleted successfully";
    }

    public String updateStudent(int rollNo,String name){
        if(!db.containsKey(rollNo)){
           return "Invalid rollNo";
        }

        Student student=db.get(rollNo);
        student.setName(name);
        return "Updated successfully";
    }
}
