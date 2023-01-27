package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController   //it will tell to java compiler, In this class we will have REST API's.
public class StudentController{

//        //now i want to store the information
//        Map<Integer,Student> db=new HashMap<>(); // here key is the rollno(Integer),value is(Student)Student information
//
//        //Adding the information
//        @PostMapping("/add_student")   //end point
//        //adding using request body
//        public String addStudent(@RequestBody Student student){  //this student object is given by client.
//            int rollNo=student.getRollNo();  // here i will get rollno in all information (from Class Student)
//            db.put(rollNo,student);          // here i will add student in hashmap along with rollno.
//            return "Student added successfully";
//
//        }
//
//        //get information
//    //using requestparameter
//        @GetMapping("/get_student")  // end point
//        public Student getStudent(@RequestParam("q") int rollNo){ // here i getting the information of student based on rollNo.
//            return db.get(rollNo);
//        }
//
//       //get information
//    //using path parameter
////    @GetMapping("/get_student/{rollNo}")
////    public Student getStudent (@PathVariable("rollNo") int rollNo){
////        return db.get(rollNo);
////    }
//
//
//    //here i delete the student from database
//    @DeleteMapping("/delete_student")
//    public String deleteStudent(@RequestParam("rollNo") int rollNo){
//            db.remove(rollNo);
//            return "Student deleted successfully";
//    }
//
//    //here i update a student details
//    @PutMapping("/update_student")
//    public String updateStudent(@RequestParam("rollNo") int rollNo,@RequestParam("name") String name){
//            if(!db.containsKey(rollNo)){
//                return "Invalid rollNo";
//            }
//
//            Student student=db.get(rollNo);
//            student.setName(name);
//
//            return "Updated Successfully";
//    }

    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int rollNo){
        return studentService.getStudent(rollNo);
    }

    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("p") int rollNo){
        return studentService.deleteStudent(rollNo);
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("rollNo") int rollNo,@RequestParam("name") String name){
        return studentService.updateStudent(rollNo,name);
    }


}
